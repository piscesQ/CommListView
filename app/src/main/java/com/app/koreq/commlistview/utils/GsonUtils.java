package com.app.koreq.commlistview.utils;

import com.app.koreq.commlistview.gson.CustomDeserializer;
import com.app.koreq.commlistviewlib.bean.BaseListBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

/**
 * project : CommListView
 * author : YanBin on 3/22/17
 * version : v2.0
 * description : Gson utils
 */
public class GsonUtils {
    private static Gson gsonInstance;
    private static Gson gsonCustomInstance;

    public synchronized static Gson getGson() {
        if (gsonInstance == null) {
            gsonInstance = new Gson();
        }
        return gsonInstance;
    }

    public synchronized static Gson getCustomGson() {
        if (gsonCustomInstance == null) {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(BaseListBean.class, new CustomDeserializer());
            gsonCustomInstance = builder.create();
        }
        return gsonCustomInstance;
    }

    public static void map2GsonTest(){
        //======================== map 转 json 测试  start ========================================
        HashMap<String, String> map = new HashMap<>();
        map.put("data", "111");
        map.put("data2", "222");
        map.put("data3", "333");
        String s = GsonUtils.getGson().toJson(map); //正常
        //======================== map 转 json 测试  end   ========================================

    }
}
