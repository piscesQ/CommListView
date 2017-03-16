package net.hyww.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 比例布局，以宽为基准，高度等于宽的倍数,代码参考google io项目
 * Created by lilei on 2017/2/17.
 */

public class AspectRatioImageView extends ImageView {
    private float mAspectRatio = 1f;

    public AspectRatioImageView(Context context) {
        this(context, null, 0);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //得到自定义控件属性
        final TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.AspectRatioRelativeLayout, defStyle, 0);
        mAspectRatio = a.getFloat(R.styleable.AspectRatioRelativeLayout_aspectRatio, 0);
        if (mAspectRatio == 0f) {
            throw new IllegalArgumentException("You must specify an aspect ratio when using the " +
                    "AspectRatioView.");
        }
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int width, height;
        if (mAspectRatio != 0) {
            width = widthSize;
            height = (int) (width / mAspectRatio);
            int exactWidthSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
            int exactHeightSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
            super.onMeasure(exactWidthSpec, exactHeightSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
