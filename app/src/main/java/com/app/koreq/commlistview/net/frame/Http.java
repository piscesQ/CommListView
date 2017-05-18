package com.app.koreq.commlistview.net.frame;

import com.app.koreq.commlistview.net.frame.transformer.StringTransformer;
import com.app.koreq.commlistview.utils.AESUtils;
import com.app.koreq.commlistview.utils.Config;
import com.app.koreq.commlistview.utils.FileUtils;
import com.app.koreq.commlistview.utils.GsonUtils;
import com.app.koreq.commlistview.utils.JSONUtils;
import com.app.koreq.netlib.bean.BaseRequest;
import com.app.koreq.netlib.bean.HttpApiParams;
import com.app.koreq.netlib.http.HttpApi;
import com.app.koreq.netlib.http.HttpConstants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

/**
 * project : CommListView
 * author : YanBin on 4/19/17
 * version : v3.2
 * description : 网络代理层 ，用于屏蔽底层网络框架， 解耦和
 */
public class Http {

    private static Retrofit mRetrofitIns;
    public static final int MAX_CACHE_TIME = 5 * 60;    //缓存时间
    public static final int HTTP_TIMEOUT = 15;  //请求超时
    public static final int HTTP_RW_TIMEOUT = 20;   //读写超时

    public static final int PARAMS_TYPE_ORIGIN = 0;     //最原始的参数处理方式,也不加密
    public static final int PARAMS_TYPE_TR = 1;         //参数加密后放入data内

    public static Retrofit getInstance() {

        if (mRetrofitIns == null) {
            mRetrofitIns = new Retrofit.Builder()
                    .client(initOkHttpClient())
                    .baseUrl(HttpUtils.getHostByEnv())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return mRetrofitIns;
    }

    private static OkHttpClient initOkHttpClient() {
        OkHttpClient.Builder build = new OkHttpClient.Builder();
        if (Config.IS_DEBUG) {
            //增加日志拦截器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            build.addInterceptor(loggingInterceptor);
        }

        File cacheFile = new File(FileUtils.getInnerCacheDir(), "httpCache");
        Cache httpCache = new Cache(cacheFile, 50 * 1024 * 1024);
//        Interceptor cacheInterceptor = chain -> {
//
//            Request request = chain.request();
//            Response response = chain.proceed(request);
//            if (NetUtils.isNetworkConnected()) {
//                response = response.newBuilder()
//                        .header("Cache-Control", "public,max-age=" + MAX_CACHE_TIME)
//                        .removeHeader("Pragma")
//                        .build();
//            }
//            return response;
//        };
        build.cache(httpCache);
//        build.addNetworkInterceptor(cacheInterceptor);
        build.connectTimeout(HTTP_TIMEOUT, TimeUnit.SECONDS);
        build.readTimeout(HTTP_RW_TIMEOUT, TimeUnit.SECONDS);
        build.writeTimeout(HTTP_RW_TIMEOUT, TimeUnit.SECONDS);
        build.retryOnConnectionFailure(true);   //错误重连
        return build.build();
    }

    /**
     * 以最原始的方式进行网络请求，同时参数也不加密
     *
     * @param request
     */
    public static void sendOriginRequest(BaseRequest request) {
        sendRequest(request, PARAMS_TYPE_ORIGIN);
    }

    /**
     * 将所有请求数据加密后放入data中，然后再封装一层后，再请求
     *
     * @param request
     */
    public static void sendTrRequest(BaseRequest request) {
        sendRequest(request, PARAMS_TYPE_TR);
    }

    /**
     * Core method
     * 发送网络请求
     *
     * @param request    请求和响应的处理类，包含Sbuscriber 和 反序列化的类型
     * @param paramsType 定义参数处理方式
     */
    private static void sendRequest(final BaseRequest request, int paramsType) {
        Retrofit instance = getInstance();
        HttpApi httpApi = instance.create(HttpApi.class);

        Map<String, String> params = new HashMap<>();
        switch (paramsType) {
            case PARAMS_TYPE_ORIGIN:
                params = dealParams2Map(request.getParams());
                break;
            case PARAMS_TYPE_TR:
                params = dealMapParams(request.getParams(), request.isEncrypt());
                break;
        }

        Observable<Response<ResponseBody>> responseObservable = null;

        int method = request.getRequestType();
        switch (method) {
            case HttpConstants.TYPE_POST:
                responseObservable = postRequest(httpApi, request.getUrl(), params);
                break;

            case HttpConstants.TYPE_GET:
                responseObservable = getRequest(httpApi, request.getUrl(), params);
                break;

            case HttpConstants.TYPE_POST_FORM:
                responseObservable = postFormRequest(httpApi, request.getUrl(), params);
                break;

            case HttpConstants.TYPE_DOWNLOAD:
                break;

            case HttpConstants.TYPE_UPLOAD:
                break;
        }

        if (responseObservable != null) {
            responseObservable.compose(new StringTransformer<>())
                    .map(new Func1<String, Object>() {
                        @Override
                        public Object call(String s) {
                            return GsonUtils.getGson().fromJson(s, request.getResponseType());
                        }
                    })
                    .subscribe(request.getSubscriber());
        }
    }

    /**
     * 执行get请求 参数以Map形式传递
     *
     * @param httpApi
     * @param url
     * @param params
     * @return
     */
    private static Observable<Response<ResponseBody>> getRequest(HttpApi httpApi, String url, Map<String, String> params) {
        return httpApi.getRequest(url, params);
    }

    /**
     * 执行post请求 参数以Map形式传递 - 请求以表单提交
     *
     * @param httpApi
     * @param url
     * @param params
     * @return
     */
    private static Observable<Response<ResponseBody>> postFormRequest(HttpApi httpApi, String url, Map<String, String> params) {
        return httpApi.postFormRequest(url, params);
    }

    /**
     * 执行post请求 参数以Map形式传递
     *
     * @param httpApi
     * @param url
     * @param params
     * @return
     */
    private static Observable<Response<ResponseBody>> postRequest(HttpApi httpApi, String url, Map<String, String> params) {
        return httpApi.postRequest(url, params);
    }

    /**
     * 参数封装、加密处理类 - 只有post才支持传入对象做参数
     *
     * @param params
     * @param isEncrypt
     * @return 返回一个对象
     */
    private static HttpApiParams dealObjParams(String params, boolean isEncrypt) {
        params = encryptAES(params, isEncrypt);

        HttpApiParams apiParams = new HttpApiParams();
        apiParams.setData(params);

        //=================================================
        //TODO 公参
        apiParams.setUuid("b80c1f46c3893a47");
        //=================================================

        return apiParams;
    }

    /**
     * 参数封装、加密处理类
     *
     * @param params
     * @param isEncrypt
     * @return 返回一个Map
     */
    private static HashMap<String, String> dealMapParams(String params, boolean isEncrypt) {
        params = encryptAES(params, isEncrypt);

        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", params);

        //==================================================
        //TODO 公参
        paramsMap.put("uuid", "b80c1f46c3893a47");
        //==================================================

        return paramsMap;
    }

    /**
     * 参数JSON 转成 map
     *
     * @param params
     * @return 返回一个Map
     */
    private static Map<String, String> dealParams2Map(String params) {
        return JSONUtils.json2Map(params);
    }

    /**
     * 加密处理
     *
     * @param params
     * @param isEncrypt
     * @return
     */
    private static String encryptAES(String params, boolean isEncrypt) {
        if (isEncrypt) {
            try {
                //TODO 加密处理
                params = AESUtils.encryptFromTr(AESUtils.AESKey, params);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return params;
    }
}
