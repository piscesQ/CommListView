package com.app.koreq.commwidgetlib.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.app.koreq.commwidgetlib.R;

/**
 * project : CommListView
 * author : YanBin on 6/7/17
 * version : v4.0
 * description : dialog include two buttons yes and no
 */
public class TwoBtnDialog extends OneBtnDialog {

    private Button mBtnCancel;
    public TwoBtnCallback yesNoCallback;
    private String mStrCancel;
    private TwoBtnCallback mCallback;

    private DialogInterface.OnCancelListener cancelListener;

    public static TwoBtnDialog newTwoBtnDialog(String title, String content,
                                          String yes, String no, int btnVisibility,
                                          int contentGravity, TwoBtnCallback callback) {

        TwoBtnDialog fragment = new TwoBtnDialog();
        Bundle bundle = new Bundle();
        bundle.putString(DialogConst.KEY_TITLE, title);
        bundle.putString(DialogConst.KEY_CONTENT, content);
        bundle.putString(DialogConst.KEY_YES, yes);
        bundle.putString(DialogConst.KEY_NO, no);
        fragment.setYesNoCallback(callback);
        fragment.setOkVisibility(btnVisibility);
        fragment.setContentGravity(contentGravity);
        fragment.setArguments(bundle);
        return fragment;
    }

    public static TwoBtnDialog newTwoBtnDialog(String title, String content,
                                          String yes, String no, TwoBtnCallback callback) {
        return newTwoBtnDialog(title, content, yes, no, View.VISIBLE, Gravity.LEFT, callback);
    }

    public static TwoBtnDialog newTwoBtnDialog(String title_str, String content_str) {
        return newTwoBtnDialog(title_str, content_str, "", "", null);
    }

    public static TwoBtnDialog newTwoBtnDialog(String title_str, String content_str, TwoBtnCallback callback) {
        return newTwoBtnDialog(title_str, content_str, "", "", callback);
    }

    public static TwoBtnDialog newTwoBtnDialog(String title_str, String content_str, String yes, String no) {
        return newTwoBtnDialog(title_str, content_str, yes, no, null);
    }

    @Override
    protected int contentView() {
        return R.layout.dialog_yes_no;
    }

    @Override
    protected void getDataFromIntent() {
        super.getDataFromIntent();

        Bundle arguments = getArguments();
        mStrCancel = arguments.getString(DialogConst.KEY_NO);
    }

    @Override
    protected void initView() {
        super.initView();
        mBtnCancel = (Button) getRootView().findViewById(R.id.dialog_cancel);
        mBtnCancel.setOnClickListener(this);
        if (!TextUtils.isEmpty(mStrCancel)) {
            mBtnCancel.setText(mStrCancel);
        }
    }

    @Override
    public void onClick(View v) {
        dismissAllowingStateLoss();
        int id = v.getId();
        if (id == R.id.dialog_ok) {
            if (mCallback != null) {
                mCallback.onClickOk();
            }
        } else if (id == R.id.dialog_cancel) {
            if (mCallback != null) {
                mCallback.onClickCancel();
            }
        } else {

        }
    }

    public void setYesNoCallback(TwoBtnCallback callback) {
        mCallback = callback;
    }
}
