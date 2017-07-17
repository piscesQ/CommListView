package com.app.koreq.commlib.utils;

import java.util.List;

/**
 * project : CommListView
 * author : YanBin on 7/17/17
 * version : v5.0
 * description : List工具类
 */
public class ListUtils {
    /**
     * 获取LIST的长度
     *
     * @param list 传入的list
     * @return
     */
    public static int getSize(List list) {
        if (list == null || list.size() < 1) {
            return 0;
        } else {
            return list.size();
        }
    }
}
