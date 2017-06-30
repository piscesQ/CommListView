package com.app.koreq.commlib.commlist.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * project : CommListView
 * author : YanBin on 3/16/17
 * description : a custom common PullToRefreshListView
 */
public class CommListView extends ListView {


    public CommListView(Context context) {
        super(context);
    }

    public CommListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CommListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public CommListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
