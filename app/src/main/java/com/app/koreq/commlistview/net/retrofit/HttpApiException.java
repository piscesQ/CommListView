package com.app.koreq.commlistview.net.retrofit;

import android.util.Log;

/**
 * project : CommListView
 * author : YanBin on 4/21/17
 * version : v3.2
 * description : 自定义 Http 异常类
 */
public class HttpApiException extends RuntimeException {
    private int errorCode;
    private String errorMsg;

    public HttpApiException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public void printStackTrace() {
        Log.e(HttpConstant.TAG, "errorCode = " + errorCode + "; msg : " + errorMsg);
        super.printStackTrace();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
