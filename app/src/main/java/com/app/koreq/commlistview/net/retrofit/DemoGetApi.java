package com.app.koreq.commlistview.net.retrofit;

import com.app.koreq.commlistview.net.bean.DemoBean;

import okhttp3.ResponseBody;
import retrofit2_source.Call;
import retrofit2_source.Response;
import retrofit2_source.http.GET;
import retrofit2_source.http.Path;
import retrofit2_source.http.Query;
import rx.Observable;

/**
 * project : CommListView
 * author : YanBin on 3/31/17
 * version : v3.0
 * description : retrofit demo api
 */
public interface DemoGetApi {
    //    api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%87%91%E5%88%9A%E7%8B%BC&bk_length=600
    @GET("api/{urlDir}/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%87%91%E5%88%9A%E7%8B%BC")
    Call<DemoBean> getBaikeData(@Path("urlDir") String urlDir, @Query("bk_length") String bkLength);

    //rxjava
    @GET("api/{urlDir}/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%87%91%E5%88%9A%E7%8B%BC")
    Observable<Response<DemoBean>> getRxBaikeData(@Path("urlDir") String urlDir, @Query("bk_length") String bkLength);

    @GET("api/{urlDir}/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%87%91%E5%88%9A%E7%8B%BC")
    Observable<DemoBean> getRxBaikeData2(@Path("urlDir") String urlDir, @Query("bk_length") String bkLength);

    @GET("api/{urlDir}/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%87%91%E5%88%9A%E7%8B%BC")
    Observable<ResponseBody> getRxBaikeJsonData(@Path("urlDir") String urlDir, @Query("bk_length") String bkLength);
}
