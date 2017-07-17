package com.app.koreq.commlistview.setting;

/**
 * project : CommListView
 * author : YanBin on 7/17/17
 * version : v5.0
 * description : 设置页面 bean
 */
public class SettingBean {

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
