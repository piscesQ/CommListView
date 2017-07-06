package com.app.koreq.commlib.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description:手机系統相关的操作类，如网络、手机号、硬件号等
 */
public class PhoneUtils {
    public static final String KEY_UNIQUE_ID = "DeviceId";
    public static final String NAME_DEVICE_INFO = "DeviceInfo";

    /**
     * Description:根据设备ID，ShortID，AndroidId，Mac Address组合取MD5得到设备唯一标识
     *
     * @param context 上下文
     * @return String
     */
    public static String deviceUniqueId(Context context) {
        String uniqueId = getDeviceIdFromSP(context);
        if (uniqueId != null && uniqueId.length() > 0) {
            return uniqueId;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = telephonyManager.getDeviceId();

        String shortId = "35" + Build.BOARD.length() % 10
                + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10
                + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10
                + Build.HOST.length() % 10 + Build.ID.length() % 10
                + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10
                + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10
                + Build.TYPE.length() % 10 + Build.USER.length() % 10; // 13
        // digits

        String androidId = Secure.getString(context.getContentResolver(),
                Secure.ANDROID_ID);

        WifiManager wm = (WifiManager) context
                .getSystemService(Context.WIFI_SERVICE);
        String macAdress = "";
        if (wm.getConnectionInfo() != null) {
            macAdress = wm.getConnectionInfo().getMacAddress();
        }

        String longId = deviceId + shortId + androidId + macAdress;
        // compute md5
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.update(longId.getBytes(), 0, longId.length());
        byte p_md5Data[] = m.digest();
        String uniqueID = "";
        for (int i = 0; i < p_md5Data.length; i++) {
            int b = (0xFF & p_md5Data[i]);
            if (b <= 0xF)
                uniqueID += "0";
            uniqueID += Integer.toHexString(b);
        }
        uniqueID = uniqueID.toUpperCase();

        uniqueId = uniqueID;
        setDeviceIdFromSP(context, uniqueId);
        return uniqueId;
    }

    /**
     * Description:判断sd卡是可用
     *
     * @return boolean
     */
    public static boolean getSDCardStatus() {
        String state = android.os.Environment.getExternalStorageState();
        if (android.os.Environment.MEDIA_MOUNTED.equals(state)) {
            if (android.os.Environment.getExternalStorageDirectory().canWrite()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Description:Mac Address
     *
     * @param context 上下文
     * @return String
     */
    public static String getMacAddress(Context context) {
        String macAddress = "";
        WifiManager wifi = (WifiManager) context
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = null;
        if (wifi != null) {
            info = wifi.getConnectionInfo();
        } else {
            return "";
        }
        if (info != null) {
            macAddress = info.getMacAddress();
        } else {
            return "";
        }
        return macAddress;
    }

    /**
     * Description:得到设备ID(IMEI)或Android_ID
     *
     * @param context 上下文
     * @return String
     */
    public static String getDeviceId(Context context) {
        String deviceId = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        if (deviceId == null)
            deviceId = Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
        return deviceId;
    }

    /**
     * Description 系统sdk版本
     *
     * @return int
     */
    public static int getSdkVersion() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * Description 手机型号
     *
     * @return String
     */
    public static String getPhoheModel() {
        return android.os.Build.MODEL;
    }

    /**
     * Description 手机厂家
     *
     * @return String
     */
    public static String getPhoneBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * Description 得到屏幕尺寸大小
     *
     * @param context 上下文
     * @return double
     */
    public static double getDeviceSize(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
        double x = Math.pow(dm.widthPixels / dm.xdpi, 2);
        double y = Math.pow(dm.heightPixels / dm.ydpi, 2);
        return Math.sqrt(x + y);
    }

    /**
     * Description 判断设备是手机、平板，<br>
     * 返回Android Phone 小于6寸，Android mini Pad 6-9寸,Android pad 大于9寸
     * Title:getDeviceType
     *
     * @param context 上下文
     * @return String
     */
    public static String getDeviceType(Context context) {
        double screenInches = getDeviceSize(context);
        if (screenInches >= 6.0) {
            return "Android mini Pad";
        } else if (screenInches >= 9.0) {
            return "Android Pad";
        } else {
            return "Android Phone";
        }
    }

    /**
     * Description 获取系统信息 格式<br>
     * SimSerialNumber|DEVICE|DISPLAY|SERIAL|SDK|SDK_INT|CODENAME|
     * CPU_ABI|CPU_ABI2|MANUFACTURER|MODEL|VERSION.RELEASE
     *
     * @param context 上下文
     * @return String
     */
    @SuppressLint("NewApi")
    public static String getSystemInfo(Context context) {
        StringBuilder sb = new StringBuilder();
        // SimSerialNumber|DEVICE|DISPLAY|SERIAL|SDK|SDK_INT|CODENAME|CPU_ABI|CPU_ABI2|MANUFACTURER|MODEL|VERSION.RELEASE
        sb.append(getSimSerial(context)).append("|");
        sb.append(android.os.Build.DEVICE).append("|");
        sb.append(android.os.Build.DISPLAY).append("|");
        sb.append(android.os.Build.SERIAL).append("|");
        sb.append(android.os.Build.VERSION.SDK).append("|");
        sb.append(android.os.Build.VERSION.SDK_INT).append("|");
        sb.append(android.os.Build.VERSION.CODENAME).append("|");
        sb.append(android.os.Build.CPU_ABI).append("|");
        sb.append(android.os.Build.CPU_ABI2).append("|");
        sb.append(android.os.Build.MANUFACTURER).append("|");
        sb.append(android.os.Build.MODEL).append("|");
        sb.append(android.os.Build.VERSION.RELEASE).append("|");
        sb.append(getScreenInfo(context));
        return sb.toString();
    }

    public static String getCpuInfo() {
        return android.os.Build.CPU_ABI + "|" + android.os.Build.CPU_ABI2;
    }

    /**
     * Description 获取手机卡的序列号(IMSI) 需要权限 READ_PHONE_STATE
     *
     * @param context 上下文
     * @return String
     */
    public static String getSimSerial(Context context) {
        String deviceId = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE))
                .getSimSerialNumber();
        return deviceId;
    }

    /**
     * Description 得到屏幕信息 <格式>width:height:dpi:desity
     *
     * @param context 上下文
     * @return String
     */
    public static String getScreenInfo(Context context) {
        StringBuilder sb = new StringBuilder();
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        sb.append(metrics.widthPixels).append(":");
        sb.append(metrics.heightPixels).append(":");
        sb.append(metrics.densityDpi).append(":");
        sb.append(metrics.density);
        return sb.toString();
    }

    /**
     * Description:获取程序版本号
     *
     * @param context 上下文
     * @return String
     * throws
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            return pi.versionName;
        } catch (Exception e) {
            Log.e("log", "[getVersionName]", e);
        }
        return null;
    }


    /**
     * 获取网络运营商代码
     *
     * @param context
     * @return
     */
    public static String getNetWorkOperator(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            return tm.getNetworkOperator();
        }
        return "";
    }

    /**
     * 获取设备唯一标示
     *
     * @param context 上下文
     * @return
     */
    public static String getDeviceIdFromSP(Context context) {
        return context.getSharedPreferences(NAME_DEVICE_INFO, Context.MODE_PRIVATE).getString(KEY_UNIQUE_ID, null);
    }

    /**
     * 存储设备唯一标识
     *
     * @param context  上下文
     * @param uniqueId
     */
    public static void setDeviceIdFromSP(Context context, String uniqueId) {
        SharedPreferences share = context.getSharedPreferences(NAME_DEVICE_INFO, Context.MODE_PRIVATE);
        share.edit().putString(KEY_UNIQUE_ID, uniqueId).apply();
        share = null;
    }
}
