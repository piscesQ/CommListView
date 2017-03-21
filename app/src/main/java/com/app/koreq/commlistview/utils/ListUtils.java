package com.app.koreq.commlistview.utils;

import android.content.Context;

import com.app.koreq.commlistview.render.OneImageRender;
import com.app.koreq.commlistview.render.TextRender;
import com.app.koreq.commlistviewlib.bean.BaseListBean;
import com.app.koreq.commlistviewlib.render.BaseListRender;

/**
 * project : CommListView
 * author : YanBin on 3/19/17
 * version : v1.0
 * description :
 */
public class ListUtils {

    public static int getTypeCount() {
        return ListConstant.TYPE_COUNT;
    }

    public static int getItemViewType(int viewType) {
        switch (viewType) {
            case ListConstant.VIEW_TEXT:
                return ItemViewType.TYPE_TEXT.ordinal();
            case ListConstant.VIEW_ONE_IMAGE:
                return ItemViewType.TYPE_ONE_IMAGE.ordinal();
            default:
                return ItemViewType.TYPE_TEXT.ordinal();
        }
    }

    public static BaseListRender getItemRender(Context context, BaseListBean bean) {
        int viewType = bean.getViewType();
        switch (viewType) {
            case ListConstant.VIEW_TEXT:
                return new TextRender(context, bean);
            case ListConstant.VIEW_ONE_IMAGE:
                return new OneImageRender(context, bean);
            default:
                return new TextRender(context, bean);
        }
    }
}
