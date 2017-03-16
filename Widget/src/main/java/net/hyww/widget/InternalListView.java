package net.hyww.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by zhou on 14-3-21.
 */
public class InternalListView extends ListView {

    private boolean mIsHandlingFocusChange=false;

    public InternalListView(Context context) {
        super(context);
    }

    public InternalListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InternalListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        mIsHandlingFocusChange = true;
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        mIsHandlingFocusChange = false;
    }

    @Override
    public void requestLayout() {
        if (!mIsHandlingFocusChange) {
            super.requestLayout();
        }
    }

//    @Override
//    public void requestLayout() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
//            if (!isInLayout()) {
//                super.requestLayout();
//            }
//        }
//    }
}
