package com.app.koreq.commlistview.net.retrofit;

import android.util.Log;

import com.app.koreq.commlistview.net.bean.DemoBean;
import com.app.koreq.commlistview.net.bean.DemoListBean;
import com.app.koreq.commlistview.net.bean.DemoRequest;
import com.app.koreq.commlistview.utils.AESUtils;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * project : CommListView
 * author : YanBin on 3/27/17
 * version : v3.0
 * description :
 */
public class RetrofitDemoUtils {

    public static final String TAG = HttpConstant.TAG;
    public static final String BASE_URL = "https://pro.zhihuishu.bbtree.com/service/v2/";

    //    test url : http://api2.souyue.mobi/d3api2/community/community.news.list.groovy
//    http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%87%91%E5%88%9A%E7%8B%BC&bk_length=600
    public static int doGetRequest(Callback<DemoBean> callback) {
        int ret = 0;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://baike.baidu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DemoGetApi demoApi = retrofit.create(DemoGetApi.class);
        Call<DemoBean> baikeData = demoApi.getBaikeData("openapi", "600");
        baikeData.enqueue(callback);
        return ret;
    }

    /**
     * 获得反序列化的对象
     *
     * @param callback
     * @return
     */
    public static int doPostRequest(Callback<DemoListBean> callback) {
        int ret = 0;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DemoPostApi demoPostApi = retrofit.create(DemoPostApi.class);
        Call<DemoListBean> listData = demoPostApi.getListData("{\"data\":\"4XxVe0uWK4xRKHMpv6fDTwNK1ct0j66UGo/RgU8s/I1fnIJfeyuajAJc2NfqnJfrmBJI/HTxzHbZylNAxZktOqdGtvZ8AZqQrIy/YDqLI2hXA4020Umeay5dEf7xQH5BVSV1Sewp19/C01h8Ba+tihAD7ggvNBz8rxUYWp3w/heaOevT9jq6yD6nl7PERUDRjve+THc0QwplcaBYIZGZrDabDw2OPudFnyXeiG6Mb9ZcPDRcadSDtges15QyvNxEtnT/xmyCcR8OURlVqmBNIbSvauAPW4t3JaHg0iwLnaZRvyVUvA9NAG7JKLyCVbE3x2bMOLVnJU1hAwX+ehoBj9WcTGOASZZiV9TPGhVB6ougvFCmEKV3yuvUHqt5L6jl\",\"uuid\":\"b80c1f46c3893a47\"}");
        listData.enqueue(callback);
        return ret;
    }

