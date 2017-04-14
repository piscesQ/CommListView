package com.app.koreq.commlistview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.app.koreq.commlistview.R;
import com.app.koreq.commlistview.activity.CommListActivity;
import com.app.koreq.commlistview.activity.widget.PairScrollAct;

/**
 * project : CommListView
 * author : YanBin on 3/19/17
 * version : v1.0
 * description : 入口
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView() {
        Button btnCommList = (Button) findViewById(R.id.btn_comm_list);
        Button btnHttpTest = (Button) findViewById(R.id.btn_http_test);
        Button btnPairTest = (Button) findViewById(R.id.btn_pairview_test);

        btnCommList.setOnClickListener(this);
        btnHttpTest.setOnClickListener(this);
        btnPairTest.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_comm_list:    //统一列表
                startOtherActivity(CommListActivity.class);
                break;
            case R.id.btn_http_test:    //网络请求
                startOtherActivity(HttpTestAct.class);
                break;
            case R.id.btn_pairview_test:    //PairView请求
                PairScrollAct.launchAct(this);
                break;
        }
    }

    private void startOtherActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    // fix bug_01
    // fix bug_02 other
}
