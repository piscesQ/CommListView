package com.app.koreq.commlistview.utils;

import com.app.koreq.commlistview.MainApplication;
import com.app.koreq.commlistview.R;

/**
 * project : CommListView
 * author : YanBin on 4/19/17
 * version : v3.2
 * description : 全局变量配置
 */
public interface Config {
    int HOST_ENV = ResUtils.getResInt(R.integer.host_env);
    boolean IS_DEBUG = ResUtils.getResBool(R.bool.is_debug);
}
