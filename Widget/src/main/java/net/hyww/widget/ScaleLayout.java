package net.hyww.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 比例尺布局。通过设置纵横比来计算布局的自适应宽高。（以宽度为base计算高度）
 * Created by zhou on 14-5-12.
 */
public class ScaleLayout extends LinearLayout {
    public int scale_height = 1;
    public int scale_width = 1;
    public boolean base_as_width = true;


    public ScaleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.bbtree_scale_layout);
        scale_width = typedArray.getInt(R.styleable.bbtree_scale_layout_scale_w, 1);
        scale_height = typedArray.getInt(R.styleable.bbtree_scale_layout_scale_h, 1);
        base_as_width = typedArray.getBoolean(R.styleable.bbtree_scale_layout_base_as_w, true);
    }

    public void setScale(int scale_width,int scale_height){
        this.scale_width=scale_width;
        this.scale_height=scale_height;
    }

    @SuppressWarnings("unused")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));

        int childWidthSize;
        int childHeightSize;
        if (base_as_width) {
            // Children are just made to fill our space.
            childWidthSize = getMeasuredWidth();
            childHeightSize = childWidthSize * scale_height / scale_width;
        } else {
            // Children are just made to fill our space.
            childHeightSize = getMeasuredHeight();
            childWidthSize = childHeightSize * scale_width / scale_height;
        }

        widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(childHeightSize, MeasureSpec.EXACTLY);
        if (getChildCount() < 1||(scale_width < 1 && scale_height < 1)) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        View child = getChildAt(0);
        if(child == null){
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }

        child.measure(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
