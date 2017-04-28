package com.app.koreq.commlistview.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.app.koreq.commlistview.MainApplication;

/**
 * project : CommListView
 * author : YanBin on 4/20/17
 * version : v3.2
 * description :
 */
public class NetUtils {
    /**
     * 只关注是否联网
     */
    public static boolean isNetworkConnected() {
        Context context = MainApplication.getInstance();
        if (context != null) {
            ConnectivityManager mConnectivityManager =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }
}
