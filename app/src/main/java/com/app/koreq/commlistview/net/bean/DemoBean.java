package com.app.koreq.commlistview.net.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * project : CommListView
 * author : YanBin on 3/27/17
 * version : v
 * description :  来自链接 ： http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%87%91%E5%88%9A%E7%8B%BC&bk_length=600
 */
public class DemoBean {

    /**
     * id : 275163
     * subLemmaId : 11120672
     * newLemmaId : 83444
     * key : 金刚狼
     * desc : 美国漫威漫画旗下超级英雄
     * title : 金刚狼
     * card : []
     * image : http://b.hiphotos.baidu.com/baike/pic/item/503d269759ee3d6d2c9b00554a166d224e4adecb.jpg
     * src : 503d269759ee3d6d2c9b00554a166d224e4adecb
     * imageHeight : 868
     * imageWidth : 564
     * isSummaryPic : y
     * abstract : 金刚狼（Wolverine）是美国漫威漫画旗下超级英雄，初次登场于《不可思议的绿巨人》第180期（1974年10月）。本名詹姆斯·“罗根”·豪利特（James “Logan” Howlett），1832年出生于加拿大的阿尔伯塔省，自从小时候发现自己的生父杀死自己的养父后，罗根的变种人能力便开始显现出来，他拥有延缓衰老和极强的自愈能力，双手还可以伸出骨爪。后来被威廉·史崔克抓走并对其实施X武器计划、骨骼被注入艾德曼合金，手上的骨爪也变成了无坚不摧的金刚爪。这使得罗根正式成为金刚狼（Wolverine），并加入了复仇者联盟和X战警。在2015年大事件中，金刚狼罗根被艾德曼合金灌满全身，窒息身亡。由X-23继承他的职位，成为全新金刚狼。在全新全异系列中漫威从《金刚狼_暮狼寻乡》宇宙中，将老年版罗根带回主宇宙，暮年罗根在搞清自己来到了不同的过去后，暂时与X战警共同活动。
     * moduleIds : [139731895,139731896]
     * url : http://baike.baidu.com/subview/275163/11120672.htm
     * wapUrl : http://wapbaike.baidu.com/item/%E9%87%91%E5%88%9A%E7%8B%BC/83444
     * hasOther : 1
     * totalUrl : http://baike.baidu.com/view/275163.htm
     * catalog : ["<a href='http://baike.baidu.com/subview/275163/11120672.htm#1'>人物设定<\/a>","<a href='http://baike.baidu.com/subview/275163/11120672.htm#2'>人物经历<\/a>","<a href='http://baike.baidu.com/subview/275163/11120672.htm#3'>关键词<\/a>","<a href='http://baike.baidu.com/subview/275163/11120672.htm#4'>漫画登场<\/a>"]
     * wapCatalog : ["<a href='http://wapbaike.baidu.com/item/%E9%87%91%E5%88%9A%E7%8B%BC/83444#1'>人物设定<\/a>","<a href='http://wapbaike.baidu.com/item/%E9%87%91%E5%88%9A%E7%8B%BC/83444#2'>人物经历<\/a>","<a href='http://wapbaike.baidu.com/item/%E9%87%91%E5%88%9A%E7%8B%BC/83444#3'>关键词<\/a>","<a href='http://wapbaike.baidu.com/item/%E9%87%91%E5%88%9A%E7%8B%BC/83444#4'>漫画登场<\/a>"]
     * logo : http://img.baidu.com/img/baike/logo-baike.gif
     * copyrights : 以上内容来自百度百科平台，由百度百科网友创作。
     * customImg :
     * redirect : []
     */

    private long id;
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
    private List<?> card;
    private List<Integer> moduleIds;
    private List<String> catalog;
    private List<String> wapCatalog;
    private List<?> redirect;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<?> getCard() {
        return card;
    }

    public void setCard(List<?> card) {
        this.card = card;
    }

    public List<Integer> getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(List<Integer> moduleIds) {
        this.moduleIds = moduleIds;
    }

    public List<String> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<String> catalog) {
        this.catalog = catalog;
    }

    public List<String> getWapCatalog() {
        return wapCatalog;
    }

    public void setWapCatalog(List<String> wapCatalog) {
        this.wapCatalog = wapCatalog;
    }

    public List<?> getRedirect() {
        return redirect;
    }

    public void setRedirect(List<?> redirect) {
        this.redirect = redirect;
    }
}
