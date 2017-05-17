package com.app.koreq.commlistview.net.bean;

import com.app.koreq.commlistview.MainApplication;

/**
 * project : CommListView
 * author : YanBin on 4/19/17
 * version : v3.2
 * description : request类
 */
public class BaseHttpRequest {
    //公共参数
    private String packageName = MainApplication.getInstance().getPackageName();

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
