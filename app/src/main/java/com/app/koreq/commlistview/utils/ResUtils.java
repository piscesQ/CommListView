package com.app.koreq.commlistview.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.app.koreq.commlistview.MainApplication;

/**
 * project : CommListView
 * author : YanBin on 4/19/17
 * version : v
 * description :
 */
public class ResUtils {
    public static String getResString(int resId) {
        return MainApplication.getInstance().getResources().getString(resId);
    }

    public static int getResInt(int resId) {
        return MainApplication.getInstance().getResources().getInteger(resId);
    }

    public static boolean getResBool(int resId) {
        return MainApplication.getInstance().getResources().getBoolean(resId);
    }


    public static Context getContext() {
        return MainApplication.getInstance().getBaseContext();
    }

    /**
     * 得到Resource对象
     */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * 得到String.xml中定义的字符信息
     */
    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    /**
     * 得到String.xml中定义的字符信息,带占位符
     */
    public static String getString(int resId, Object... formatArgs) {
        return getResources().getString(resId, formatArgs);
    }

    /**
     * 得到String.xml中定义的字符数组信息
     */
    public static String[] getStrings(int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * 得到color.xml中定义的颜色信息
     */
    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    /**
     * 得到Drawable资源
     */
    public static Drawable getDrawable(int resId) {
        return getResources().getDrawable(resId);
    }

}
