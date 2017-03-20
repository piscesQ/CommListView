package com.app.koreq.commlistview.adapter;

import android.content.Context;

import com.app.koreq.commlistview.utils.ListUtils;
import com.app.koreq.commlistviewlib.adapter.BaseListAdapter;
import com.app.koreq.commlistviewlib.bean.BaseListBean;
import com.app.koreq.commlistviewlib.render.BaseListRender;

import java.util.List;

/**
 * project : CommListView
 * author : YanBin on 3/19/17
 * description :
 */
public class CommListAdapter extends BaseListAdapter {

    private List<BaseListBean> mList;
    private Context mContext;

    public CommListAdapter(Context context, List<BaseListBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    public void replaceData(List<BaseListBean> list){
        this.mList = list;
    }
    @Override
    public int getCustomViewTypeCount() {
        return ListUtils.getTypeCount();
    }

    @Override
    public int getCustomItemViewType(int position) {
        return ListUtils.getItemViewType(mList.get(position).getViewType());
    }

    @Override
    public BaseListRender getCustomListRender(int position) {
        return ListUtils.getItemRender(mContext, mList.get(position));
    }

    @Override
    public int getCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (mList != null) {
            return mList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
