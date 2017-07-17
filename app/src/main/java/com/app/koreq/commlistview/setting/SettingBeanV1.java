package com.app.koreq.commlistview.setting;

import java.util.List;

/**
 * project : CommListView
 * author : YanBin on 7/14/17
 * version : v
 * description :
 */
public class SettingBeanV1 {
//   测试数据 - json - v1
//    String testData = "{\"list\":[[{\"title\":\"邀请家人\",\"type\":8,\"icon\":\"http://s0.bbtree.com/public/myself/child_invitation.png?20170711\",\"url\":\"\",\"is_web\":0,\"is_new\":0,\"desc\":\"\",\"point\":\"JZ_Wo_YaoQingJiaRen\"}],[{\"title\":\"智能硬件\",\"type\":31,\"icon\":\"http://s0.bbtree.com/public/myself/child_equipment.png?20170711\",\"url\":\"\",\"is_web\":0,\"is_new\":0,\"desc\":\"\",\"point\":\"JZ_Wo_ZhiNengSheBei\"}],[{\"title\":\"会员中心\",\"type\":3,\"icon\":\"http://s0.bbtree.com/public/myself/child_vips.png?20170711\",\"url\":\"\",\"is_new\":0,\"is_web\":0,\"desc\":\"续费\",\"point\":\"JZ_Wo_HuiYuanZhongXin\"},{\"title\":\"我的排行\",\"type\":1,\"icon\":\"http://s0.bbtree.com/public/myself/child_ranking.png?20170711\",\"url\":\"\",\"is_new\":0,\"is_web\":0,\"desc\":\"本月暂居第1名\",\"point\":\"JZ_Wo_BanJiPaiHang\"},{\"title\":\"我的小红花\",\"type\":2,\"icon\":\"http://s0.bbtree.com/public/myself/child_icon_flower.png?20170711\",\"url\":\"http://s0.bbtree.com/5.0/redFlowerRule.html?userId=212385362&childId=210391841&r=104\",\"is_new\":0,\"is_web\":1,\"desc\":\"267\",\"color\":\"#999999\",\"point\":\"JZ_Wo_WoDeXiaoHongHua\"}],[{\"title\":\"我的关注\",\"type\":32,\"icon\":\"http://s0.bbtree.com/public/myself/child_follow.png?20170711\",\"url\":\"\",\"is_web\":0,\"is_new\":0,\"desc\":\"\",\"point\":\"JZ_Wo_WoDeGuanZhu\"},{\"title\":\"我的动态\",\"type\":4,\"icon\":\"http://s0.bbtree.com/public/myself/child_dynamic.png?20170711\",\"url\":\"\",\"is_web\":0,\"is_new\":0,\"desc\":\"\",\"point\":\"JZ_Wo_WoDeDongTai\"},{\"title\":\"我的收藏\",\"type\":5,\"icon\":\"http://s0.bbtree.com/public/myself/child_collection.png?20170711\",\"url\":\"\",\"is_web\":0,\"is_new\":0,\"desc\":\"\",\"point\":\"JZ_Wo_WoDeShouCang\"},{\"title\":\"我的评论\",\"type\":15,\"icon\":\"http://s0.bbtree.com/public/myself/child_comment.png?20170711\",\"url\":\"\",\"is_web\":0,\"is_new\":0,\"desc\":\"\",\"point\":\"JZ_Wo_WoDePingLun\"}],[{\"title\":\"我的账户\",\"type\":17,\"icon\":\"http://s0.bbtree.com/public/myself/child_icon_bean.png?20170711\",\"url\":\"\",\"is_new\":0,\"is_web\":0,\"desc\":\"0\",\"point\":\"cm_6\"},{\"title\":\"我的订单\",\"type\":2,\"icon\":\"http://s0.bbtree.com/public/myself/c_my_order.png?20170711\",\"url\":\"https://auction-static.bbtree.com/payweb/my-order.html?user_id=212385362&token=19f65ff9263d28829742680e24b8775b&username=13522225555&r=239\",\"is_web\":1,\"is_new\":0,\"desc\":\"\",\"point\":\"JZ_Wo_WoDeDingDan\"},{\"title\":\"我的保险\",\"type\":2,\"icon\":\"http://s0.bbtree.com/public/myself/child_Insurance.png?20170711\",\"url\":\"http://s0.bbtree.com/insurance/pages/index.html?user_id=212385362&child_id=210391841\",\"is_new\":0,\"is_web\":1,\"desc\":\"\",\"point\":\"cm_6\"}],[{\"title\":\"使用反馈\",\"type\":9,\"icon\":\"http://s0.bbtree.com/public/myself/child_feedback.png?20170711\",\"url\":\"\",\"is_web\":0,\"is_new\":0,\"desc\":\"\",\"point\":\"JZ_Wo_ShiYongFanKui\"}]],\"info\":{\"name\":\"youyou1234\",\"avatar\":\"http://filesystem1.bbtree.com/2015/12/24/BEF08B4F0ED57069150DEFA140942E301450943792938608.jpg@200h_200w_1e_1c\",\"call\":\"妈妈\",\"score\":98,\"flower\":267,\"level\":4,\"begin_score\":61,\"next_score\":120,\"level_icon\":{\"sun\":0,\"moon\":1,\"star\":0},\"flower_rule\":\"http://s0.bbtree.com/5.0/redFlowerRule.html?userId=212385362&childId=210391841&r=1496\",\"gold\":0,\"is_member\":\"1\",\"nickname\":\"伤感的椰子\",\"signature\":\"\",\"child_avatar\":\"http://filesystem1.bbtree.com/2017/06/22/e015ff8c5f6e1cf0695a08121507a38c/And/1498119180183-1244746321.jpg\"}}";

