package com.app.koreq.commlistview.activity.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.koreq.commlib.utils.CustomDownTimer;
import com.app.koreq.commlistview.R;
import com.app.koreq.commwidgetlib.BasePopupWindow;
import com.app.koreq.commwidgetlib.ToastManager;
import com.app.koreq.commwidgetlib.dialog.OneBtnCallback;
import com.app.koreq.commwidgetlib.dialog.OneBtnDialog;
import com.app.koreq.commwidgetlib.dialog.TwoBtnCallback;
import com.app.koreq.commwidgetlib.dialog.TwoBtnDialog;

/**
 * project : CommListView
 * author : YanBin on 6/2/17
 * version : v4.0
 * description : PopWindow 、吐司、倒计时
 */
public class PopWinActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnTimerDown;
    private Button mBtnDialogOne;
    private Button mBtnDialogTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_win);

        initView();
        initData();
    }

    private void initView() {
        Button btnBasePop = (Button) findViewById(R.id.pop_win_base);
        mBtnTimerDown = (Button) findViewById(R.id.btn_timer_down);
        mBtnDialogOne = (Button) findViewById(R.id.btn_dialog_one);
        mBtnDialogTwo = (Button) findViewById(R.id.btn_dialog_two);

        btnBasePop.setOnClickListener(this);
        mBtnTimerDown.setOnClickListener(this);
        mBtnDialogOne.setOnClickListener(this);
        mBtnDialogTwo.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.pop_win_base:
                initBasePop();
                break;
            case R.id.pop_btn:      //popWin内部按钮
                ToastManager.showShortMessage(this, "Pop Button clicked");
                break;
            case R.id.btn_timer_down:
                CustomDownTimer downTimer = new CustomDownTimer(60 * 1000, 1000, mBtnTimerDown);
                downTimer.setResource(getResources().getColor(R.color.yellow),
                        getResources().getColor(R.color.white),
                        "倒计时开始");
                downTimer.start();
                break;
            case R.id.btn_dialog_one:   //dialog - 单按钮
                initOneBtnDialog();
                break;
            case R.id.btn_dialog_two:   //dialog - 双按钮
                initTwoBtnDialog();
                break;
        }
    }

    private void initBasePop() {
        View popView = View.inflate(this, R.layout.pop_base, null);
        popView.findViewById(R.id.pop_btn).setOnClickListener(this);
        BasePopupWindow payWindow = new BasePopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        payWindow.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
    }

    public static void launchAct(Context context) {
        Intent intent = new Intent(context, PopWinActivity.class);
        context.startActivity(intent);
    }

    public void initOneBtnDialog() {
        OneBtnDialog oneBtnDialog = OneBtnDialog.newOneBtnDialog("标题 - kore", "正文 - kore", "确定 - kore", new OneBtnCallback() {
            @Override
            public void onClickBtn() {
                ToastManager.showShortMessage(PopWinActivity.this, "clicked  ok - kore");
            }
        });
        oneBtnDialog.show(getSupportFragmentManager(), "one_btn_dialog");
    }

    public void initTwoBtnDialog() {
        TwoBtnDialog twoBtnDialog = TwoBtnDialog.newTwoBtnDialog("标题2 - kore", "正文2 - kore", "确定2 - kore", "取消2 - Kore", new TwoBtnCallback() {
            @Override
            public void onClickOk() {
                ToastManager.showShortMessage(PopWinActivity.this, "clicked  ok2 - kore");
            }

            @Override
            public void onClickCancel() {
                ToastManager.showShortMessage(PopWinActivity.this, "clicked  cancel2 - kore");
            }
        });
        twoBtnDialog.show(getSupportFragmentManager(), "two_btn_dialog");
    }
}
