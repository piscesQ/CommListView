package com.app.koreq.commlistview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.koreq.commlistview.R;
import com.app.koreq.commlistview.net.bean.BaikeResult;
import com.app.koreq.commlistview.net.bean.TreeResult;
import com.app.koreq.commlistview.net.frame.Http;
import com.app.koreq.commlistview.net.frame.bean.BaikeGetRequest;
import com.app.koreq.commlistview.net.frame.bean.TreePostRequest;
import com.app.koreq.commlistview.net.retrofit.HttpConstant;
import com.app.koreq.netlib.bean.BaseRequest;
import com.app.koreq.netlib.http.HttpConstants;

import rx.Subscriber;

public class NetFrameActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = NetFrameActivity.class.getSimpleName();
    private TextView mTvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_frame);

        initView();
        initData();
    }

    public static void launchAct(Context context) {
        Intent intent = new Intent(context, NetFrameActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        Button http_get_map = (Button) findViewById(R.id.net_http_get_map);
        Button http_form_map = (Button) findViewById(R.id.net_http_form_map);
        Button http_post_map = (Button) findViewById(R.id.net_http_post_map);
        mTvShow = (TextView) findViewById(R.id.rx_text);

        http_get_map.setOnClickListener(this);
        http_form_map.setOnClickListener(this);
        http_post_map.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        BaseRequest request = null;
        switch (id) {
            case R.id.net_http_get_map:    //点击 http get map 按钮
                request = netGetDemo();
                Http.sendOriginRequest(request);
                break;
            case R.id.net_http_form_map:    //点击 http form map 按钮
                break;
            case R.id.net_http_post_map:    //点击 http map 按钮
                request = netPostDemo();
                request.setRequestType(HttpConstants.TYPE_POST);
                Http.sendTrRequest(request);
                break;
        }
    }

    /**
     * post 请求
     */
    private BaseRequest netPostDemo() {
        TreePostRequest request = new TreePostRequest();
        request.setUrl("statuses/grouptimeline");
        request.setParams("");

        Subscriber<TreeResult> subscriber = new Subscriber<TreeResult>() {
            @Override
            public void onCompleted() {
                Log.d(HttpConstant.TAG, " netPostDemo - onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.d(HttpConstant.TAG, " netPostDemo - onError");
            }

            @Override
            public void onNext(TreeResult demoResult) {
                Log.d(HttpConstant.TAG, String.valueOf(demoResult.getTotal_number()));
            }
        };

        request.setSubscriber(subscriber);

        return request;
    }

    /**
     * @return
     */
    private BaseRequest netGetDemo() {
        BaikeGetRequest request = new BaikeGetRequest();
        request.setParams();
        request.setSubscriber(new Subscriber<BaikeResult>() {
            @Override
            public void onCompleted() {
                Log.d(HttpConstant.TAG, " netGetDemo - onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.d(HttpConstant.TAG, " netGetDemo - onError");
            }

            @Override
            public void onNext(BaikeResult baikeResult) {
                Log.d(HttpConstant.TAG, baikeResult.getKey() + "_" + baikeResult.getDesc());
            }
        });

        return request;
    }
}
