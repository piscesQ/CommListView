package com.app.koreq.commlistview.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.koreq.commlistview.R;

public class BaseAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
