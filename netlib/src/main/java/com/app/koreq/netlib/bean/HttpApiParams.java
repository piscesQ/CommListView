package com.app.koreq.netlib.bean;

/**
 * project : CommListView
 * author : YanBin on 5/2/17
 * version : v3.2
 * description : 最终的参数类
 */
public class HttpApiParams {
    private String uuid;
    private String data;    //存放BaseRequest.Params的序列化对象

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
