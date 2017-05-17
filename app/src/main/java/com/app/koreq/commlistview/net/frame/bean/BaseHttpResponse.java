package com.app.koreq.commlistview.net.frame.bean;

/**
 * project : CommListView
 * author : YanBin on 4/19/17
 * version : v3.2
 * description : 封装的Response的父类 所有的Response返回的对象都应该继承此类
 */
public class BaseHttpResponse {
    private int error_code;
    private String error;   //错误信息

    public int getCode() {
        return error_code;
    }

    public void setCode(int code) {
        this.error_code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
