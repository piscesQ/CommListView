package com.app.koreq.commlistview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.app.koreq.aop.AopConst;
import com.app.koreq.aop.aspectj.configdemo.DebugTrace;
import com.app.koreq.commlistview.R;
import com.app.koreq.commlistview.bean.AopTestBean;
import com.app.koreq.commwidgetlib.ToastManager;
import com.app.koreq.commwidgetlib.utils.DebugLog;

/**
 * project : CommListView
 * author : YanBin on 5/17/17
 * version : v4.0
 * description : Aop Demo
 */
public class AopActivity extends AppCompatActivity implements View.OnClickListener {

    private AopTestBean mBean;

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
        Button btn5 = (Button) findViewById(R.id.aop_btn_5);
        Button btn6 = (Button) findViewById(R.id.aop_btn_6);
        Button btn7 = (Button) findViewById(R.id.aop_btn_7);
        Button btn8 = (Button) findViewById(R.id.aop_btn_8);
        Button btn9 = (Button) findViewById(R.id.aop_btn_9);
        Button btn10 = (Button) findViewById(R.id.aop_btn_10);
        Button btn11 = (Button) findViewById(R.id.aop_btn_11);

        LinearLayout llBlue = (LinearLayout) findViewById(R.id.aop_ll_blue);
        llBlue.invalidate();

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
    }

    private void initData() {
        mBean = new AopTestBean();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.aop_btn_1:
                testAnnotatedMethod();
                break;
            case R.id.aop_btn_2:
                apiWithincode1();
                break;
            case R.id.aop_btn_3:
                constructorTest();
                break;
            case R.id.aop_btn_4:
                getTest();
                break;
            case R.id.aop_btn_5:
                setTest();
                break;
            case R.id.aop_btn_6:
                ToastManager.showShortMessage(this, "静态代码块日志在页面打开时已经打印！！！");
                break;
            case R.id.aop_btn_7:
                afterThrowingTest();
                break;
            case R.id.aop_btn_8:
                afterReturningTest();
                break;
            case R.id.aop_btn_9:
                exceptionTest();
                break;
            case R.id.aop_btn_10:
                joinPointMethod();
                joinPointMethod("Kore", 999, 666f);
                break;
            case R.id.aop_btn_11:
                aroundTest();
                aroundTest("KoreAround", 888, 233f);
                break;
        }
    }

    @DebugTrace
    private void testAnnotatedMethod() {
        Log.d(AopConst.LOG_TAG, "Koreyoshi - testAnnotatedMethod");
    }

    private void apiWithincode1() {
        DebugLog.log(AopConst.LOG_TAG, "apiWithincode1");
    }

    private void constructorTest() {
        AopTestBean bean = new AopTestBean();
    }

    private void getTest() {
        mBean.getName();
    }

    private void setTest() {
        mBean.setName("Kore");
    }

    private void afterThrowingTest() {
        try {
            String str = null;
            str.trim();
        } catch (Exception e) {
            Log.d(AopConst.LOG_TAG, "Koreyoshi - exceptionTest - " + e.getClass());
        }
    }

    private int afterReturningTest() {
        return 20000;
    }

    private void exceptionTest() {
        try {
            int a = 4 / 0;
        } catch (ArithmeticException e) {
            Log.d(AopConst.LOG_TAG, "Koreyoshi - exceptionTest - " + e.getClass());
        }
    }

    private void joinPointMethod() {
        DebugLog.log(AopConst.LOG_TAG, "== joinPointMethod() ==");
    }

    private void joinPointMethod(String str, int number, float money) {
        DebugLog.log(AopConst.LOG_TAG, "== joinPointMethod(String, int, float) ==");
    }

    private void aroundTest() {
        DebugLog.log(AopConst.LOG_TAG, "== aroundTest() ==");
    }

    private void aroundTest(String str, int number, float money) {
        DebugLog.log(AopConst.LOG_TAG, "== aroundTest(String, int, float) ==" + str + "、" + number + "、" + money);
    }
}
