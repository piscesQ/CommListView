package com.app.koreq.commlistview.net.frame.bean;

import com.app.koreq.commlistview.net.bean.TreeResult;
import com.app.koreq.commlistview.utils.GsonUtils;
import com.app.koreq.commlistview.utils.JSONUtils;
import com.app.koreq.netlib.bean.BaseRequest;
import com.app.koreq.netlib.http.HttpConstants;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * project : CommListView
 * author : YanBin on 4/28/17
 * version : v
 * description : Demo - 测试post请求
 */
public class TreePostRequest extends BaseRequest<TreeResult> {
    private String url;
    private Params mChildParams;

    public TreePostRequest() {
        mChildParams = new Params();
        setRequestType(HttpConstants.TYPE_POST);
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Type getResponseType() {
        return TreeResult.class;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setParams(String data) {
//        mChildParams.setData(data);

        String strParams = GsonUtils.getGson().toJson(mChildParams, Params.class);
        //TODO kore test
        strParams = "{\"andid\":\"b80c1f46c3893a47\",\"banner_ratio_type\":\"1440x518\",\"brand\":\"google\",\"class_id\":202449672,\"connt\":\"WIFI\",\"count\":20,\"density\":\"3.5\",\"device\":\"Nexus 6P\",\"hwd\":\"google/angler/angler:7.0/NBD91K/3318877:user/release-keys\",\"imei\":\"86798102177694\",\"ip\":\"10.0.9.157\",\"is_public\":0,\"is_show\":1,\"mac\":\"02:00:00:00:00:00\",\"make\":\"Huawei\",\"myuser_id\":0,\"native_ratio_type\":\"1118x402\",\"os\":\"Android\",\"page\":1,\"school_id\":202032240,\"screenSize\":\"1440x2392\",\"type\":2,\"ua\":\"Mozilla/5.0 (Linux; Android 7.0; Nexus 6P Build/NBD91K; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/51.0.2704.90 Mobile Safari/537.36\",\"uid\":\"b80c1f46c3893a47\",\"user_id\":212616083,\"child_id\":210565601,\"curr\":{\"child_id\":210565601,\"class_id\":202449672,\"school_id\":202032240,\"user_id\":212616083},\"data_ver\":35,\"device_no\":\"Nexus 6P\",\"mobile_system\":\"7.0\",\"platform\":2,\"school_app_type\":0,\"version_code\":120,\"version_no\":\"P_PRE_6.1.0\"}";

        setBaseParams(strParams); //传入父类
    }

    class Params extends BaseRequest.Params {
        /**
         * andid : b80c1f46c3893a47
         * banner_ratio_type : 1440x518
         * brand : google
         * class_id : 202449672
         * connt : WIFI
         * count : 20
         * density : 3.5
         * device : Nexus 6P
         * hwd : google/angler/angler:7.0/NBD91K/3318877:user/release-keys
         * imei : 86798102177694
         * ip : 10.0.9.157
         * is_public : 0
         * is_show : 1
         * mac : 02:00:00:00:00:00
         * make : Huawei
         * myuser_id : 0
         * native_ratio_type : 1118x402
         * os : Android
         * page : 1
         * school_id : 202032240
         * screenSize : 1440x2392
         * type : 2
         * ua : Mozilla/5.0 (Linux; Android 7.0; Nexus 6P Build/NBD91K; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/51.0.2704.90 Mobile Safari/537.36
         * uid : b80c1f46c3893a47
         * user_id : 212616083
         * child_id : 210565601
         * curr : {"child_id":210565601,"class_id":202449672,"school_id":202032240,"user_id":212616083}
         * data_ver : 35
         * device_no : Nexus 6P
         * mobile_system : 7.0
         * platform : 2
         * school_app_type : 0
         * version_code : 120
         * version_no : P_PRE_6.1.0
         */

        private String andid;
        private String banner_ratio_type;
        private String brand;
        private int class_id;
        private String connt;
        private int count;
        private String density;
        private String device;
        private String hwd;
        private String imei;
        private String ip;
        private int is_public;
        private int is_show;
        private String mac;
        private String make;
        private int myuser_id;
        private String native_ratio_type;
        private String os;
        private int page;
        private int school_id;
        private String screenSize;
        private int type;
        private String ua;
        private String uid;
        private int user_id;
        private int child_id;
        private CurrBean curr;
        private int data_ver;
        private String device_no;
        private String mobile_system;
        private int platform;
        private int school_app_type;
        private int version_code;
        private String version_no;


        public String getAndid() {
            return andid;
        }

        public void setAndid(String andid) {
            this.andid = andid;
        }

        public String getBanner_ratio_type() {
            return banner_ratio_type;
        }

        public void setBanner_ratio_type(String banner_ratio_type) {
            this.banner_ratio_type = banner_ratio_type;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }

        public String getConnt() {
            return connt;
        }

        public void setConnt(String connt) {
            this.connt = connt;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getDensity() {
            return density;
        }

        public void setDensity(String density) {
            this.density = density;
        }

        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }

        public String getHwd() {
            return hwd;
        }

        public void setHwd(String hwd) {
            this.hwd = hwd;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public int getIs_public() {
            return is_public;
        }

        public void setIs_public(int is_public) {
            this.is_public = is_public;
        }

        public int getIs_show() {
            return is_show;
        }

        public void setIs_show(int is_show) {
            this.is_show = is_show;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public int getMyuser_id() {
            return myuser_id;
        }

        public void setMyuser_id(int myuser_id) {
            this.myuser_id = myuser_id;
        }

        public String getNative_ratio_type() {
            return native_ratio_type;
        }

        public void setNative_ratio_type(String native_ratio_type) {
            this.native_ratio_type = native_ratio_type;
        }

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getSchool_id() {
            return school_id;
        }

        public void setSchool_id(int school_id) {
            this.school_id = school_id;
        }

        public String getScreenSize() {
            return screenSize;
        }

        public void setScreenSize(String screenSize) {
            this.screenSize = screenSize;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUa() {
            return ua;
        }

        public void setUa(String ua) {
            this.ua = ua;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getChild_id() {
            return child_id;
        }

        public void setChild_id(int child_id) {
            this.child_id = child_id;
        }

        public CurrBean getCurr() {
            return curr;
        }

        public void setCurr(CurrBean curr) {
            this.curr = curr;
        }

        public int getData_ver() {
            return data_ver;
        }

        public void setData_ver(int data_ver) {
            this.data_ver = data_ver;
        }

        public String getDevice_no() {
            return device_no;
        }

        public void setDevice_no(String device_no) {
            this.device_no = device_no;
        }

        public String getMobile_system() {
            return mobile_system;
        }

        public void setMobile_system(String mobile_system) {
            this.mobile_system = mobile_system;
        }

        public int getPlatform() {
            return platform;
        }

        public void setPlatform(int platform) {
            this.platform = platform;
        }

        public int getSchool_app_type() {
            return school_app_type;
        }

        public void setSchool_app_type(int school_app_type) {
            this.school_app_type = school_app_type;
        }

        public int getVersion_code() {
            return version_code;
        }

        public void setVersion_code(int version_code) {
            this.version_code = version_code;
        }

        public String getVersion_no() {
            return version_no;
        }

        public void setVersion_no(String version_no) {
            this.version_no = version_no;
        }

        public class CurrBean {
            /**
             * child_id : 210565601
             * class_id : 202449672
             * school_id : 202032240
             * user_id : 212616083
             */

            private int child_id;
            private int class_id;
            private int school_id;
            private int user_id;

            public int getChild_id() {
                return child_id;
            }

            public void setChild_id(int child_id) {
                this.child_id = child_id;
            }

            public int getClass_id() {
                return class_id;
            }

            public void setClass_id(int class_id) {
                this.class_id = class_id;
            }

            public int getSchool_id() {
                return school_id;
            }

            public void setSchool_id(int school_id) {
                this.school_id = school_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }
        }
    }
}
