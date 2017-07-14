package com.app.koreq.commlib.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.app.koreq.commlib.utils.DensityUtils;

/**
 * author : YanBin on 7/13/17
 * version : v
 * description :
 */
public class CircleTextView extends AppCompatTextView {

    private Paint mPaint;
    private int mBgColor = Color.RED;
    private RectF mBgRect;
    private int mRadius = 10;    //Unit : dp  默认：10

    public CircleTextView(Context context) {
        super(context);
        initView();
    }

    public CircleTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CircleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
//        mBgRect = new RectF(0, 0, measuredWidth, measuredHeight);
        mPaint.setColor(mBgColor);
        //TODO kore  此方法：drawRoundRect  要求sdk >= 21
//        canvas.drawRoundRect(mBgRect, DensityUtils.dip2px(getContext(), mRadius), DensityUtils.dip2px(getContext(), mRadius), mPaint);
        canvas.drawRoundRect(0, 0, measuredWidth, measuredHeight,
                DensityUtils.dip2px(getContext(), mRadius), DensityUtils.dip2px(getContext(), mRadius), mPaint);
        super.onDraw(canvas);
    }

    public int getBgColor() {
        return mBgColor;
    }

    public void setBgColor(int bgColor) {
        mBgColor = bgColor;
        invalidate();
    }

    public void setBgAndRadius(int bgColor, int radius) {
        mBgColor = bgColor;
        mRadius = radius;
        invalidate();
    }
}
