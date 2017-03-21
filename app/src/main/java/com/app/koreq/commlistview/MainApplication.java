package com.app.koreq.commlistview;

import android.app.Application;
import android.util.Log;

/**
 * project : CommListView
 * author : YanBin on 3/19/17
 * version : v1.0
 * description :
 */
public class MainApplication extends Application {

    public static final String TAG = MainApplication.class.getSimpleName();
    public static MainApplication instance;

    public synchronized static MainApplication getInstance(){
        if (instance == null){
            instance = new MainApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "MainApplication -- onCreate");
        super.onCreate();
    }
}
