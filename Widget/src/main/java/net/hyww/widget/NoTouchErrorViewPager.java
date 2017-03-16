package net.hyww.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 为了捕获（java.lang.IllegalArgumentException: pointerIndex out of range）
 * Created by zhou on 14-5-9.
 */
public class NoTouchErrorViewPager extends ViewPager {
    public NoTouchErrorViewPager(Context context) {
        super(context);
    }

    public NoTouchErrorViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean touch = false;
        try {
            touch = super.onInterceptTouchEvent(ev);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return touch;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean touch = false;
        try {
            touch = super.onTouchEvent(ev);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return touch;
    }
}
