package com.app.koreq.commlib.commlist.render;

import android.view.View;

/**
 * project : CommListView
 * author : YanBin on 3/16/17
 * description : common bean for every list item
 */
public abstract class BaseListRender {
    protected View mContentView;

    public  View getContentView(){
        return mContentView;
    }

    public abstract void fillDataToView(int position);
}
