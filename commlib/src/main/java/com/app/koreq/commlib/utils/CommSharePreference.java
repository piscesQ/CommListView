package com.app.koreq.commlib.utils;

import android.content.Context;
import android.content.SharedPreferences;

import commlistview.MainApplication;

/**
 * project : CommListView
 * author : YanBin on 5/19/17
 * version : v4.0
 * description : 根据userId来区分，每个用户存一个文件
 */
public class CommSharePreference {
    public static final int DEFAULT_USER = 0;

    private static final String KEY_SUFFIX = "SP_";     //文件名前缀
    private static CommSharePreference mInstance;
    private SharedPreferences mPreferences;

    public static CommSharePreference getInstance() {
        if (mInstance == null) {
            mInstance = new CommSharePreference();
        }
        return mInstance;
    }

    /**
     * @param id userId 用于区分用户存储数据
     * @return
     */
    private SharedPreferences instance(long id) {
        mPreferences = MainApplication.getInstance().getSharedPreferences(KEY_SUFFIX + id, Context.MODE_PRIVATE);
        return mPreferences;
    }

    public void putValue(long id, String key, String value) {
        SharedPreferences prefer = instance(id);
        SharedPreferences.Editor edit = prefer.edit();
        edit.putString(key, value);
        edit.apply();
    }

    public void putValue(long id, String key, int value) {
        SharedPreferences prefer = instance(id);
        SharedPreferences.Editor edit = prefer.edit();
        edit.putInt(key, value);
        edit.apply();
    }

    public void putValue(long id, String key, long value) {
        SharedPreferences prefer = instance(id);
        SharedPreferences.Editor edit = prefer.edit();
        edit.putLong(key, value);
        edit.apply();
    }

    public void putValue(long id, String key, boolean value) {
        SharedPreferences prefer = instance(id);
        SharedPreferences.Editor edit = prefer.edit();
        edit.putBoolean(key, value);
        edit.apply();
    }

    public void putValue(long id, String key, float value) {
        SharedPreferences prefer = instance(id);
        SharedPreferences.Editor edit = prefer.edit();
        edit.putFloat(key, value);
        edit.apply();
    }

    public boolean getValue(long id, String key, boolean def) {
        SharedPreferences prefer = instance(id);
        return prefer.getBoolean(key, def);
    }

    public String getValue(long id, String key, String def) {
        SharedPreferences prefer = instance(id);
        return prefer.getString(key, def);
    }

    public int getValue(long id, String key, int def) {
        SharedPreferences prefer = instance(id);
        return prefer.getInt(key, def);
    }

    public long getValue(long id, String key, long def) {
        SharedPreferences prefer = instance(id);
        return prefer.getLong(key, def);
    }

    public float getValue(long id, String key, float def) {
        SharedPreferences prefer = instance(id);
        return prefer.getFloat(key, def);
    }
}
