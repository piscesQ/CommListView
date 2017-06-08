package com.app.koreq.commlib.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * project : CommListView
 * author : YanBin on 6/2/17
 * version : v4.0
 * description : 倒计时工具类
 */
public class CustomDownTimer extends CountDownTimer {
    private TextView mTextView;
    private int mCountDownColor;
    private int mFinishColor;
    private String mFinishText;

    public CustomDownTimer(long millisInFuture, long countDownInterval, TextView textView) {
        super(millisInFuture, countDownInterval);
        this.mTextView = textView;
    }

    public void setResource(int countDownColor, int finishColor, String finishText){
        this.mCountDownColor = countDownColor;
        this.mFinishColor = finishColor;
        this.mFinishText = finishText;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mTextView.setEnabled(false);
        mTextView.setTextColor(mCountDownColor);
        mTextView.setText(String.valueOf(millisUntilFinished / 1000));
    }

    @Override
    public void onFinish() {
        mTextView.setEnabled(true);
        mTextView.setTextColor(mFinishColor);
        mTextView.setText(mFinishText);
    }
}