package com.app.koreq.commlib.commlist.bean;

/**
 * project : CommListView
 * author : YanBin on 3/19/17
 * description :
 */
public class BaseListBean {
    private int viewType;
    private int invokeType;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public int getInvokeType() {
        return invokeType;
    }

    public void setInvokeType(int invokeType) {
        this.invokeType = invokeType;
    }
}
