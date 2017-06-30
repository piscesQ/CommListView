package com.app.koreq.commlistview.activity.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.koreq.commlistview.R;
import com.app.koreq.commlib.widget.PayPwdEditText;

/**
 * project : CommListView
 * author : YanBin on 6/2/17
 * version : v4.0
 * description : 放支付宝 - 密码输入框
 */
public class PsdInputActivity extends AppCompatActivity {

    private PayPwdEditText mPwdInput;
    private PayPwdEditText mPwdInput2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psd_input);

        initView();
    }

    private void initView(){
        mPwdInput = (PayPwdEditText)findViewById(R.id.et_psd_input);
        mPwdInput2 = (PayPwdEditText)findViewById(R.id.et_psd_input_2);

        mPwdInput.setShowNum(true);
        mPwdInput2.setShowNum(true);
    }

    public static void launchAct(Context context){
        Intent intent = new Intent(context, PsdInputActivity.class);
        context.startActivity(intent);
    }
}
