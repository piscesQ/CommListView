package com.app.koreq.commlistview.net.retrofit;

import com.app.koreq.commlistview.net.bean.DemoListBean;
import com.app.koreq.commlistview.net.bean.DemoRequest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * project : CommListView
 * author : YanBin on 3/31/17
 * version : v3.0
 * description : retrofit demo api
 */
public interface DemoPostApi {
    //post 请求   接口和参数   接口 ：https://pro.zhihuishu.bbtree.com/service/v2/configure/myclassinfo
    //{"user_id":212616083,"child_id":210565601,"curr":{"child_id":210565601,"class_id":202449672,"school_id":202032240,"user_id":212616083},"data_ver":34,"device_no":"SM-G9350","mobile_system":"7.0","platform":2,"school_app_type":0,"version_code":119,"version_no":"P_PRE_6.0.0"}
    //{"data":"4XxVe0uWK4xRKHMpv6fDTwNK1ct0j66UGo/RgU8s/I1fnIJfeyuajAJc2NfqnJfrmBJI/HTxzHbZylNAxZktOqdGtvZ8AZqQrIy/YDqLI2hXA4020Umeay5dEf7xQH5BVSV1Sewp19/C01h8Ba+tihAD7ggvNBz8rxUYWp3w/heaOevT9jq6yD6nl7PERUDRjve+THc0QwplcaBYIZGZrDabDw2OPudFnyXeiG6Mb9bRAbhvIiMRcjMs9qLVseXyBq4+YvC0AwxKeCqQ/xRhUEisL3hCil9tW7ebu+AZK2u5hsUDwvfgufO1M08qZTmCvogUP16Rk4Kbc7+ovla/NFmONXUtzIzfvpNp9bzXLVy8GnaDpDoBqyDp7vhyeB4N","uuid":"fc6d7dfbc8d9549a"}
    // AES key : baf2712390e5495db4f21b67275c0ea0
    @POST("configure/myclassinfo")
    Call<DemoListBean> getListData(@Body String params);

//    @FormUrlEncoded
    @POST("configure/myclassinfo")
    Call<ResponseBody> getListJsonData(@Body DemoRequest request);    //Call<ResponseBody> 会返回response的JSON，可以自行处理

}
