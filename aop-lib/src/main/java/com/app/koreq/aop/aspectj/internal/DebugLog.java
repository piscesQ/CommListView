package com.app.koreq.aop.aspectj.internal;

import android.util.Log;

/**
 * project : CommListView
 * author : YanBin on 5/17/17
 * version : v
 * description :
 */
public class DebugLog {

    /**
     * Send a debug log message
     *
     * @param tag Source of a log message.
     * @param message The message you would like logged.
     */
    public static void log(String tag, String message) {
        Log.d(tag, message);
    }
}