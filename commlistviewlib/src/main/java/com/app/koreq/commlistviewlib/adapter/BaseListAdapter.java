package com.app.koreq.commlistviewlib.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.app.koreq.commlistviewlib.render.BaseListRender;

/**
 * project : CommListView
 * author : YanBin on 3/19/17
 * description :
 */
public abstract class BaseListAdapter extends BaseAdapter {

    public abstract int getCustomViewTypeCount();

    public abstract int getCustomItemViewType(int position);

    public abstract BaseListRender getCustomListRender(int position);

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseListRender render = null;
        if(convertView == null){
            render = getCustomListRender(position);
            convertView = render.getContentView();
            convertView.setTag(render);

        }else{
            render = (BaseListRender) convertView.getTag();
        }

        if(render != null){
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
