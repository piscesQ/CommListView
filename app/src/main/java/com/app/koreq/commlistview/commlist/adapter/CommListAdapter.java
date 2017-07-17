package com.app.koreq.commlistview.commlist.adapter;

import android.content.Context;

import com.app.koreq.commlistview.utils.CommListUtils;
import com.app.koreq.commlib.commlist.adapter.BaseListAdapter;
import com.app.koreq.commlib.commlist.bean.BaseListBean;
import com.app.koreq.commlib.commlist.render.BaseListRender;

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
        return CommListUtils.getTypeCount();
    }

    @Override
    public int getCustomItemViewType(int position) {
        return CommListUtils.getItemViewType(mList.get(position).getViewType());
    }

    @Override
    public BaseListRender getCustomListRender(int position) {
        return CommListUtils.getItemRender(mContext, mList.get(position));
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
