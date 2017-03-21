package com.app.koreq.commlistview.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * project : CommListView
 * author : YanBin on 3/19/17
 * description :
 */
public class ListConstant {
    //========================= 服务端传入的viewType 数值由约定控制 ===============================
    public static final int VIEW_TEXT = 1;
    public static final int VIEW_ONE_IMAGE = 11;


    //========================= getItemViewType 的总数 ===============================
    public static final int TYPE_COUNT = ItemViewType.values().length;  //获得枚举类中values的长度

//    public static void testEnum(Context context) {
//        int a = ItemViewType.TYPE_TEXT.ordinal();
//        int b = ItemViewType.TYPE_ONE_IMAGE.ordinal();
//        int length = ItemViewType.values().length;
//        Toast.makeText(context, "length = " + length + " -" + a + " - " + b, Toast.LENGTH_SHORT).show();   //正常
//    }
}
