package com.app.koreq.commlistview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.koreq.commlistview.R;

public class SoftInputModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_input_mode);
    }

    public static void launchAct(Context context) {
        Intent intent = new Intent(context, SoftInputModeActivity.class);
        context.startActivity(intent);
    }
}
