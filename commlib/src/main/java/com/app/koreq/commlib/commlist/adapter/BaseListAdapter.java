package com.app.koreq.commlib.commlist.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.app.koreq.commlib.commlist.render.BaseListRender;

/**
 * project : CommListView
 * author : YanBin on 3/19/17
 * description :
 */
public abstract class BaseListAdapter extends BaseAdapter {

    /**
     * @return int 即getViewTypeCount 最小为1
     */
    public abstract int getCustomViewTypeCount();

    /**
     * @return int getItemViewType
     */
    public abstract int getCustomItemViewType(int position);

    /**
     * 返回当前item对应的渲染类
     *
     * @return BaseListRender 根据类型返回对应的渲染类
     */
    public abstract BaseListRender getCustomListRender(int position);

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseListRender render = null;
        if (convertView == null) {
            render = getCustomListRender(position);
            convertView = render.getContentView();
            convertView.setTag(render);

        } else {
            render = (BaseListRender) convertView.getTag();
        }

        if (render != null) {
            render.fillDataToView(position);
        }

        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return getCustomViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return getCustomItemViewType(position);
    }
}