    /**
     * list : [[{"title":"邀请家人","type":8,"icon":"http://s0.bbtree.com/public/myself/child_invitation.png?20170711","url":"","is_web":0,"is_new":0,"desc":"","point":"JZ_Wo_YaoQingJiaRen"}],[{"title":"智能硬件","type":31,"icon":"http://s0.bbtree.com/public/myself/child_equipment.png?20170711","url":"","is_web":0,"is_new":0,"desc":"","point":"JZ_Wo_ZhiNengSheBei"}],[{"title":"会员中心","type":3,"icon":"http://s0.bbtree.com/public/myself/child_vips.png?20170711","url":"","is_new":0,"is_web":0,"desc":"续费","point":"JZ_Wo_HuiYuanZhongXin"},{"title":"我的排行","type":1,"icon":"http://s0.bbtree.com/public/myself/child_ranking.png?20170711","url":"","is_new":0,"is_web":0,"desc":"本月暂居第1名","point":"JZ_Wo_BanJiPaiHang"},{"title":"我的小红花","type":2,"icon":"http://s0.bbtree.com/public/myself/child_icon_flower.png?20170711","url":"http://s0.bbtree.com/5.0/redFlowerRule.html?userId=212385362&childId=210391841&r=104","is_new":0,"is_web":1,"desc":"267","color":"#999999","point":"JZ_Wo_WoDeXiaoHongHua"}],[{"title":"我的关注","type":32,"icon":"http://s0.bbtree.com/public/myself/child_follow.png?20170711","url":"","is_web":0,"is_new":0,"desc":"","point":"JZ_Wo_WoDeGuanZhu"},{"title":"我的动态","type":4,"icon":"http://s0.bbtree.com/public/myself/child_dynamic.png?20170711","url":"","is_web":0,"is_new":0,"desc":"","point":"JZ_Wo_WoDeDongTai"},{"title":"我的收藏","type":5,"icon":"http://s0.bbtree.com/public/myself/child_collection.png?20170711","url":"","is_web":0,"is_new":0,"desc":"","point":"JZ_Wo_WoDeShouCang"},{"title":"我的评论","type":15,"icon":"http://s0.bbtree.com/public/myself/child_comment.png?20170711","url":"","is_web":0,"is_new":0,"desc":"","point":"JZ_Wo_WoDePingLun"}],[{"title":"我的账户","type":17,"icon":"http://s0.bbtree.com/public/myself/child_icon_bean.png?20170711","url":"","is_new":0,"is_web":0,"desc":"0","point":"cm_6"},{"title":"我的订单","type":2,"icon":"http://s0.bbtree.com/public/myself/c_my_order.png?20170711","url":"https://auction-static.bbtree.com/payweb/my-order.html?user_id=212385362&token=19f65ff9263d28829742680e24b8775b&username=13522225555&r=239","is_web":1,"is_new":0,"desc":"","point":"JZ_Wo_WoDeDingDan"},{"title":"我的保险","type":2,"icon":"http://s0.bbtree.com/public/myself/child_Insurance.png?20170711","url":"http://s0.bbtree.com/insurance/pages/index.html?user_id=212385362&child_id=210391841","is_new":0,"is_web":1,"desc":"","point":"cm_6"}],[{"title":"使用反馈","type":9,"icon":"http://s0.bbtree.com/public/myself/child_feedback.png?20170711","url":"","is_web":0,"is_new":0,"desc":"","point":"JZ_Wo_ShiYongFanKui"}]]
     * info : {"name":"youyou1234","avatar":"http://filesystem1.bbtree.com/2015/12/24/BEF08B4F0ED57069150DEFA140942E301450943792938608.jpg@200h_200w_1e_1c","call":"妈妈","score":98,"flower":267,"level":4,"begin_score":61,"next_score":120,"level_icon":{"sun":0,"moon":1,"star":0},"flower_rule":"http://s0.bbtree.com/5.0/redFlowerRule.html?userId=212385362&childId=210391841&r=1496","gold":0,"is_member":"1","nickname":"伤感的椰子","signature":"","child_avatar":"http://filesystem1.bbtree.com/2017/06/22/e015ff8c5f6e1cf0695a08121507a38c/And/1498119180183-1244746321.jpg"}
     */

