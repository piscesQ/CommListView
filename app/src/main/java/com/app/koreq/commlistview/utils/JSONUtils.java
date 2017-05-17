package com.app.koreq.commlistview.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * project : CommListView
 * author : YanBin on 5/3/17
 * version : v3.2
 * description : Android自带的JSON处理
 */
public class JSONUtils {
    /**
     * jsonz转成map
     * 支持json字符串中的 value 是 各种格式（Integer Long String JSONObject JSONArray）
     *
     * @param jsonString
     * @return
     */
    public static Map<String, String> json2Map(String jsonString) {
        Map<String, String> map = new HashMap<>();

        //测试数据  测试正常
//        jsonString = "{\"child_id\":0,\"class_id\":0,\"count\":0,\"data_ver\":0,\"is_public\":0,\"is_show\":0,\"myuser_id\":0,\"page\":0,\"platform\":0,\"school_app_type\":0,\"school_id\":0,\"type\":0,\"user_id\":0,\"version_code\":0,\"currTime\":1494574715782,\"bean\":{\"child_id\":1,\"class_id\":1},\"array\":[{\"child_id\":2,\"class_id\":2},{\"child_id\":3,\"class_id\":3}]}";    //kore test

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            Iterator it = jsonObject.keys();
            // 遍历jsonObject数据，添加到Map对象
            while (it.hasNext()) {
                String key = String.valueOf(it.next());
                Object objValue = jsonObject.get(key);
                String value = objValue.toString();
                if (value.length() == 0) value = "";
                map.put(key, value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return map;
    }
}
