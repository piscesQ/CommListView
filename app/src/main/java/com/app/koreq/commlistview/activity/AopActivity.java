package com.app.koreq.commlistview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.app.koreq.aop.aspectj.configdemo.DebugLog;
import com.app.koreq.aop.aspectj.configdemo.DebugTrace;
import com.app.koreq.commlistview.R;

/**
 * project : CommListView
 * author : YanBin on 5/17/17
 * version : v4.0
 * description : Aop Demo
 */
public class AopActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aop);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initView();
        initData();
    }

    public static void launchAct(Context context) {
        Intent intent = new Intent(context, AopActivity.class);
        context.startActivity(intent);
    }


    private void initView() {
        Button btn1 = (Button) findViewById(R.id.aop_btn_1);
        Button btn2 = (Button) findViewById(R.id.aop_btn_2);
        Button btn3 = (Button) findViewById(R.id.aop_btn_3);
        Button btn4 = (Button) findViewById(R.id.aop_btn_4);

        LinearLayout llBlue = (LinearLayout) findViewById(R.id.aop_ll_blue);
        llBlue.invalidate();

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    private void initData() {

    }

    @DebugTrace
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.aop_btn_1:
                testAnnotatedMethod();
                break;
            case R.id.aop_btn_2:
                break;
            case R.id.aop_btn_3:
                break;
            case R.id.aop_btn_4:
                break;
        }
    }

    @DebugTrace
    private void testAnnotatedMethod() {
        DebugLog.log("Koreyoshi", "Koreyoshi - testAnnotatedMethod");
    }
}