    private InfoBean info;
    private List<List<ListBean>> list;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<List<ListBean>> getList() {
        return list;
    }

    public void setList(List<List<ListBean>> list) {
        this.list = list;
    }

    public static class InfoBean {
        /**
         * name : youyou1234
         * avatar : http://filesystem1.bbtree.com/2015/12/24/BEF08B4F0ED57069150DEFA140942E301450943792938608.jpg@200h_200w_1e_1c
         * call : 妈妈
         * score : 98
         * flower : 267
         * level : 4
         * begin_score : 61
         * next_score : 120
         * level_icon : {"sun":0,"moon":1,"star":0}
         * flower_rule : http://s0.bbtree.com/5.0/redFlowerRule.html?userId=212385362&childId=210391841&r=1496
         * gold : 0
         * is_member : 1
         * nickname : 伤感的椰子
         * signature :
         * child_avatar : http://filesystem1.bbtree.com/2017/06/22/e015ff8c5f6e1cf0695a08121507a38c/And/1498119180183-1244746321.jpg
         */

        private String name;
        private String avatar;
        private String call;
        private int score;
        private int flower;
        private int level;
        private int begin_score;
        private int next_score;
        private LevelIconBean level_icon;
        private String flower_rule;
        private int gold;
        private String is_member;
        private String nickname;
        private String signature;
        private String child_avatar;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getCall() {
            return call;
        }

        public void setCall(String call) {
            this.call = call;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getFlower() {
            return flower;
        }

        public void setFlower(int flower) {
            this.flower = flower;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getBegin_score() {
            return begin_score;
        }

        public void setBegin_score(int begin_score) {
            this.begin_score = begin_score;
        }

        public int getNext_score() {
            return next_score;
        }

        public void setNext_score(int next_score) {
            this.next_score = next_score;
        }

        public LevelIconBean getLevel_icon() {
            return level_icon;
        }

        public void setLevel_icon(LevelIconBean level_icon) {
            this.level_icon = level_icon;
        }

        public String getFlower_rule() {
            return flower_rule;
        }

        public void setFlower_rule(String flower_rule) {
            this.flower_rule = flower_rule;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public String getIs_member() {
            return is_member;
        }

        public void setIs_member(String is_member) {
            this.is_member = is_member;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getChild_avatar() {
            return child_avatar;
        }

        public void setChild_avatar(String child_avatar) {
            this.child_avatar = child_avatar;
        }

        public static class LevelIconBean {
            /**
             * sun : 0
             * moon : 1
             * star : 0
             */

            private int sun;
            private int moon;
            private int star;

            public int getSun() {
                return sun;
            }

            public void setSun(int sun) {
                this.sun = sun;
            }

            public int getMoon() {
                return moon;
            }

            public void setMoon(int moon) {
                this.moon = moon;
            }

            public int getStar() {
                return star;
            }

            public void setStar(int star) {
                this.star = star;
            }
        }
    }

    public static class ListBean {
        /**
         * title : 邀请家人
         * type : 8
         * icon : http://s0.bbtree.com/public/myself/child_invitation.png?20170711
         * url :
         * is_web : 0
         * is_new : 0
         * desc :
         * point : JZ_Wo_YaoQingJiaRen
         */

        private String title;
        private int type;
        private String icon;
        private String url;
        private int is_web;
        private int is_new; //红点
        private String desc;
        private String point;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getIs_web() {
            return is_web;
        }

        public void setIs_web(int is_web) {
            this.is_web = is_web;
        }

        public int getIs_new() {
            return is_new;
        }

        public void setIs_new(int is_new) {
            this.is_new = is_new;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }
    }
}
