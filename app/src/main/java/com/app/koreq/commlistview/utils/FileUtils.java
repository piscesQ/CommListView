package com.app.koreq.commlistview.utils;

import commlistview.MainApplication;

/**
 * project : CommListView
 * author : YanBin on 4/20/17
 * version : v3.2
 * description : 目录、文件相关工具类
 */
public class FileUtils {
    public static String getInnerCacheDir() {
        return MainApplication.getInstance().getCacheDir().toString();
    }
}
