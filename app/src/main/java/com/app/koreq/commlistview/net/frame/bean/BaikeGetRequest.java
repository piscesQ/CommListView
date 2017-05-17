package com.app.koreq.commlistview.net.frame.bean;

import com.app.koreq.commlistview.net.bean.BaikeResult;
import com.app.koreq.commlistview.utils.GsonUtils;
import com.app.koreq.netlib.bean.BaseRequest;
import com.app.koreq.netlib.http.HttpConstants;

import java.lang.reflect.Type;

/**
 * project : CommListView
 * author : YanBin on 5/3/17
 * version : v3.2
 * description : Demo - 测试get请求
 */
public class BaikeGetRequest extends BaseRequest<BaikeResult> {
    private Params mChildParams;

    public BaikeGetRequest() {
        mChildParams = new Params();
        setRequestType(HttpConstants.TYPE_GET);
    }

    @Override
    public String getUrl() {
        return "api/openapi/BaikeLemmaCardApi";
    }

    @Override
    public Type getResponseType() {
        return BaikeResult.class;
    }

    public void setParams() {
        String strParams = GsonUtils.getGson().toJson(mChildParams, Params.class);
        setBaseParams(strParams); //传入父类
    }

    class Params extends BaseRequest.Params {
        //        scope=103&format=json&appid=379020&bk_key=%E9%87%91%E5%88%9A%E7%8B%BC&bk_length=600
        private String scope = "103";
        private String format = "json";
        private String appid = "379020";
        private String bk_key = "金刚狼";     //%E9%87%91%E5%88%9A%E7%8B%BC
        private String bk_length = "600";
    }
}
