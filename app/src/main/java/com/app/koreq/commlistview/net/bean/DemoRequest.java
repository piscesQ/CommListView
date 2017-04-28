package com.app.koreq.commlistview.net.bean;

import com.app.koreq.commlistview.net.frame.bean.BaseHttpRequest;
import com.app.koreq.commlistview.net.frame.bean.BaseHttpResponse;

/**
 * project : CommListView
 * author : YanBin on 4/7/17
 * version : v3.0
 * description :
 */
public class DemoRequest extends BaseHttpRequest{
    private String data;
    private String uuid;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
