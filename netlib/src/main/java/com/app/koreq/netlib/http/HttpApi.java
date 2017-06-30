package com.app.koreq.netlib.http;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2_source.Response;
import retrofit2_source.http.Body;
import retrofit2_source.http.FormUrlEncoded;
import retrofit2_source.http.GET;
import retrofit2_source.http.POST;
import retrofit2_source.http.Path;
import retrofit2_source.http.QueryMap;
import rx.Observable;

/**
 * project : CommListView
 * author : YanBin on 4/28/17
 * version : v
 * description : 请求接口，所有请求都走此处
 */
public interface HttpApi {

    @GET("{url}")
    Observable<Response<ResponseBody>> getRequest(@Path(value = "url", encoded = true) String url, @QueryMap Map<String, String> map);

    @POST("{url}")
    @FormUrlEncoded
    Observable<Response<ResponseBody>> postFormRequest(@Path(value = "url", encoded = true) String url, @Body Map<String, String> map);

    @POST("{url}")
    Observable<Response<ResponseBody>> postRequest(@Path(value = "url", encoded = true) String url, @Body Map<String, String> map);
}
