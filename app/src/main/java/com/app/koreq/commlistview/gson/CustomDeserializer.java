package com.app.koreq.commlistview.gson;

import com.app.koreq.commlistview.bean.OneImageListBean;
import com.app.koreq.commlistview.bean.TextListBean;
import com.app.koreq.commlistview.utils.GsonUtils;
import com.app.koreq.commlistview.utils.ListConstant;
import com.app.koreq.commlistviewlib.bean.BaseListBean;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * project : CommListView
 * author : YanBin on 3/22/17
 * version : v2.0
 * description : 自定义的Gson解析器
 */
public class CustomDeserializer implements JsonDeserializer<BaseListBean> {

    @Override
    public BaseListBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        int viewType = jsonObject.get(ListConstant.NAME_VIEW_TYPE).getAsInt();

        return getListBean(json, viewType);
    }

    //TODO 考虑多层情况 例如水平滚动容器
    private BaseListBean getListBean(JsonElement json, int viewType) {
        BaseListBean bean = null;
        switch (viewType) {
            case ListConstant.VIEW_TEXT:
                bean = GsonUtils.getGson().fromJson(json, TextListBean.class);
                break;
            case ListConstant.VIEW_ONE_IMAGE:
                bean = GsonUtils.getGson().fromJson(json, OneImageListBean.class);
                break;
            default:
                bean =  GsonUtils.getGson().fromJson(json, BaseListBean.class);
        }
        return bean;
    }
}
