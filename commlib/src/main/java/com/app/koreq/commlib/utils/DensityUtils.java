package com.app.koreq.commlib.utils;

import android.content.Context;

import commlistview.MainApplication;

/**
 * project : CommListView
 * author : YanBin on 5/20/17
 * version : v
 * description : 分辨率单位转换、屏幕分辨率等信息
 */
public class DensityUtils {

    /**
     * 手机宽度
     * @return Unit: px
     */
    public static int maxWidth() {
        return MainApplication.getInstance().getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 手机高度
     * @return Unit: px
     */
    public static int maxHeight() {
        return MainApplication.getInstance().getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 sp,字体的转换
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 sp 的单位 转成为 px(像素),字体的转换
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
