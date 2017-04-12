package com.app.koreq.commlistview.net.okhttp;


import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;

/**
 * project : CommListView
 * author : YanBin on 3/22/17
 * version : v3.0
 * description : okhttp Utils
 */
public class OkHttpDemoUtils {
    public final static String TAG = OkHttpDemoUtils.class.getSimpleName();
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");


//    test url : http://api2.souyue.mobi/d3api2/community/community.news.list.groovy
//    http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%87%91%E5%88%9A%E7%8B%BC&bk_length=600

    /**
     * 同步请求
     *
     * @param url 请求链接
     * @return 返回响应码
     * @throws IOException
     */
    public static int doGetRequest(String url) {
        final int[] ret = {0};
        final OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(url).build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (response != null) {
                    ret[0] = response.code();
                    if (response.isSuccessful()) {
                        Log.d(TAG, "success : " + response.toString());
                        ResponseBody body = response.body();
                        try {
                            String string = body.string();  //获取字符串
                            Log.d(TAG, "success string : " + string);
                            InputStream inputStream = body.byteStream();    //输入流
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Log.d(TAG, "error : " + response.toString());
                    }
                }
            }
        }).start();

        return ret[0];
    }

    /**
     * 异步请求
     *
     * @param url 请求链接
     * @return 响应码
     * @throws IOException
     */
    public static int doAsyncGetRequest(String url, Callback callback) {
        final int[] ret = {0};
        Request request = new Request.Builder().url(url).build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(callback);
        return ret[0];
    }

    //post 请求   接口和参数   接口 ： http://114.55.100.214:7004/public/bizmsg/list
    //{"bizType":1,"order":"{\"createTime\":-1}","pageNo":1,"pageSize":20,"toUserId":104657899,"type":1,"child_id":102938777,"curr":{"child_id":102938777,"class_id":100142264,"school_id":100026655,"user_id":205207714},"data_ver":34,"device_no":"SM-G9350","mobile_system":"6.0.1","platform":2,"school_app_type":0,"version_code":119,"version_no":"P_Debug_6.0.0"}
    //{"data":"u1lYTwp8RrDxYKKLNkRhHuJgf7kUaKye3d4h7Q+GHL9HodfM8rSgcZkAF9Uz9XqyBphkhGVMRUZqD1GDkIZTokMFSTi5wJ7qpbSaIQ29QOSkUZC41s3C5AC6KJRMBTP3gAIg2dKgm0wr+WEfXcyx7HP2A1cwBFvtRUBaBBaQzecv1mK4qNtXJdgQ3zbknlJ7RAcX/+nQ3QCl2M+/xfIaMsoJkkDK9O5ybQxyCmVZUuzMbD7a3+gb5GTYZD9+SipKTdjtzFZnvO7K9oMOVft7OHdOeWs5lirydP1Apqz4LzgQZS71c4V9HqlIax9WDZp2DiFS/UI0GWl2r2JDCHY1oR4D4ZCPyF39Q4k0iH2K21JPxyEjDRNFsqZ7mJt4bpCIBzegtTH47fheUBkgRfXIouOlQqHW9Plw0vJG+huKNnmr0Va6/AsP2msk0beU74/xCZDq74/z3jV06gw4PddEfoCIQWrd53kC/LJppzNUDzw\u003d","uuid":"fc6d7dfbc8d9549a"}
    public static int doAsyncPostReq(String url, final String strParams, Callback callback) {

        final int[] ret = {0};

        RequestBody requestBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MEDIA_TYPE_JSON;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                sink.writeUtf8(strParams);
            }
        };

        //键值对
//        RequestBody formBody = new FormBody.Builder()
//                .add("platform", "android")
//                .add("name", "bug")
//                .add("subject", "XXXXXXXXXXXXXXX")
//                .build();

//        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_JSON,strParams);


        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).tag(url).post(requestBody).build();
        client.newCall(request).enqueue(callback);
        return ret[0];
    }

    private void testAPI() {
        Request request = new Request.Builder().build();
    }
}
