package com.app.koreq.commlib.utils;

/**
 * project : CommListView
 * author : YanBin on 7/12/17
 * version : v4.0
 * description : 多条件观察者 同时完成N件事(当Flag == 0 时)，才会触发回调
 */
public class MultiConditionKVO {
    public interface MultiConditionCallback {
        void doCallback();
    }

    private int mFlag;
    private MultiConditionCallback mCallback;

    public MultiConditionKVO(int conditionNum, MultiConditionCallback callback) {
        mFlag = conditionNum;
        mCallback = callback;
    }

    public void reset(int value) {
        mFlag = value;
    }

    public void reset(MultiConditionCallback callback) {
        mCallback = callback;
    }

    public int getFlag() {
        return mFlag;
    }

    public void doDone() {
        if (mFlag <= 0) return;
        if (mFlag > 0) {
            mFlag--;
        }
        if (mFlag == 0) {
            mCallback.doCallback();
        }
    }

    public boolean isDone() {
        return mFlag == 0;
    }
}
