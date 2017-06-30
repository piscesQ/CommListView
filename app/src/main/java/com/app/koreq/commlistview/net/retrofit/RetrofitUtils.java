package com.app.koreq.commlistview.net.retrofit;

import com.app.koreq.commlistview.net.frame.HttpUtils;
import com.app.koreq.commlistview.utils.Config;
import com.app.koreq.commlistview.utils.FileUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2_source.Retrofit;
import retrofit2_source.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2_source.converter.gson.GsonConverterFactory;

/**
 * project : CommListView
 * author : YanBin on 4/17/17
 * version : v3.2
 * description : retrofit utils
 */
public class RetrofitUtils {
    private static Retrofit mRetrofitIns;
    public static final int MAX_CACHE_TIME = 5 * 60;    //缓存时间
    public static final int HTTP_TIMEOUT = 15;  //请求超时
    public static final int HTTP_RW_TIMEOUT = 20;   //读写超时

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

    public static void doPost() {
        Retrofit retrofit = getInstance();
//        retrofit.create()

    }

    public static void doGet() {

    }

    public static void doDownload() {

    }

    public static void doUpdate() {

    }

    public static void cancelRequest() {

    }
}