    /**
     * 获得response的json
     *
     * @param callback
     * @return
     */
    public static int doPostJsonRequest(Callback<ResponseBody> callback) {
        int ret = 0;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DemoPostApi demoPostApi = retrofit.create(DemoPostApi.class);

        DemoRequest request = new DemoRequest();
        request.setData("7yBzesTb9fuAesM2f9bG1uqR8MNxwFGjDEmb1PfohpnKloFvK3LoNC7JIAvA0ba9Htc6ZbyHTXebsqNgNz9/C+oYX2aaUrjpBr7E7nvgi4lwehN8lBpR5ySoXj1dPD+sqAXncwyQVLgumXPPZRlOoYGWE0ktEO3a+BH4ZF0iUKVhS1xEG+nFGxfTjvj2lUL+i8HWKblb+3L18NUUNaSItUjTveyppsTjfbwLcCMz156cRxLnASdey3N8N+eY7dHBb1HXddNjMwv+q7j5hMopDX/mJbUxSSetLqmX/Rp0SPZQIDhOY1HmbEGi45ZxeenYpajywLlWRYZuIunVUtT+H8Vk0DqGHLLmvZQMH1t+Nyo5TsZbFN0iIhDMupLkSpWeY1WIQIFttTufw2dMR+63CtaYrloSyyDiGRTf8Q/swxjO/RgAyvZQYi0+0MV6mR0DR26cMQ0thjvVU7OiQfdY+a6v3SvOuzfBAUo8k8oZCI4RC8LM2w/tWI22ljEjS6oJ64vmh4lVXEhmhg/CV1XMqEyGz/tcdqRwv37taiMBTPVTwkfmTy9pIUIde98TDhT+o5skIbg0jCok3H62u3cGg+J3TlPzff6JZ40OKA5OjWKHMTgoW2N+8/xXPo2iifvSPAhzhJYPh9kYi/FsKbE9ovNSl/Z4TRHzhs8sfW6TSjrCu2Cmrdc/yLs1wPiQ1AbdjnJcICkLq7Pth87wWByRp/pKRx9mUnbe17GuSfeMKxXgTG59fFIj4XHc5NQ04M0Cf5gWY5P8R6DQ9F8DlDwXubPRsb3/qsgHH9wQ8iGbcHHv3Xht9UNNSBFpgwFml7+zKDsh1+UkCtAyHhf46DXBMninNRuIYwFv/p5eG4/3yyNHN9Ov1kLl7T1RPfkuwdqHCmaoiB1yB2aa2hxXeHeHal05IHjJTcSf+lVVqPT1gUpzDa+NVA0sAPvuWrrimupY5+5JUIV4O2IFT3fPyPghYD2b9j56rlCOAw/+wCdqOOV6d9aIXtGOi8k38ywSx5ZOq4PGUzBr4uYXZGnmDJ8MCEgGW6BtBrzrq3+0ei03QpzjcXSatxp7fgRYt3TaMJPUV1V3wfC32jhmxqKVjdzYpsO1cbMooDu98r9bvHZ0pgn/7c6U3dchEP/ua/YvyMRNgFWvefiPiZJzw88kIxmDP58B7Iz/cQTHQ92H69/aYaqjTz3SypFy736ttlWThgFOm7hzAOhKLudoQleWvdMpvw\u003d\u003d");
        request.setUuid("b80c1f46c3893a47");
        Call<ResponseBody> listData = demoPostApi.getListJsonData(request);
        listData.enqueue(callback);
        return ret;
    }

