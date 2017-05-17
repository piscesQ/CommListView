package com.app.koreq.netlib.bean;

import com.app.koreq.netlib.http.HttpConstants;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

import rx.Subscriber;

/**
 * project : CommListView
 * author : YanBin on 4/28/17
 * version : v
 * description :
 */
public abstract class BaseRequest<T> {
    private String mParams;
    private Map<String, String> mMapParams;
    private int mRequestType = HttpConstants.TYPE_POST;
    private Subscriber<T> mSubscriber;

    //    private int method = HttpConstants.METHOD_POST;
    public class Params {
        //TODO 公参
//        public long currTime = System.currentTimeMillis();    //测试正常 私有属性可以被继承到JSON中
    }

    public int getRequestType() {
        return mRequestType;
    }

    public void setRequestType(int requestType) {
        mRequestType = requestType;
    }

    public String getParams() {
        return mParams;
    }

    public void setBaseParams(String params) {
        mParams = params;
    }

    public Map<String, String> getMapParams() {
        return mMapParams;
    }

    public void setBaseMapParams(Map<String, String> mapParams) {
        mMapParams = mapParams;
    }

    public Subscriber<T> getSubscriber() {
        return mSubscriber;
    }

    public void setSubscriber(Subscriber<T> subscriber) {
        mSubscriber = subscriber;
    }

    public abstract String getUrl();

    public Type getType() {
        return new TypeToken<T>() {
        }.getType();
    }

    public abstract Type getResponseType();

    public boolean isEncrypt() { //默认加密
        return true;
    }
}
