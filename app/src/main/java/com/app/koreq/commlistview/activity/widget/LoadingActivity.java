package com.app.koreq.commlistview.activity.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.app.koreq.commlib.utils.NetManager;
import com.app.koreq.commlib.widget.CommLoading;
import com.app.koreq.commlib.widget.ToastManager;
import com.app.koreq.commlistview.R;

/**
 * project : CommListView
 * author : YanBin on 7/2/17
 * version : v3.0
 * description : 自定义Loading、网络状态
 */
public class LoadingActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        initView();
    }

    private void initView() {
        FrameLayout container1 = (FrameLayout) findViewById(R.id.loading_container_1);
        CommLoading loading1 = new CommLoading(this);
        container1.addView(loading1);

        Button btnNetStatus = (Button) findViewById(R.id.net_status);
        btnNetStatus.setOnClickListener(this);
    }

    public static void launchAct(Context context) {
        Intent intent = new Intent(context, LoadingActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.net_status:
                showNetStatus();
                break;
        }
    }

    private void showNetStatus() {
        int status = NetManager.getCustomNetType(this);
        String showText = "<no value>";
        switch (status) {
            case 0:
                showText = "无网络连接";
                break;
            case 1:
                showText = "Wifi连接";
                break;
            case 2:
                showText = "2G连接";
                break;
            case 3:
                showText = "3G连接";
                break;
            case 4:
                showText = "4G连接";
                break;
        }
        ToastManager.showShortMessage(this, showText);
    }
}
