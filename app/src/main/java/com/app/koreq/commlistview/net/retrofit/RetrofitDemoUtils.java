package com.app.koreq.commlistview.net.retrofit;

import com.app.koreq.commlistview.net.bean.DemoBean;
import com.app.koreq.commlistview.net.bean.DemoListBean;
import com.app.koreq.commlistview.net.bean.DemoRequest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * project : CommListView
 * author : YanBin on 3/27/17
 * version : v3.0
 * description :
 */
public class RetrofitDemoUtils {

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
     * @param callback
     * @return
     */
    public static int doPostRequest(Callback<DemoListBean> callback) {
        int ret = 0;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pro.zhihuishu.bbtree.com/service/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DemoPostApi demoPostApi = retrofit.create(DemoPostApi.class);
        Call<DemoListBean> listData = demoPostApi.getListData("{\"data\":\"4XxVe0uWK4xRKHMpv6fDTwNK1ct0j66UGo/RgU8s/I1fnIJfeyuajAJc2NfqnJfrmBJI/HTxzHbZylNAxZktOqdGtvZ8AZqQrIy/YDqLI2hXA4020Umeay5dEf7xQH5BVSV1Sewp19/C01h8Ba+tihAD7ggvNBz8rxUYWp3w/heaOevT9jq6yD6nl7PERUDRjve+THc0QwplcaBYIZGZrDabDw2OPudFnyXeiG6Mb9ZcPDRcadSDtges15QyvNxEtnT/xmyCcR8OURlVqmBNIbSvauAPW4t3JaHg0iwLnaZRvyVUvA9NAG7JKLyCVbE3x2bMOLVnJU1hAwX+ehoBj9WcTGOASZZiV9TPGhVB6ougvFCmEKV3yuvUHqt5L6jl\",\"uuid\":\"fc6d7dfbc8d9549a\"}");
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
                .baseUrl("https://pro.zhihuishu.bbtree.com/service/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DemoPostApi demoPostApi = retrofit.create(DemoPostApi.class);

        DemoRequest request = new DemoRequest();
        request.setData("4XxVe0uWK4xRKHMpv6fDTwNK1ct0j66UGo/RgU8s/I1fnIJfeyuajAJc2NfqnJfrmBJI/HTxzHbZylNAxZktOqdGtvZ8AZqQrIy/YDqLI2hXA4020Umeay5dEf7xQH5BVSV1Sewp19/C01h8Ba+tihAD7ggvNBz8rxUYWp3w/heaOevT9jq6yD6nl7PERUDRjve+THc0QwplcaBYIZGZrDabDw2OPudFnyXeiG6Mb9bRAbhvIiMRcjMs9qLVseXyBq4+YvC0AwxKeCqQ/xRhUEisL3hCil9tW7ebu+AZK2u5hsUDwvfgufO1M08qZTmCvogUP16Rk4Kbc7+ovla/NFmONXUtzIzfvpNp9bzXLVy8GnaDpDoBqyDp7vhyeB4N");
        request.setUuid("fc6d7dfbc8d9549a");
        Call<ResponseBody> listData = demoPostApi.getListJsonData(request);
        listData.enqueue(callback);
        return ret;
    }
}
