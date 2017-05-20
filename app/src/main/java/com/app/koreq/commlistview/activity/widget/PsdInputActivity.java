package com.app.koreq.commlistview.activity.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app.koreq.commlistview.R;
import com.app.koreq.commwidgetlib.PayPwdEditText;


public class PsdInputActivity extends AppCompatActivity {

    private PayPwdEditText mPwdInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psd_input);

        initView();
    }

    private void initView(){
        mPwdInput = (PayPwdEditText)findViewById(R.id.et_psd_input);
        mPwdInput.setShowNum(true);
    }

    public static void launchAct(Context context){
        Intent intent = new Intent(context, PsdInputActivity.class);
        context.startActivity(intent);
    }
}
