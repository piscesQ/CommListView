package com.app.koreq.commlistview.render;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.app.koreq.commlistview.R;
import com.app.koreq.commlistview.bean.OneImageListBean;
import com.app.koreq.commlistview.bean.TextListBean;
import com.app.koreq.commlistviewlib.bean.BaseListBean;
import com.app.koreq.commlistviewlib.render.BaseListRender;

/**
 * project : CommListView
 * author : YanBin on 3/19/17
 * description :
 */
public class OneImageRender extends BaseListRender {

    private BaseListBean mBean;
    private Context mContext;
    private TextView mTitle;

    public OneImageRender(Context context, BaseListBean bean){
        this.mContext = context;
        this.mBean = bean;
    }

    @Override
    public View getContentView() {
        mContentView = View.inflate(mContext, R.layout.list_item_one_image, null);
        mTitle = (TextView) mContentView.findViewById(R.id.list_one_image_title);
        return super.getContentView();
    }

    @Override
    public void fillDataToView(int position) {
        OneImageListBean bean = (OneImageListBean) mBean;
        if (bean != null) {
            mTitle.setText(bean.getTitle() + " : " + bean.getUrl());
        }
    }
}
