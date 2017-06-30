package com.app.koreq.commlistview.bean;

import com.app.koreq.aop.AopConst;
import com.app.koreq.commlib.widget.utils.DebugLog;

/**
 * project : CommListView
 * author : YanBin on 6/8/17
 * version : v
 * description :
 */
public class AopTestBean {
    private String name;
    private String tag;

    static {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi AopTestBean static block");
    }

    public AopTestBean() {

    }

    public AopTestBean(String name, String tag) {
        this.name = name;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
