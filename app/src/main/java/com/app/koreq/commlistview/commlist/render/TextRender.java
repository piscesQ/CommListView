package com.app.koreq.commlistview.commlist.render;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.app.koreq.commlistview.R;
import com.app.koreq.commlistview.commlist.bean.TextListBean;
import com.app.koreq.commlistviewlib.bean.BaseListBean;
import com.app.koreq.commlistviewlib.render.BaseListRender;

/**
 * project : CommListView
 * author : YanBin on 3/19/17
 * description :
 */
public class TextRender extends BaseListRender {

    private BaseListBean mBean;
    private Context mContext;
    private TextView mTitle;

    public TextRender(Context context, BaseListBean bean){
        this.mContext = context;
        this.mBean = bean;
    }

    @Override
    public View getContentView() {
        mContentView = View.inflate(mContext, R.layout.list_item_text, null);
        mTitle = (TextView) mContentView.findViewById(R.id.list_text_title);
        return super.getContentView();
    }

    @Override
    public void fillDataToView(int position) {
        TextListBean textListBean = (TextListBean) mBean;
        if (textListBean != null) {
            mTitle.setText(textListBean.getTitle());
        }
    }
}
