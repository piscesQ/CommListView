package com.app.koreq.commlistviewlib.view;

import android.content.Context;
import android.util.AttributeSet;

import net.hyww.widget.xlistview.PullToRefreshView;

/**
 * project : CommListView
 * author : YanBin on 3/16/17
 * description : a custom common PullToRefreshListView
 */
public class CommListView extends PullToRefreshView{

    public CommListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CommListView(Context context) {
        super(context);
    }
}
