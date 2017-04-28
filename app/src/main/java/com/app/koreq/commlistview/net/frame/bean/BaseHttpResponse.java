package com.app.koreq.commlistview.net.frame.bean;

/**
 * project : CommListView
 * author : YanBin on 4/19/17
 * version : v3.2
 * description :
 */
public class BaseHttpResponse {
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
