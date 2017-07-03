package com.app.koreq.commlistview.activity;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.app.koreq.commlib.widget.ToastManager;
import com.app.koreq.commlistview.R;
import com.app.koreq.commlistview.activity.widget.PopWinActivity;

/**
 * project : CommListView
 * author : YanBin on 5/17/17
 * version : v5.0
 * description : 嵌套Activity
 */
public class EmbedActivity extends AppCompatActivity implements View.OnClickListener {
    protected LocalActivityManager mLocalActivityManager;
    private FrameLayout mContainer;
    private PopWinActivity mInnerAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embed);

        initView();

        mLocalActivityManager = new LocalActivityManager(this, true);
        Bundle states = savedInstanceState != null ? savedInstanceState : null;
        mLocalActivityManager.dispatchCreate(states);

        Intent intent = new Intent(this, PopWinActivity.class);
        intent.putExtra(PopWinActivity.KEY_NAME, this.getClass().getSimpleName());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        View decorView = mLocalActivityManager.startActivity("popWin", intent).getDecorView();
        mContainer.removeAllViews();
        mContainer.addView(decorView);

        initData();
    }

    private void initView() {
        mContainer = (FrameLayout) findViewById(R.id.embed_container);
        Button btnTest = (Button) findViewById(R.id.embed_btn);

        btnTest.setOnClickListener(this);
    }

    private void initData() {
        Activity popWinAct = mLocalActivityManager.getActivity("popWin");
        if (popWinAct instanceof PopWinActivity) {
            mInnerAct = ((PopWinActivity) popWinAct);
        }

        mInnerAct.setCallback(new PopWinActivity.OuterCallback() {
            @Override
            public void outerCallback() {
                ToastManager.showShortMessage(EmbedActivity.this, "Toast From EmbedActivity");
            }
        });
    }

    public static void launchAct(Context context) {
        Intent intent = new Intent(context, EmbedActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.embed_btn:
                invokeInnerAct();
                break;
        }
    }

    private void invokeInnerAct() {
        ToastManager.showShortMessage(this, "测试");
        if (mInnerAct != null) {
            mInnerAct.initOneBtnDialog("-Embed");
        }
    }
}
