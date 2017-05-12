package com.app.koreq.commlistview.utils;

import android.util.ArrayMap;

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
     * 只支持 key和value 都是 String 格式
     *
     * @param jsonString
     * @return
     */
    public static Map<String, String> json2Map(String jsonString){
        Map<String, String> map = new HashMap<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            Iterator it = jsonObject.keys();
            // 遍历jsonObject数据，添加到Map对象
            while (it.hasNext()) {
                String key = String.valueOf(it.next());
                Object objValue = jsonObject.get(key);
                if (objValue instanceof String) {
                    String value = (String) objValue;
                    if (value.length() == 0) value = "";
                    map.put(key, value);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return map;
    }
}
