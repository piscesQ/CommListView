package com.app.koreq.commwidgetlib.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.app.koreq.commwidgetlib.R;

/**
 * project : CommListView
 * author : YanBin on 6/7/17
 * version : v4.0
 * description : dialog include one button yes
 */
public class OneBtnDialog extends DialogFragment implements View.OnClickListener {

    private View rootView;
    protected TextView mTvTitle, mTvContent;
    protected Button mBtnOk;
    private String mStrTitle, mStrContent, mStrYes;
    private OneBtnCallback mCallback;
//    private DialogInterface.OnCancelListener cancelListener;

    private int mOkVisibility = View.VISIBLE;   //确认按钮的可见性
    private int mContentGravity = Gravity.LEFT; //提示正文的对齐规则

    public OneBtnDialog() {
        super();
    }

    protected int contentView() {
        return R.layout.dialog_only_yes;
    }

    /**
     * @param title
     * @param content
     * @param yes
     * @param btnVisibility  按钮可见性
     * @param contentGravity 提示正文对齐规则
     * @param callback
     * @return
     */
    public static OneBtnDialog newOneBtnDialog(String title, String content,
                                            String yes, int btnVisibility,
                                            int contentGravity, OneBtnCallback callback) {
        OneBtnDialog fragment = new OneBtnDialog();
        Bundle bundle = new Bundle();
        bundle.putString(DialogConst.KEY_TITLE, title);
        bundle.putString(DialogConst.KEY_CONTENT, content);
        bundle.putString(DialogConst.KEY_YES, yes);
        fragment.setCallback(callback);
        fragment.setOkVisibility(btnVisibility);
        fragment.setContentGravity(contentGravity);
        fragment.setArguments(bundle);
        return fragment;
    }

    public static OneBtnDialog newOneBtnDialog(String title, String content,
                                            String yes, OneBtnCallback callback) {
        return newOneBtnDialog(title, content, yes, View.VISIBLE, Gravity.LEFT, callback);
    }

    public static OneBtnDialog newOneBtnDialog(String title_str, String content_str) {
        return newOneBtnDialog(title_str, content_str, "", null);
    }

    public static OneBtnDialog newOneBtnDialog(String title_str, String content_str, OneBtnCallback callback) {
        return newOneBtnDialog(title_str, content_str, "", callback);
    }

    public static OneBtnDialog newOneBtnDialog(String title_str, String content_str, String yes) {
        return newOneBtnDialog(title_str, content_str, yes, null);
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.up_dialog);
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView != null) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        } else {
            rootView = inflater.inflate(contentView(), container, false);
            getDataFromIntent();
            initView();
        }
        return rootView;
    }

    protected void getDataFromIntent() {
        Bundle args = getArguments();
        if (args == null)
            return;
        mStrTitle = args.getString(DialogConst.KEY_TITLE);
        mStrContent = args.getString(DialogConst.KEY_CONTENT);
        mStrYes = args.getString(DialogConst.KEY_YES);
    }

    protected void initView() {
        mTvTitle = (TextView) rootView.findViewById(R.id.dialog_title);
        mTvContent = (TextView) rootView.findViewById(R.id.dialog_content);
        mTvContent.setGravity(mContentGravity);
        mBtnOk = (Button) rootView.findViewById(R.id.dialog_ok);
        mBtnOk.setOnClickListener(this);
        mBtnOk.setVisibility(mOkVisibility);

        if (!TextUtils.isEmpty(mStrTitle)) {  // mStrTitle 有数据
            mTvTitle.setVisibility(View.VISIBLE);
            mTvTitle.setText(mStrTitle);
        } else {  // mStrTitle 无数据
            mTvTitle.setVisibility(View.GONE);
        }
        mTvContent.setText(mStrContent);
        if (!TextUtils.isEmpty(mStrTitle)) {
            mBtnOk.setText(mStrYes);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        dismissAllowingStateLoss();
        int id = view.getId();
        if (id == R.id.dialog_ok) {
            if (mCallback != null) {
                mCallback.onClickBtn();
            }
        }
    }

    public View getRootView() {
        return rootView;
    }

    public OneBtnCallback getCallback() {
        return mCallback;
    }

    public void setCallback(OneBtnCallback callback) {
        mCallback = callback;
    }

    public int getOkVisibility() {
        return mOkVisibility;
    }

    public void setOkVisibility(int okVisibility) {
        mOkVisibility = okVisibility;
    }

    public int getContentGravity() {
        return mContentGravity;
    }

    public void setContentGravity(int contentGravity) {
        mContentGravity = contentGravity;
    }

    public void setYesCallback(OneBtnCallback yesNoCallback) {
        this.mCallback = yesNoCallback;
    }

//    public void setDialogCancelListener(DialogInterface.OnCancelListener cancelListener) {
//        if (getDialog() != null) {
//            getDialog().setOnCancelListener(cancelListener);
//        }
//    }
}
