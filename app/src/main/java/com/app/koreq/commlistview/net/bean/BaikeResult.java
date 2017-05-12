package com.app.koreq.commlistview.net.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * project : CommListView
 * author : YanBin on 5/3/17
 * version : v3.2
 * description :
 */
public class BaikeResult {

    /**
     * id : 275163
     * subLemmaId : 11120672
     * newLemmaId : 83444
     * key : 金刚狼
     * desc : 美国漫威漫画旗下超级英雄
     * title : 金刚狼
     * card : [{"key":"m62_nameC","name":"中文名","value":["詹姆斯·\u201c罗根\u201d·豪利特"],"format":["詹姆斯·\u201c罗根\u201d·豪利特"]},{"key":"m62_nameE","name":"外文名","value":["James \u201cLogan\u201d Howlett"],"format":["James \u201cLogan\u201d Howlett"]},{"key":"m62_nameOther","name":"别名","value":["Wolverine（金刚狼、狼獾、狼人）"],"format":["Wolverine（金刚狼、狼獾、狼人）"]},{"key":"m62_nation","name":"国籍"},{"key":"m62_ethnic","name":"民族"},{"key":"m62_height","name":"身高","value":["最高：6英尺3英寸（191cm） / 最矮：5英尺3英寸（160cm）"],"format":["最高：6英尺3英寸（191cm） / 最矮：5英尺3英寸（160cm）"]},{"key":"m62_weight","name":"体重"},{"key":"m62_bornPlace","name":"出生地"},{"key":"m62_bornDay","name":"出生日期","value":["1832年"],"format":["1832年"]},{"key":"m62_career","name":"职业","value":["一战/二战老兵、雇佣兵、特工、超级英雄"],"format":["一战/二战老兵、雇佣兵、特工、超级英雄"]},{"key":"m62_masterpiece","name":"代表作品"},{"key":"m62_master","name":"主要成就"},{"key":"m62_ext_0","name":"所属团队"},{"key":"m62_ext_2","name":"主要能力&nbsp;","value":["延缓衰老、极强的愈合能力"],"format":["延缓衰老、极强的愈合能力"]},{"key":"m62_ext_3","name":"&nbsp;&nbsp;","value":["无坚不摧的金刚爪、野兽感官"],"format":["无坚不摧的金刚爪、野兽感官"]}]
     * image : http://b.hiphotos.baidu.com/baike/pic/item/503d269759ee3d6d2c9b00554a166d224e4adecb.jpg
     * src : 503d269759ee3d6d2c9b00554a166d224e4adecb
     * imageHeight : 868
     * imageWidth : 564
     * isSummaryPic : y
     * abstract : 金刚狼（Wolverine）是美国漫威漫画旗下超级英雄，初次登场于《不可思议的绿巨人》第180期（1974年10月）。本名詹姆斯·“罗根”·豪利特（James “Logan” Howlett），1832年出生于加拿大的阿尔伯塔省，自从小时候发现自己的生父杀死自己的养父后，罗根的变种人能力便开始显现出来，他拥有延缓衰老和极强的自愈能力，双手还可以伸出骨爪。后来被威廉·史崔克抓走并对其实施X武器计划、骨骼被注入艾德曼合金，手上的骨爪也变成了无坚不摧的金刚爪。这使得罗根正式成为金刚狼（Wolverine），并加入了复仇者联盟和X战警。在2015年大事件中，金刚狼罗根被艾德曼合金灌满全身，窒息身亡。由X-23继承他的职位，成为全新金刚狼。在全新全异系列中漫威从《金刚狼_暮狼寻乡》宇宙中，将老年版罗根带回主宇宙，暮年罗根在搞清自己来到了不同的过去后，暂时与X战警共同活动。
     * moduleIds : [144338632,144338633,144338634]
     * url : http://baike.baidu.com/subview/275163/11120672.htm
     * wapUrl : http://wapbaike.baidu.com/item/%E9%87%91%E5%88%9A%E7%8B%BC/83444
     * hasOther : 1
     * totalUrl : http://baike.baidu.com/view/275163.htm
     * logo : http://img.baidu.com/img/baike/logo-baike.gif
     * copyrights : 以上内容来自百度百科平台，由百度百科网友创作。
     * customImg :
     * redirect : []
     */

    private int id;
    private int subLemmaId;
    private int newLemmaId;
    private String key;
    private String desc;
    private String title;
    private String image;
    private String src;
    private int imageHeight;
    private int imageWidth;
    private String isSummaryPic;
    @SerializedName("abstract")
    private String abstractX;
    private String url;
    private String wapUrl;
    private int hasOther;
    private String totalUrl;
    private String logo;
    private String copyrights;
    private String customImg;
    private List<CardBean> card;
    private List<Integer> moduleIds;
    private List<?> redirect;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubLemmaId() {
        return subLemmaId;
    }

    public void setSubLemmaId(int subLemmaId) {
        this.subLemmaId = subLemmaId;
    }

    public int getNewLemmaId() {
        return newLemmaId;
    }

    public void setNewLemmaId(int newLemmaId) {
        this.newLemmaId = newLemmaId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getIsSummaryPic() {
        return isSummaryPic;
    }

    public void setIsSummaryPic(String isSummaryPic) {
        this.isSummaryPic = isSummaryPic;
    }

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWapUrl() {
        return wapUrl;
    }

    public void setWapUrl(String wapUrl) {
        this.wapUrl = wapUrl;
    }

    public int getHasOther() {
        return hasOther;
    }

    public void setHasOther(int hasOther) {
        this.hasOther = hasOther;
    }

    public String getTotalUrl() {
        return totalUrl;
    }

    public void setTotalUrl(String totalUrl) {
        this.totalUrl = totalUrl;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    public String getCustomImg() {
        return customImg;
    }

    public void setCustomImg(String customImg) {
        this.customImg = customImg;
    }

    public List<CardBean> getCard() {
        return card;
    }

    public void setCard(List<CardBean> card) {
        this.card = card;
    }

    public List<Integer> getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(List<Integer> moduleIds) {
        this.moduleIds = moduleIds;
    }

    public List<?> getRedirect() {
        return redirect;
    }

    public void setRedirect(List<?> redirect) {
        this.redirect = redirect;
    }

    public static class CardBean {
        /**
         * key : m62_nameC
         * name : 中文名
         * value : ["詹姆斯·\u201c罗根\u201d·豪利特"]
         * format : ["詹姆斯·\u201c罗根\u201d·豪利特"]
         */

        private String key;
        private String name;
        private List<String> value;
        private List<String> format;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }

        public List<String> getFormat() {
            return format;
        }

        public void setFormat(List<String> format) {
            this.format = format;
        }
    }
}
