package com.app.koreq.commlistview.net.bean;

import java.util.List;

/**
 * project : CommListView
 * author : YanBin on 4/1/17
 * version : v
 * description :
 */
public class DemoListBean {

    public String code; // 000 正常
    public String msg;
    public List<MsgListResultData> data;

    public static class MsgListResultData {
        public int toUserId;   //收信息人id
        public int fromUserId; //发信息人id
        public String toUserName;  //收信息人名称
        public String fromUserName;    //发信息人名称
        public String content; // 内容
        public String sourceContent;   //  原文
        public long createTime;    // 创建时间
        public String thumbnail;   // 缩略图
        public int status; // 1:未读 ; 2:已读
        public int type;   //1评论、回复;  2点赞; 3系统提醒;
        public int bizType;    //1:圈子里的动态
        public String[] tags;   // 属性标签
        public MsgType msgType;    //	 	消息提示类型 文本框、 按钮
        public MsgTo msgTo;    //消息提示后 去向
        public String bak1;
        public String bak2;

        public class MsgType {
            public int type;  //类型:   0-没有 1-按钮 2-文本框
            public String actionUrl;     //操作后url
            public String actionParam;     // 操作后url 参数 json串
            public int encrypt;     //1:需要加密
            public String bak1;
            public String bak2;
        }

        public class MsgTo {
            public int jumpType;  //    跳转方式 0没有 1 H5 2原生
            public String h5Url;       // 链接地址
            public String h5Param;    // 参数
            public String h5Title; //    标题
            public String h5Thumbnail;     //缩略图
            public String nativeType;  //原生页面类型
            public String nativeParam; // 原生页面参数 json
            public String bak1;
            public String bak2;
        }
    }
}
