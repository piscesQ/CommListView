package com.app.koreq.commlistview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.koreq.commlistview.R;
import com.app.koreq.commlistview.net.bean.DemoBean;
import com.app.koreq.commlistview.net.bean.DemoListBean;
import com.app.koreq.commlistview.net.bean.TreeResult;
import com.app.koreq.commlistview.net.okhttp.OkHttpDemoUtils;
import com.app.koreq.commlistview.net.retrofit.RetrofitDemoUtils;
import com.app.koreq.commlistview.utils.AESUtils;
import com.app.koreq.commlistview.utils.GsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.lang.ref.SoftReference;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * project : CommListView
 * author : YanBin on 3/27/17
 * version : v3.0
 * description : 网络请求demo
 */
public class HttpTestAct extends AppCompatActivity implements View.OnClickListener {

    public final static String TAG = HttpTestAct.class.getSimpleName();
    private TextView mTvShowData;   //show Response data

    public UIHandler mUIHandler;
    public static final int HANDLER_WHAT = 100;
    private Callback mOkCallback;

    public static class UIHandler extends Handler {
        private SoftReference<Activity> mReference;

        public UIHandler(Activity activity) {
            mReference = new SoftReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Object obj = msg.obj;
            String showData = "";
            if (obj instanceof String)
                showData = (String) obj;
            if (mReference.get() instanceof HttpTestAct)
                ((HttpTestAct) mReference.get()).updateUI(showData);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_test);

        initView();
        initData();
    }

    private void initView() {
        Button btnOkGetReq = (Button) findViewById(R.id.http_ok_get_request);
        Button btnOkPostReq = (Button) findViewById(R.id.http_ok_post_request);
        Button btnRetrofitGetReq = (Button) findViewById(R.id.http_retrofit_get_request);
        Button btnRetrofitPostReq = (Button) findViewById(R.id.http_retrofit_post_request);
        mTvShowData = (TextView) findViewById(R.id.http_show_data);

        btnOkGetReq.setOnClickListener(this);
        btnOkPostReq.setOnClickListener(this);
        btnRetrofitGetReq.setOnClickListener(this);
        btnRetrofitPostReq.setOnClickListener(this);
    }

    private void initData() {
        mUIHandler = new UIHandler(this);

        // 非UI线程
        mOkCallback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "call = " + call.toString());
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseString = response.body().string();
                Log.d(TAG, "response body string = " + responseString);
                Log.d(TAG, "call isCanceled = " + call.isCanceled());
                Log.d(TAG, "response = " + response.toString());

                // 非UI线程
                Message message = mUIHandler.obtainMessage(HANDLER_WHAT);
                message.obj = responseString;
                mUIHandler.sendMessage(message);
            }
        };
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.http_ok_get_request:
                sendOkGetRequest();
                break;
            case R.id.http_ok_post_request:
                sendOkPostRequest();
                break;
            case R.id.http_retrofit_get_request:
                sendRetrofitGetRequest();
                break;
            case R.id.http_retrofit_post_request:
//                sendRetrofitPostRequest();
                sendRetrofitPostJsonRequest();
                break;
        }
    }

    private void sendOkGetRequest() {
        //OkHttpUtils.doGetRequest("http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%87%91%E5%88%9A%E7%8B%BC&bk_length=600");
        OkHttpDemoUtils.doAsyncGetRequest("http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%87%91%E5%88%9A%E7%8B%BC&bk_length=600"
                , mOkCallback);

    }

    private void sendOkPostRequest() {
        OkHttpDemoUtils.doAsyncPostReq("http://114.55.100.214:7004/public/bizmsg/list",
                "{\"data\":\"u1lYTwp8RrDxYKKLNkRhHuJgf7kUaKye3d4h7Q+GHL9HodfM8rSgcZkAF9Uz9XqyBphkhGVMRUZqD1GDkIZTokMFSTi5wJ7qpbSaIQ29QOSkUZC41s3C5AC6KJRMBTP3gAIg2dKgm0wr+WEfXcyx7HP2A1cwBFvtRUBaBBaQzecv1mK4qNtXJdgQ3zbknlJ7RAcX/+nQ3QCl2M+/xfIaMsoJkkDK9O5ybQxyCmVZUuzMbD7a3+gb5GTYZD9+SipKTdjtzFZnvO7K9oMOVft7OHdOeWs5lirydP1Apqz4LzgQZS71c4V9HqlIax9WDZp2DiFS/UI0GWl2r2JDCHY1oR4D4ZCPyF39Q4k0iH2K21JPxyEjDRNFsqZ7mJt4bpCIBzegtTH47fheUBkgRfXIouOlQqHW9Plw0vJG+huKNnmr0Va6/AsP2msk0beU74/xCZDq74/z3jV06gw4PddEfoCIQWrd53kC/LJppzNUDzw\\u003d\",\"uuid\":\"fc6d7dfbc8d9549a\"}",
                mOkCallback);

    }

    private void sendRetrofitGetRequest() {
        RetrofitDemoUtils.doGetRequest(new retrofit2.Callback<DemoBean>() {
            @Override
            public void onResponse(retrofit2.Call<DemoBean> call, retrofit2.Response<DemoBean> response) {
                DemoBean demoBean = response.body();
                Log.d(TAG, "response = " + demoBean.toString());
                //在UI线程中
                mTvShowData.setText(demoBean.toString());
            }

            @Override
            public void onFailure(retrofit2.Call<DemoBean> call, Throwable t) {
                Log.d(TAG, "call isCanceled = " + call.isCanceled());
                Log.d(TAG, "response = " + t.toString());
            }
        });
    }

    private void sendRetrofitPostRequest() {
        RetrofitDemoUtils.doPostRequest(new retrofit2.Callback<DemoListBean>() {
            @Override
            public void onResponse(retrofit2.Call<DemoListBean> call, retrofit2.Response<DemoListBean> response) {
                DemoListBean demoBean = response.body();
                Log.d(TAG, "response = " + demoBean.toString());
                //在UI线程中
                mTvShowData.setText(demoBean.toString());
            }

            @Override
            public void onFailure(retrofit2.Call<DemoListBean> call, Throwable t) {
                Log.d(TAG, "call isCanceled = " + call.isCanceled());
                Log.d(TAG, "response = " + t.toString());
            }
        });
    }

    // 发送retrofit请求，并获得返回的json
    private void sendRetrofitPostJsonRequest() {
        RetrofitDemoUtils.doPostJsonRequest(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                ResponseBody responseBody = response.body();
                String string = null;
                try {
                    string = responseBody.string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (string != null) {
                    Log.d(TAG, "response = " + string);
                    String decrypt = "";
                    try {
//                        string = string.replaceAll("\\n", "");
                        decrypt = AESUtils.decryptFromTr(AESUtils.AESKey, string);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    JsonParser parser = new JsonParser();
                    JsonElement parse = parser.parse(decrypt);
                    TreeResult demoResult = GsonUtils.getGson().fromJson(parse, TreeResult.class);  //正常
                    //在UI线程中
                    mTvShowData.setText(
                            "getTotal_number = " + demoResult.getTotal_number() + ", \n" +
                                    "getTotal_used_time   = " + demoResult.getTotal_used_time() + ", \n" +
                                    "getIsCache   = " + demoResult.getIsCache());
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "call isCanceled = " + call.isCanceled());
                Log.d(TAG, "response = " + t.toString());
            }
        });
    }

    public void updateUI(String showData) {
        mTvShowData.setText(showData);
    }
}
