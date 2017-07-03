package com.app.koreq.commlib.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.app.koreq.commlib.R;

/**
 * project : CommListView
 * author : YanBin on 7/2/17
 * version : v
 * description : 自定义loading
 */
public class CommLoading extends FrameLayout {

    private ImageView mImageView;

    public CommLoading(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public CommLoading(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CommLoading(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mImageView = new ImageView(getContext());
        mImageView.setImageResource(R.drawable.anim_common_loading);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT,
                Gravity.CENTER);
        this.addView(mImageView, params);
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        if (mImageView != null) {
            if (visibility == View.VISIBLE) {
                AnimationDrawable animationDrawable = (AnimationDrawable) mImageView.getDrawable();
                animationDrawable.start();
            } else {
                AnimationDrawable animationDrawable = (AnimationDrawable) mImageView.getDrawable();
                animationDrawable.stop();
            }
        }
        super.onVisibilityChanged(changedView, visibility);
    }
}
