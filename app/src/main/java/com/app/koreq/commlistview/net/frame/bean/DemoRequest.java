package com.app.koreq.commlistview.net.frame.bean;

/**
 * project : CommListView
 * author : YanBin on 4/19/17
 * version : v3.2
 * description : 测试request
 */
public class DemoRequest extends BaseHttpRequest {
    private int pageNo;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
