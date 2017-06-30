package com.app.koreq.commlistview.net.retrofit;

import com.app.koreq.commlistview.net.bean.DemoListBean;
import com.app.koreq.commlistview.net.bean.DemoRequest;

import okhttp3.ResponseBody;
import retrofit2_source.Call;
import retrofit2_source.Response;
import retrofit2_source.http.Body;
import retrofit2_source.http.POST;
import rx.Observable;

/**
 * project : CommListView
 * author : YanBin on 3/31/17
 * version : v3.0
 * description : retrofit demo api
 */
public interface DemoPostApi {
    //post 请求   接口和参数   接口 ：https://pro.zhihuishu.bbtree.com/service/v2/statuses/grouptimeline
    //{"andid":"b80c1f46c3893a47","banner_ratio_type":"1440x518","brand":"google","class_id":202449672,"connt":"WIFI","count":20,"density":"3.5","device":"Nexus 6P","hwd":"google/angler/angler:7.0/NBD91K/3318877:user/release-keys","imei":"86798102177694","ip":"10.0.9.157","is_public":0,"is_show":1,"mac":"02:00:00:00:00:00","make":"Huawei","myuser_id":0,"native_ratio_type":"1118x402","os":"Android","page":1,"school_id":202032240,"screenSize":"1440x2392","type":2,"ua":"Mozilla/5.0 (Linux; Android 7.0; Nexus 6P Build/NBD91K; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/51.0.2704.90 Mobile Safari/537.36","uid":"b80c1f46c3893a47","user_id":212616083,"child_id":210565601,"curr":{"child_id":210565601,"class_id":202449672,"school_id":202032240,"user_id":212616083},"data_ver":35,"device_no":"Nexus 6P","mobile_system":"7.0","platform":2,"school_app_type":0,"version_code":120,"version_no":"P_PRE_6.1.0"}
    //{"data":"7yBzesTb9fuAesM2f9bG1uqR8MNxwFGjDEmb1PfohpnKloFvK3LoNC7JIAvA0ba9Htc6ZbyHTXebsqNgNz9/C+oYX2aaUrjpBr7E7nvgi4lwehN8lBpR5ySoXj1dPD+sqAXncwyQVLgumXPPZRlOoYGWE0ktEO3a+BH4ZF0iUKVhS1xEG+nFGxfTjvj2lUL+i8HWKblb+3L18NUUNaSItUjTveyppsTjfbwLcCMz156cRxLnASdey3N8N+eY7dHBb1HXddNjMwv+q7j5hMopDX/mJbUxSSetLqmX/Rp0SPZQIDhOY1HmbEGi45ZxeenYpajywLlWRYZuIunVUtT+H8Vk0DqGHLLmvZQMH1t+Nyo5TsZbFN0iIhDMupLkSpWeY1WIQIFttTufw2dMR+63CtaYrloSyyDiGRTf8Q/swxjO/RgAyvZQYi0+0MV6mR0DR26cMQ0thjvVU7OiQfdY+a6v3SvOuzfBAUo8k8oZCI4RC8LM2w/tWI22ljEjS6oJ64vmh4lVXEhmhg/CV1XMqEyGz/tcdqRwv37taiMBTPVTwkfmTy9pIUIde98TDhT+o5skIbg0jCok3H62u3cGg+J3TlPzff6JZ40OKA5OjWKHMTgoW2N+8/xXPo2iifvSPAhzhJYPh9kYi/FsKbE9ovNSl/Z4TRHzhs8sfW6TSjrCu2Cmrdc/yLs1wPiQ1AbdjnJcICkLq7Pth87wWByRp/pKRx9mUnbe17GuSfeMKxXgTG59fFIj4XHc5NQ04M0Cf5gWY5P8R6DQ9F8DlDwXubPRsb3/qsgHH9wQ8iGbcHHv3Xht9UNNSBFpgwFml7+zKDsh1+UkCtAyHhf46DXBMninNRuIYwFv/p5eG4/3yyNHN9Ov1kLl7T1RPfkuwdqHCmaoiB1yB2aa2hxXeHeHal05IHjJTcSf+lVVqPT1gUpzDa+NVA0sAPvuWrrimupY5+5JUIV4O2IFT3fPyPghYD2b9j56rlCOAw/+wCdqOOV6d9aIXtGOi8k38ywSx5ZOq4PGUzBr4uYXZGnmDJ8MCEgGW6BtBrzrq3+0ei03QpzjcXSatxp7fgRYt3TaMJPUV1V3wfC32jhmxqKVjdzYpsO1cbMooDu98r9bvHZ0pgn/7c6U3dchEP/ua/YvyMRNgFWvefiPiZJzw88kIxmDP58B7Iz/cQTHQ92H69/aYaqjTz3SypFy736ttlWThgFOm7hzAOhKLudoQleWvdMpvw\u003d\u003d","uuid":"b80c1f46c3893a47"}
    // AES key : dfdf390a074130d157a2305fd2f7d1dc
    @POST("statuses/grouptimeline")
    Call<DemoListBean> getListData(@Body String params);

//    @FormUrlEncoded
    @POST("statuses/grouptimeline")
    Call<ResponseBody> getListJsonData(@Body DemoRequest request);    //Call<ResponseBody> 会返回response的JSON，可以自行处理

    @POST("statuses/grouptimeline")
    Observable<ResponseBody> getListRxJsonData(@Body DemoRequest request);

    @POST("statuses/grouptimeline")
    Observable<Response<ResponseBody>> getListRxResData(@Body DemoRequest request);
}
