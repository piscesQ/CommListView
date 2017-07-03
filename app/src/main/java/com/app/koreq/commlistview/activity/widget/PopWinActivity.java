package com.app.koreq.commlistview.activity.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.koreq.commlib.utils.CustomDownTimer;
import com.app.koreq.commlib.widget.BasePopupWindow;
import com.app.koreq.commlib.widget.ToastManager;
import com.app.koreq.commlib.widget.dialog.OneBtnCallback;
import com.app.koreq.commlib.widget.dialog.OneBtnDialog;
import com.app.koreq.commlib.widget.dialog.TwoBtnCallback;
import com.app.koreq.commlib.widget.dialog.TwoBtnDialog;
import com.app.koreq.commlistview.R;

/**
 * project : CommListView
 * author : YanBin on 6/2/17
 * version : v4.0
 * description : PopWindow 、吐司、倒计时
 */
public class PopWinActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_NAME = "name";
    private Button mBtnTimerDown;
    private Button mBtnDialogOne;
    private Button mBtnDialogTwo;
    private Button mBtnOuter;
    private OuterCallback mCallback;

    public interface OuterCallback {
        void outerCallback();
    }

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
        mBtnOuter = (Button) findViewById(R.id.btn_outer);

        btnBasePop.setOnClickListener(this);
        mBtnTimerDown.setOnClickListener(this);
        mBtnDialogOne.setOnClickListener(this);
        mBtnDialogTwo.setOnClickListener(this);
        mBtnOuter.setOnClickListener(this);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            String strName = intent.getStringExtra(KEY_NAME);
            ToastManager.showShortMessage(this, "Name = " + strName);
        }
    }

    public static void launchAct(Context context) {
        Intent intent = new Intent(context, PopWinActivity.class);
        context.startActivity(intent);
    }

    public static void launchAct(Context context, String source) {
        Intent intent = new Intent(context, PopWinActivity.class);
        intent.putExtra(KEY_NAME, source);
        context.startActivity(intent);
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
            case R.id.btn_outer:   //调用外部方法
                if (mCallback != null) {
                    mCallback.outerCallback();
                }
                break;
        }
    }

    public void initBasePop() {
        View popView = View.inflate(this, R.layout.pop_base, null);
        popView.findViewById(R.id.pop_btn).setOnClickListener(this);
        BasePopupWindow payWindow = new BasePopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        payWindow.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
    }

    public void initOneBtnDialog() {
        initOneBtnDialog("");
    }

    public void initOneBtnDialog(String from) {
        OneBtnDialog oneBtnDialog = OneBtnDialog.newOneBtnDialog("标题 - kore" + from, "正文 - kore", "确定 - kore", new OneBtnCallback() {
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

    public OuterCallback getCallback() {
        return mCallback;
    }

    public void setCallback(OuterCallback callback) {
        mCallback = callback;
    }
}
