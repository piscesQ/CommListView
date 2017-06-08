package com.app.koreq.commwidgetlib;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * project : CommListView
 * author : YanBin on 5/31/17
 * version : v4.0
 * description : Custom Toast Manager
 */
public class ToastManager {

    public static void showShortMessage(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showLongMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
