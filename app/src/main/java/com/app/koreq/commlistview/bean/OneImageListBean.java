package com.app.koreq.commlistview.bean;

import com.app.koreq.commlistviewlib.bean.BaseListBean;

/**
 * project : CommListView
 * author : YanBin on 3/19/17
 * description :
 */
public class OneImageListBean extends BaseListBean{
    private String title;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
