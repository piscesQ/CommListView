package com.app.koreq.commlistview.net;

import com.app.koreq.commlistview.utils.Config;

/**
 * project : CommListView
 * author : YanBin on 4/17/17
 * version : v3.2
 * description : Http configure
 */
public class HttpUtils {

    public static final int ENV_DEV = 0;
    public static final int ENV_BETA = 1;
    public static final int ENV_ONLINE = 99;

    /**
     * @param env 0: 开发； 1：测试； 99：线上
     * @return
     */
    public static String getHostByEnv(int env) {
        String host = "https://pro.zhihuishu.bbtree.com/service/v2/";    //TODO kore test
//        String host = "http://baike.baidu.com/";    //TODO kore test
        switch (env) {
            case ENV_DEV:
                //TODO get dev host
                break;
            case ENV_BETA:
                //TODO get beta host
                break;
            case ENV_ONLINE:
                //TODO get online hostr
                break;
            default:
                //TODO get default host
                break;
        }
        return host;
    }

    public static String getHostByEnv() {
        return getHostByEnv(Config.HOST_ENV);
    }
}
