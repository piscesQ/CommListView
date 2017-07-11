package com.app.koreq.commlistview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.koreq.commlistview.R;
import com.app.koreq.commlistview.activity.widget.CustomViewActivity;
import com.app.koreq.commlistview.activity.widget.LoadingActivity;
import com.app.koreq.commlistview.activity.widget.PairScrollAct;
import com.app.koreq.commlistview.activity.widget.PopWinActivity;
import com.app.koreq.commlistview.activity.widget.PsdInputActivity;
import com.google.zxing.qrcode.encoder.QRCode;

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
        Button btnRxjavaTest = (Button) findViewById(R.id.btn_rxjava_test);
        Button btnGradleStr = (Button) findViewById(R.id.btn_gradle_str_test);
        Button btnNetFrame = (Button) findViewById(R.id.btn_net_frame);
        Button btnTreeDecrypt = (Button) findViewById(R.id.btn_tree_decrypt);
        Button btnAop = (Button) findViewById(R.id.btn_aop);
        Button btnPsd = (Button) findViewById(R.id.btn_psd);
        Button btnPopWin = (Button) findViewById(R.id.btn_pop_window);

        Button btnLoading = (Button) findViewById(R.id.btn_loading);
        Button btnCustomView = (Button) findViewById(R.id.btn_custom_view);
        Button btnEmbedAct = (Button) findViewById(R.id.btn_embed_act);
        Button btnQRCode = (Button) findViewById(R.id.btn_qrcode);
        Button btnSoftInputMode = (Button) findViewById(R.id.btn_soft_input_mode);


        btnCommList.setOnClickListener(this);
        btnHttpTest.setOnClickListener(this);
        btnPairTest.setOnClickListener(this);
        btnRxjavaTest.setOnClickListener(this);
        btnGradleStr.setOnClickListener(this);
        btnNetFrame.setOnClickListener(this);
        btnTreeDecrypt.setOnClickListener(this);
        btnAop.setOnClickListener(this);
        btnPsd.setOnClickListener(this);
        btnPopWin.setOnClickListener(this);
        btnLoading.setOnClickListener(this);
        btnCustomView.setOnClickListener(this);
        btnEmbedAct.setOnClickListener(this);
        btnQRCode.setOnClickListener(this);
        btnSoftInputMode.setOnClickListener(this);
    }

    private void initData() {
        AopActivity aopActivity = new AopActivity();
        aopActivity.apiDemo2();
        Toast.makeText(this, "已经成功调用 aopActivity.apiDemo2()", Toast.LENGTH_SHORT).show();
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
            case R.id.btn_pairview_test:    //PairView
                PairScrollAct.launchAct(this);
                break;
            case R.id.btn_rxjava_test:    //Rxjava
                RxJavaActivity.launchAct(this);
                break;
            case R.id.btn_gradle_str_test:    //Rxjava
                toastGradleRes();
                break;
            case R.id.btn_net_frame:    //net frame
                NetFrameActivity.launchAct(this);
                break;
            case R.id.btn_tree_decrypt:    //net frame
                TreeDecryptActivity.launchAct(this);
                break;
            case R.id.btn_aop:    //aop demo
                AopActivity.launchAct(this);
                break;
            case R.id.btn_psd:    //仿支付宝支付密码输入框
                PsdInputActivity.launchAct(this);
                break;
            case R.id.btn_pop_window:    //PopupWindow
                PopWinActivity.launchAct(this, "MainActivity");
                break;
            case R.id.btn_loading:    //loading、 网络状态
                LoadingActivity.launchAct(this);
                break;
            case R.id.btn_custom_view:    //自定义View
                CustomViewActivity.launchAct(this);
                break;
            case R.id.btn_embed_act:    //嵌套Act
                EmbedActivity.launchAct(this);
                break;
            case R.id.btn_qrcode:    //二维码
                QRCodeActivity.launchAct(this);
                break;
            case R.id.btn_soft_input_mode:    //windowSoftInputMode属性测试
                SoftInputModeActivity.launchAct(this);
                break;
        }
    }

    /**
     * build.gradle文件中定义的资源属性 测试方法
     */
    private void toastGradleRes() {
//        String hostEnv = getResources().getString(R.string.host_env);   //正常
//        String currentTime = getResources().getString(R.string.current_time);   //正常
//        Toast.makeText(this, "hostEnv = " + hostEnv + ", " +
//                "currentTime = " + currentTime, Toast.LENGTH_LONG).show();    //正常

//        boolean IS_DEBUG = getResources().getBoolean(R.bool.IS_DEBUG);   //正常
//        int testNum1 = getResources().getInteger(R.integer.test_num_1);   //正常
//        int testNum2 = getResources().getInteger(R.integer.test_num_2);   //正常
//        Toast.makeText(this, "IS_DEBUG = " + IS_DEBUG + ", " +
//                "testNum1 = " + testNum1 + ", testNum2 = " + testNum2, Toast.LENGTH_LONG).show();    //正常

//        String testStr = getResources().getString(R.string.test_string);   //正常
//        int testInt = getResources().getInteger(R.integer.test_int);   //正常
//        boolean testBool = getResources().getBoolean(R.bool.test_bool);   //正常
//        Toast.makeText(this, "、" + testStr + "、" + testInt + "、" + testBool, Toast.LENGTH_LONG).show();    //正常

        int hostEnv = getResources().getInteger(R.integer.host_env);
        boolean isDebug = getResources().getBoolean(R.bool.is_debug);
        Toast.makeText(this, hostEnv + "、" + isDebug, Toast.LENGTH_LONG).show();    //正常
    }

    private void startOtherActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
