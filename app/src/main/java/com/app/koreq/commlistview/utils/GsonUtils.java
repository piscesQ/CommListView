package com.app.koreq.commlistview.utils;

import com.app.koreq.commlistview.gson.CustomDeserializer;
import com.app.koreq.commlistviewlib.bean.BaseListBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * project : CommListView
 * author : YanBin on 3/22/17
 * version : v2.0
 * description : Gson utils
 */
public class GsonUtils {
    private static Gson gsonInstance;
    private static Gson gsonCustomInstance;

    public static Gson getGson() {
        if (gsonInstance == null) {
            gsonInstance = new Gson();
        }
        return gsonInstance;
    }

    public static Gson getCustomGson() {
        if (gsonCustomInstance == null) {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(BaseListBean.class, new CustomDeserializer());
            gsonCustomInstance = builder.create();
        }
        return gsonCustomInstance;
    }
}