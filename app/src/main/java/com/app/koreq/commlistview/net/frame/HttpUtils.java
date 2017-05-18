package com.app.koreq.commlistview.net.frame;

import com.app.koreq.commlib.utils.CommSharePreference;

/**
 * project : CommListView
 * author : YanBin on 4/17/17
 * version : v3.2
 * description : Http configure
 */
public class HttpUtils {

    //  预留出足够的编号   100 - 199: 开发； 200 - 299：测试； 999：线上
    public static final int ENV_DEV = 100;
    public static final int ENV_BETA = 200;
    public static final int ENV_ONLINE = 999;


    public static final String ENV_KEY = "sp_http_env"; //TODO kore test 存放的sp中的key
    public static final int ENV_DEV_BAIDU = 101;    //TODO kore test
    public static final int ENV_DEV_TR = 102;       //TODO kore test

    /**
     * @param env 0 - 99: 开发； 100 - 199：测试； 999：线上
     * @return
     */
    public static String getHostByEnv(int env) {
        String host = "";   //TODO Kore 需要指定默认url 或者在switch 中的 default指定
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


        //========================================================
        // TODO kore kore's dev env
        switch (env) {
            case ENV_DEV_BAIDU:
                host = "http://baike.baidu.com/";
                break;
            case ENV_DEV_TR:
                host = "https://pro.zhihuishu.bbtree.com/service/v2/";
                break;
            case ENV_ONLINE:
                break;
            default:
                break;
        }
        //========================================================


        return host;
    }

    public static String getHostByEnv() {
//        return getHostByEnv(Config.HOST_ENV);   //TODO kore online
        return getHostByEnv(CommSharePreference.getInstance().getValue(
                CommSharePreference.DEFAULT_USER,
                ENV_KEY, ENV_DEV_BAIDU));   //TODO kore test
    }
}