    /**
     * rxjava + retrofit 返回值为： Observable<Response<DemoBean>>
     *
     * @return
     */
    public static int doGetRxRequest() {
        int ret = 0;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://baike.baidu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())   //重要采用rxjava格式的adapter
                .build();
        DemoGetApi demoGetApi = retrofit.create(DemoGetApi.class);
        Observable<retrofit2.Response<DemoBean>> baikeData = demoGetApi.getRxBaikeData("openapi", "600");
        baikeData
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            Log.d(TAG, "response.body() = " + response.body());
                            Log.d(TAG, "demoBean.getDesc() = " + response.body().getDesc());
                        }
                        , throwable -> {
                            throwable.printStackTrace();
                            Log.d(TAG, "getRxRequest throwable");
                        }
                        , () -> Log.d(TAG, "getRxRequest completed!"));
        return ret; //未使用
    }

    /**
     * rxjava + retrofit 返回值为：Observable<DemoBean>
     *
     * @return
     */
    public static int doGetRxRequest2() {
        int ret = 0;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://baike.baidu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        DemoGetApi demoGetApi = retrofit.create(DemoGetApi.class);
        Observable<DemoBean> baikeData = demoGetApi.getRxBaikeData2("openapi", "600");
        baikeData
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(demoBean -> Log.d(TAG, "2-demoBean.getDesc() = " + demoBean.getDesc())
                        , throwable -> {
                            throwable.printStackTrace();
                            Log.d(TAG, "doGetRxRequest2 throwable");
                        }
                        , () -> Log.d(TAG, "doGetRxRequest2 completed!"));
        return ret; //未使用
    }


    /**
     * 直接返回json串
     * rxjava + retrofit 返回值为：Observable<ResponseBody>
     *
     * @return
     */
    public static int doGetRxJsonRequest() {
        int ret = 0;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://baike.baidu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        DemoGetApi demoGetApi = retrofit.create(DemoGetApi.class);
        Observable<ResponseBody> baikeJsonData = demoGetApi.getRxBaikeJsonData("openapi", "600");
        baikeJsonData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseBody -> {
                            try {
                                Log.d(TAG, "responseBody = " + responseBody.string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        , throwable -> {
                            throwable.printStackTrace();
                            Log.d(TAG, "doGetRxJsonRequest throwable");
                        }
                        , () -> Log.d(TAG, "doGetRxJsonRequest completed!"));
        return ret;
    }

    public static int doPostRxJsonRequest() {
        int ret = 0;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        DemoPostApi demoPostApi = retrofit.create(DemoPostApi.class);
        DemoRequest request = new DemoRequest();
        request.setData("7yBzesTb9fuAesM2f9bG1uqR8MNxwFGjDEmb1PfohpnKloFvK3LoNC7JIAvA0ba9Htc6ZbyHTXebsqNgNz9/C+oYX2aaUrjpBr7E7nvgi4lwehN8lBpR5ySoXj1dPD+sqAXncwyQVLgumXPPZRlOoYGWE0ktEO3a+BH4ZF0iUKVhS1xEG+nFGxfTjvj2lUL+i8HWKblb+3L18NUUNaSItUjTveyppsTjfbwLcCMz156cRxLnASdey3N8N+eY7dHBb1HXddNjMwv+q7j5hMopDX/mJbUxSSetLqmX/Rp0SPZQIDhOY1HmbEGi45ZxeenYpajywLlWRYZuIunVUtT+H8Vk0DqGHLLmvZQMH1t+Nyo5TsZbFN0iIhDMupLkSpWeY1WIQIFttTufw2dMR+63CtaYrloSyyDiGRTf8Q/swxjO/RgAyvZQYi0+0MV6mR0DR26cMQ0thjvVU7OiQfdY+a6v3SvOuzfBAUo8k8oZCI4RC8LM2w/tWI22ljEjS6oJ64vmh4lVXEhmhg/CV1XMqEyGz/tcdqRwv37taiMBTPVTwkfmTy9pIUIde98TDhT+o5skIbg0jCok3H62u3cGg+J3TlPzff6JZ40OKA5OjWKHMTgoW2N+8/xXPo2iifvSPAhzhJYPh9kYi/FsKbE9ovNSl/Z4TRHzhs8sfW6TSjrCu2Cmrdc/yLs1wPiQ1AbdjnJcICkLq7Pth87wWByRp/pKRx9mUnbe17GuSfeMKxXgTG59fFIj4XHc5NQ04M0Cf5gWY5P8R6DQ9F8DlDwXubPRsb3/qsgHH9wQ8iGbcHHv3Xht9UNNSBFpgwFml7+zKDsh1+UkCtAyHhf46DXBMninNRuIYwFv/p5eG4/3yyNHN9Ov1kLl7T1RPfkuwdqHCmaoiB1yB2aa2hxXeHeHal05IHjJTcSf+lVVqPT1gUpzDa+NVA0sAPvuWrrimupY5+5JUIV4O2IFT3fPyPghYD2b9j56rlCOAw/+wCdqOOV6d9aIXtGOi8k38ywSx5ZOq4PGUzBr4uYXZGnmDJ8MCEgGW6BtBrzrq3+0ei03QpzjcXSatxp7fgRYt3TaMJPUV1V3wfC32jhmxqKVjdzYpsO1cbMooDu98r9bvHZ0pgn/7c6U3dchEP/ua/YvyMRNgFWvefiPiZJzw88kIxmDP58B7Iz/cQTHQ92H69/aYaqjTz3SypFy736ttlWThgFOm7hzAOhKLudoQleWvdMpvw\u003d\u003d");
        request.setUuid("b80c1f46c3893a47");

        Observable<ResponseBody> listRxJsonData = demoPostApi.getListRxJsonData(request);
        listRxJsonData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseBody -> {
                            try {
                                String decrypt = AESUtils.decryptFormTr(AESUtils.AESKey, responseBody.string());
                                Log.d(TAG, "postRxJsonResponse = " + decrypt);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        , throwable -> {
                            throwable.printStackTrace();
                            Log.d(TAG, "doPostRxJsonRequest throwable");
                        }
                        , () -> Log.d(TAG, "doPostRxJsonRequest completed"));

        return ret;
    }

    public static int doRxResReq() {
        int ret = 0;
        Retrofit instance = RetrofitUtils.getInstance();
        DemoPostApi demoPostApi = instance.create(DemoPostApi.class);

        DemoRequest request = new DemoRequest();
        request.setData("7yBzesTb9fuAesM2f9bG1uqR8MNxwFGjDEmb1PfohpnKloFvK3LoNC7JIAvA0ba9Htc6ZbyHTXebsqNgNz9/C+oYX2aaUrjpBr7E7nvgi4lwehN8lBpR5ySoXj1dPD+sqAXncwyQVLgumXPPZRlOoYGWE0ktEO3a+BH4ZF0iUKVhS1xEG+nFGxfTjvj2lUL+i8HWKblb+3L18NUUNaSItUjTveyppsTjfbwLcCMz156cRxLnASdey3N8N+eY7dHBb1HXddNjMwv+q7j5hMopDX/mJbUxSSetLqmX/Rp0SPZQIDhOY1HmbEGi45ZxeenYpajywLlWRYZuIunVUtT+H8Vk0DqGHLLmvZQMH1t+Nyo5TsZbFN0iIhDMupLkSpWeY1WIQIFttTufw2dMR+63CtaYrloSyyDiGRTf8Q/swxjO/RgAyvZQYi0+0MV6mR0DR26cMQ0thjvVU7OiQfdY+a6v3SvOuzfBAUo8k8oZCI4RC8LM2w/tWI22ljEjS6oJ64vmh4lVXEhmhg/CV1XMqEyGz/tcdqRwv37taiMBTPVTwkfmTy9pIUIde98TDhT+o5skIbg0jCok3H62u3cGg+J3TlPzff6JZ40OKA5OjWKHMTgoW2N+8/xXPo2iifvSPAhzhJYPh9kYi/FsKbE9ovNSl/Z4TRHzhs8sfW6TSjrCu2Cmrdc/yLs1wPiQ1AbdjnJcICkLq7Pth87wWByRp/pKRx9mUnbe17GuSfeMKxXgTG59fFIj4XHc5NQ04M0Cf5gWY5P8R6DQ9F8DlDwXubPRsb3/qsgHH9wQ8iGbcHHv3Xht9UNNSBFpgwFml7+zKDsh1+UkCtAyHhf46DXBMninNRuIYwFv/p5eG4/3yyNHN9Ov1kLl7T1RPfkuwdqHCmaoiB1yB2aa2hxXeHeHal05IHjJTcSf+lVVqPT1gUpzDa+NVA0sAPvuWrrimupY5+5JUIV4O2IFT3fPyPghYD2b9j56rlCOAw/+wCdqOOV6d9aIXtGOi8k38ywSx5ZOq4PGUzBr4uYXZGnmDJ8MCEgGW6BtBrzrq3+0ei03QpzjcXSatxp7fgRYt3TaMJPUV1V3wfC32jhmxqKVjdzYpsO1cbMooDu98r9bvHZ0pgn/7c6U3dchEP/ua/YvyMRNgFWvefiPiZJzw88kIxmDP58B7Iz/cQTHQ92H69/aYaqjTz3SypFy736ttlWThgFOm7hzAOhKLudoQleWvdMpvw\u003d\u003d");
        request.setUuid("b80c1f46c3893a47");

        Observable<retrofit2.Response<ResponseBody>> listRxResData = demoPostApi.getListRxResData(request);
        listRxResData.compose(new StringTransformer<>())
                .subscribe(result -> {
                            try {
                                String code = String.valueOf(result);
                                Log.d(TAG, "post doRxResReq code = " + code);

//                                String decrypt = AESUtils.decryptFormTr(AESUtils.AESKey, responseBody.string());
//                                Log.d(TAG, "post doRxResReq body = " + decrypt);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        , throwable -> {
                            throwable.printStackTrace();
                            Log.d(TAG, "post doRxResReq throwable");
                        }
                        , () -> Log.d(TAG, "post doRxResReq completed"));
        return ret;
    }

    public static int doRxResReq2() {
        int ret = 0;
        Retrofit instance = RetrofitUtils.getInstance();
        DemoPostApi demoPostApi = instance.create(DemoPostApi.class);

        DemoRequest request = new DemoRequest();
        request.setData("7yBzesTb9fuAesM2f9bG1uqR8MNxwFGjDEmb1PfohpnKloFvK3LoNC7JIAvA0ba9Htc6ZbyHTXebsqNgNz9/C+oYX2aaUrjpBr7E7nvgi4lwehN8lBpR5ySoXj1dPD+sqAXncwyQVLgumXPPZRlOoYGWE0ktEO3a+BH4ZF0iUKVhS1xEG+nFGxfTjvj2lUL+i8HWKblb+3L18NUUNaSItUjTveyppsTjfbwLcCMz156cRxLnASdey3N8N+eY7dHBb1HXddNjMwv+q7j5hMopDX/mJbUxSSetLqmX/Rp0SPZQIDhOY1HmbEGi45ZxeenYpajywLlWRYZuIunVUtT+H8Vk0DqGHLLmvZQMH1t+Nyo5TsZbFN0iIhDMupLkSpWeY1WIQIFttTufw2dMR+63CtaYrloSyyDiGRTf8Q/swxjO/RgAyvZQYi0+0MV6mR0DR26cMQ0thjvVU7OiQfdY+a6v3SvOuzfBAUo8k8oZCI4RC8LM2w/tWI22ljEjS6oJ64vmh4lVXEhmhg/CV1XMqEyGz/tcdqRwv37taiMBTPVTwkfmTy9pIUIde98TDhT+o5skIbg0jCok3H62u3cGg+J3TlPzff6JZ40OKA5OjWKHMTgoW2N+8/xXPo2iifvSPAhzhJYPh9kYi/FsKbE9ovNSl/Z4TRHzhs8sfW6TSjrCu2Cmrdc/yLs1wPiQ1AbdjnJcICkLq7Pth87wWByRp/pKRx9mUnbe17GuSfeMKxXgTG59fFIj4XHc5NQ04M0Cf5gWY5P8R6DQ9F8DlDwXubPRsb3/qsgHH9wQ8iGbcHHv3Xht9UNNSBFpgwFml7+zKDsh1+UkCtAyHhf46DXBMninNRuIYwFv/p5eG4/3yyNHN9Ov1kLl7T1RPfkuwdqHCmaoiB1yB2aa2hxXeHeHal05IHjJTcSf+lVVqPT1gUpzDa+NVA0sAPvuWrrimupY5+5JUIV4O2IFT3fPyPghYD2b9j56rlCOAw/+wCdqOOV6d9aIXtGOi8k38ywSx5ZOq4PGUzBr4uYXZGnmDJ8MCEgGW6BtBrzrq3+0ei03QpzjcXSatxp7fgRYt3TaMJPUV1V3wfC32jhmxqKVjdzYpsO1cbMooDu98r9bvHZ0pgn/7c6U3dchEP/ua/YvyMRNgFWvefiPiZJzw88kIxmDP58B7Iz/cQTHQ92H69/aYaqjTz3SypFy736ttlWThgFOm7hzAOhKLudoQleWvdMpvw\u003d\u003d");
        request.setUuid("b80c1f46c3893a47");

        Observable<retrofit2.Response<ResponseBody>> listRxResData = demoPostApi.getListRxResData(request);
        listRxResData.compose(new StringTransformer<>())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "post doRxResReq2 completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "post doRxResReq2 throwable");
                    }

                    @Override
                    public void onNext(String result) {
                        try {
                            String code = String.valueOf(result);
                            Log.d(TAG, "post doRxResReq2 code = " + code);

//                                String decrypt = AESUtils.decryptFormTr(AESUtils.AESKey, responseBody.string());
//                                Log.d(TAG, "post doRxResReq body = " + decrypt);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onStart() {
                        Log.d(TAG, "post doRxResReq2 onStart");
                        super.onStart();
                    }
                });
        return ret;
    }

    /**
     * 封装后的方法  TODO 不完善
     *
     * @param api
     * @param <T>
     * @return
     */
    public static <T> T getApi(Class<T> api) {
        Retrofit instance = RetrofitUtils.getInstance();
        return instance.create(api);
    }

    /**
     * 封装后的方法  TODO 不完善
     *
     * @param listRxResData Observable对象
     * @param subscriber    Subscriber对象
     */
    public static void doRequest(Observable<retrofit2.Response<ResponseBody>> listRxResData,
                                 Subscriber<String> subscriber) {
        listRxResData.compose(new StringTransformer<>()).subscribe(subscriber);
    }

    public static void sendRequest() {

        DemoRequest request = new DemoRequest();
        request.setData("7yBzesTb9fuAesM2f9bG1uqR8MNxwFGjDEmb1PfohpnKloFvK3LoNC7JIAvA0ba9Htc6ZbyHTXebsqNgNz9/C+oYX2aaUrjpBr7E7nvgi4lwehN8lBpR5ySoXj1dPD+sqAXncwyQVLgumXPPZRlOoYGWE0ktEO3a+BH4ZF0iUKVhS1xEG+nFGxfTjvj2lUL+i8HWKblb+3L18NUUNaSItUjTveyppsTjfbwLcCMz156cRxLnASdey3N8N+eY7dHBb1HXddNjMwv+q7j5hMopDX/mJbUxSSetLqmX/Rp0SPZQIDhOY1HmbEGi45ZxeenYpajywLlWRYZuIunVUtT+H8Vk0DqGHLLmvZQMH1t+Nyo5TsZbFN0iIhDMupLkSpWeY1WIQIFttTufw2dMR+63CtaYrloSyyDiGRTf8Q/swxjO/RgAyvZQYi0+0MV6mR0DR26cMQ0thjvVU7OiQfdY+a6v3SvOuzfBAUo8k8oZCI4RC8LM2w/tWI22ljEjS6oJ64vmh4lVXEhmhg/CV1XMqEyGz/tcdqRwv37taiMBTPVTwkfmTy9pIUIde98TDhT+o5skIbg0jCok3H62u3cGg+J3TlPzff6JZ40OKA5OjWKHMTgoW2N+8/xXPo2iifvSPAhzhJYPh9kYi/FsKbE9ovNSl/Z4TRHzhs8sfW6TSjrCu2Cmrdc/yLs1wPiQ1AbdjnJcICkLq7Pth87wWByRp/pKRx9mUnbe17GuSfeMKxXgTG59fFIj4XHc5NQ04M0Cf5gWY5P8R6DQ9F8DlDwXubPRsb3/qsgHH9wQ8iGbcHHv3Xht9UNNSBFpgwFml7+zKDsh1+UkCtAyHhf46DXBMninNRuIYwFv/p5eG4/3yyNHN9Ov1kLl7T1RPfkuwdqHCmaoiB1yB2aa2hxXeHeHal05IHjJTcSf+lVVqPT1gUpzDa+NVA0sAPvuWrrimupY5+5JUIV4O2IFT3fPyPghYD2b9j56rlCOAw/+wCdqOOV6d9aIXtGOi8k38ywSx5ZOq4PGUzBr4uYXZGnmDJ8MCEgGW6BtBrzrq3+0ei03QpzjcXSatxp7fgRYt3TaMJPUV1V3wfC32jhmxqKVjdzYpsO1cbMooDu98r9bvHZ0pgn/7c6U3dchEP/ua/YvyMRNgFWvefiPiZJzw88kIxmDP58B7Iz/cQTHQ92H69/aYaqjTz3SypFy736ttlWThgFOm7hzAOhKLudoQleWvdMpvw\u003d\u003d");
        request.setUuid("b80c1f46c3893a47");

        DemoPostApi api = getApi(DemoPostApi.class);
        Observable<retrofit2.Response<ResponseBody>> listRxResData = api.getListRxResData(request);
        doRequest(listRxResData, new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "post sendRequest-optimize completed");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "post sendRequest-optimize throwable");
            }

            @Override
            public void onNext(String result) {
                try {
                    String code = String.valueOf(result);
                    Log.d(TAG, "post sendRequest-optimize code = " + code);

//                                String decrypt = AESUtils.decryptFormTr(AESUtils.AESKey, responseBody.string());
//                                Log.d(TAG, "post doRxResReq body = " + decrypt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStart() {
                Log.d(TAG, "post sendRequest-optimize onStart");
                super.onStart();
            }
        });
    }
}
