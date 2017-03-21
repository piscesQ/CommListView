package com.app.koreq.commlistview.utils;

/**
 * project : CommListView
 * author : YanBin on 3/21/17
 * version : v2.0
 * description : getItemViewType 的返回值 数值从零开始，每次加一
 */
public enum ItemViewType {
    //===================== getItemViewType 的返回值 数值从零开始，每次加一 ===========================
    //调用 ordinal()方法，返回值即索引； 比如： ItemViewType.TYPE_TEXT.ordinal(); 返回值为0
    //每次增加类型，在枚举类末尾增加类型即可，必须在末尾
    TYPE_TEXT           //纯文本类型
    , TYPE_ONE_IMAGE    //一张图片类型
}