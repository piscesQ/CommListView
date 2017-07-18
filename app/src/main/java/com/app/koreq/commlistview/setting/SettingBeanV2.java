package com.app.koreq.commlistview.setting;

import java.util.List;

/**
 * project : CommListView
 * author : YanBin on 7/17/17
 * version : v5.0
 * description : 设置页面 bean
 */
public class SettingBeanV2 {

    //    测试数据 - json - v2
//    String testHeadData = "{\"attentionCount\":0,\"avatar\":\"http://filesystem1.bbtree.com/2016/01/06/cfcd208495d565ef66e7dff9f98764da/ios/1452069055370771.jpg@200h_200w_1e_1c\",\"childAvatar\":\"http://y.bbtree.com/public/uploads/2014/4/20140420085901397.jpg\",\"childFlag\":1,\"childName\":\"小宝\",\"collectCount\":0,\"isMemeber\":1,\"nickName\":\"KoreQ12\",\"signature\":\"天气不错\",\"trendsCount\":0}";
//    String testListData = "[[{"linkGroup":2,"linkName":"家庭成员","linkPhoto":"http://s0.bbtree.com/public/myself/child_invitation.png","linkRule":{"bubble":{"color":"red","words":"1"},"image":"http://s0.bbtree.com/public/myself/child_equipment.png","redPoint":1,"text":{"color":"#ff0000","words":"哈哈"}},"linkType":2,"linkUrl":"","point":"JZ_Wo_YaoQingJiaRen","type":2},{"linkGroup":2,"linkName":"智能硬件","linkPhoto":"http://s0.bbtree.com/public/myself/child_equipment.png","linkRule":{"bubble":{"color":"","words":""},"image":"","redPoint":1,"text":{"color":"","words":"续费"}},"linkType":3,"linkUrl":"","point":"JZ_Wo_ZhiNengSheBei","type":3}],[{"linkGroup":3,"linkName":"我的会员","linkPhoto":"http://s0.bbtree.com/public/myself/child_vips.png","linkRule":{"bubble":{"color":"red","words":""},"image":"http://s0.bbtree.com/public/myself/child_icon_flower.png","redPoint":1,"text":{"color":"","words":""}},"linkType":4,"linkUrl":"","point":"JZ_Wo_HuiYuanZhongXin","type":4},{"linkGroup":3,"linkName":"我的排名","linkPhoto":"http://s0.bbtree.com/public/myself/child_ranking.png","linkRule":{"bubble":{"color":"","words":""},"image":"http://s0.bbtree.com/public/myself/child_comment.png","redPoint":0,"text":{"color":"","words":"排名"}},"linkType":5,"linkUrl":"","point":"JZ_Wo_BanJiPaiHang","type":5},{"linkGroup":3,"linkName":"我的小红花","linkPhoto":"http://s0.bbtree.com/public/myself/child_icon_flower.png","linkRule":{"bubble":{"color":"","words":""},"image":"","redPoint":1,"text":{"color":"","words":""}},"linkType":6,"linkUrl":"http://s0.bbtree.com/5.0/redFlowerRule.html?userId\u003d107\u0026childId\u003d1003\u0026r\u003d1287362284","point":"JZ_Wo_WoDeXiaoHongHua","type":1},{"linkGroup":3,"linkName":"我的评论","linkPhoto":"http://s0.bbtree.com/public/myself/child_comment.png","linkRule":{"bubble":{"color":"","words":""},"image":"http://s0.bbtree.com/public/myself/child_icon_flower.png","redPoint":0,"text":{"color":"","words":""}},"linkType":7,"linkUrl":"","point":"JZ_Wo_WoDePingLun","type":6}],[{"linkGroup":4,"linkName":"我的关注","linkPhoto":"http://s0.bbtree.com/public/myself/child_follow.png","linkRule":{"bubble":{"color":"","words":""},"image":"","redPoint":0,"text":{"color":"","words":"关注"}},"linkType":8,"linkUrl":"","point":"JZ_Wo_WoDeGuanZhu","type":7},{"linkGroup":4,"linkName":"我的动态","linkPhoto":"http://s0.bbtree.com/public/myself/child_dynamic.png","linkRule":{"bubble":{"color":"","words":""},"image":"","redPoint":0,"text":{"color":"","words":""}},"linkType":9,"linkUrl":"","point":"JZ_Wo_WoDeDongTai","type":8},{"linkGroup":4,"linkName":"我的收藏","linkPhoto":"http://s0.bbtree.com/public/myself/child_collection.png","linkRule":{"bubble":{"color":"","words":""},"image":"","redPoint":0,"text":{"color":"","words":""}},"linkType":10,"linkUrl":"","point":"JZ_Wo_WoDeShouCang","type":9}],[{"linkGroup":5,"linkName":"我的保险","linkPhoto":"http://s0.bbtree.com/public/myself/child_Insurance.png","linkRule":{"bubble":{"color":"","words":""},"image":"","redPoint":0,"text":{"color":"","words":""}},"linkType":11,"linkUrl":"http://s0.bbtree.com/insurance/pages/index.html?user_id\u003d107\u0026child_id\u003d1003\u0026r\u003d322258932","point":"cm_6","type":1}],[{"linkGroup":6,"linkName":"我的账户","linkPhoto":"http://s0.bbtree.com/public/myself/child_icon_bean.png","linkRule":{"bubble":{"color":"","words":""},"image":"","redPoint":0,"text":{"color":"","words":""}},"linkType":12,"linkUrl":"","point":"cm_6","type":10},{"linkGroup":6,"linkName":"我的订单","linkPhoto":"http://s0.bbtree.com/public/myself/c_my_order.png","linkRule":{"bubble":{"color":"","words":""},"image":"","redPoint":0,"text":{"color":"","words":""}},"linkType":13,"linkUrl":"https://auction-static.bbtree.com/payweb/my-order.html?user_id\u003d107\u0026token\u003d7693862a077220fe2d207c860a696d8c\u0026username\u003d18800000011\u0026r\u003d154833518","point":"JZ_Wo_WoDeDingDan","type":1}],[{"linkGroup":7,"linkName":"使用反馈","linkPhoto":"http://s0.bbtree.com/public/myself/child_feedback.png","linkRule":{"bubble":{"color":"","words":""},"image":"","redPoint":0,"text":{"color":"","words":""}},"linkType":14,"linkUrl":"","point":"JZ_Wo_ShiYongFanKui","type":11},{"linkGroup":0,"linkName":"设置","linkPhoto":"local://2130839078","linkRule":{"redPoint":1},"linkType":0,"type":99}]]";

    //以下是list的实体
    public List<List<DataBean>> list;

    public static class DataBean {
        public int linkGroup;
        public String linkName;
        public String linkPhoto;
        public LinkRuleBean linkRule;
        public int linkType;
        public String linkUrl;
        public String point;
        public int type;

        public static class LinkRuleBean {
            /**
             * bubble : {"color":"red","words":"1"}
             * image : jpg
             * redPoint : 0
             * text : {"color":"11","words":"哈哈"}
             */

            public TextBean bubble;
            public String image;
            public int redPoint;
            public TextBean text;

            public static class TextBean {
                /**
                 * color : 11
                 * words : 哈哈
                 */

                public String color;
                public String words;
            }
        }
    }
}
