package com.app.koreq.commwidgetlib;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

public class CPairSecondListView extends FrameLayout {
    private ListView mListView;

    public CPairSecondListView(Context context) {
        super(context);
    }

    public CPairSecondListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CPairSecondListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void init(Context _context) {
        setmListView();
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public boolean canScrollVertically(int direction) {
        setmListView();
        return mListView.canScrollVertically(direction);
    }

    private void setmListView() {
        if (mListView == null) {
            int count = getChildCount();
            for (int i = 0; i < count; i++) {
                View v = getChildAt(i);
                if (v instanceof ListView) {
                    mListView = (ListView) v;
                }
            }
        }
    }
}
