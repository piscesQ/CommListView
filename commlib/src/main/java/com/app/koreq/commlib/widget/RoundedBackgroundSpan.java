package com.app.koreq.commlib.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

import com.app.koreq.commlib.R;

/**
 * project : CommListView
 * author : YanBin on 7/10/17
 * version : v5.0
 * description :
 */
public class RoundedBackgroundSpan extends ReplacementSpan {

    private static int CORNER_RADIUS = 8;   //圆角半径 Unit ：像素
    private int backgroundColor = 0;
    private int strokeColor = 0;
    private int textColor = 0;
    private int shadowColor = 0;    //阴影颜色

    public RoundedBackgroundSpan(Context context) {
        this(context, 0, 0, 0);
    }

    public RoundedBackgroundSpan(Context context, int bgColor, int textColor) {
        this(context, bgColor, 0, textColor);
    }

    public RoundedBackgroundSpan(Context context, int bgColor, int strokeColor, int textColor) {
        this(context, bgColor, strokeColor, textColor, 0);
    }

    public RoundedBackgroundSpan(Context context, int bgColor, int strokeColor, int textColor, int shadowColor) {
        super();
        if (bgColor == 0) {
            bgColor = R.color.gray_7e;
        }
        if (textColor == 0) {
            textColor = R.color.white;
        }
        this.backgroundColor = context.getResources().getColor(bgColor);
        this.textColor = context.getResources().getColor(textColor);

        if (strokeColor > 0) {
            this.strokeColor = context.getResources().getColor(strokeColor);
        }
        if (shadowColor > 0) {
            this.shadowColor = context.getResources().getColor(shadowColor);
        }
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        RectF rect = new RectF(x, top, x + measureText(paint, text, start, end), bottom);
//        //画阴影
//        if (shadowColor != 0) {
//            // 设定阴影 (柔边, X 轴位移, Y 轴位移, 阴影颜色)
//            paint.setShadowLayer(5, 3, 3, shadowColor);     //不是预期效果
//        }

        //画背景
        paint.setColor(backgroundColor);
        canvas.drawRoundRect(rect, CORNER_RADIUS, CORNER_RADIUS, paint);

        //画边框
        if (strokeColor != 0) {
            paint.setColor(strokeColor);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRoundRect(rect, CORNER_RADIUS, CORNER_RADIUS, paint);    //画出来的矩形中心是透明的
        }

        //画文字
        paint.setColor(textColor);
        canvas.drawText(text, start, end, x, y, paint);
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        return Math.round(paint.measureText(text, start, end));
    }

    private float measureText(Paint paint, CharSequence text, int start, int end) {
        return paint.measureText(text, start, end);
    }
}