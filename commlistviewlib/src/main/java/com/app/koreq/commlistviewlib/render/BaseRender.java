package com.app.koreq.commlistviewlib.render;

/**
 * project : CommListView
 * author : YanBin on 3/16/17
 * description : common bean for every list item
 */
public class BaseRender {
    private int viewType;
    private int skipType;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public int getSkipType() {
        return skipType;
    }

    public void setSkipType(int skipType) {
        this.skipType = skipType;
    }
}
