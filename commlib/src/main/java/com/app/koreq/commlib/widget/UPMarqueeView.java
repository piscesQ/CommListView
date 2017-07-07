package com.app.koreq.commlib.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.app.koreq.commlib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * project : CommListView
 * author : YanBin on 7/7/17
 * version : v5.0
 * description : 垂直轮播的View，类似淘宝头条
 */
public class UPMarqueeView extends ViewFlipper {

    private Context mContext;
    private boolean isSetAnimDuration = false;
    private int interval = 2000;    //默认2秒
    private int animDuration = 500;     // 动画时间

    public UPMarqueeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        this.mContext = context;
        Animation animIn = AnimationUtils.loadAnimation(mContext, R.anim.anim_marquee_in);
        if (isSetAnimDuration) animIn.setDuration(animDuration);
        setInAnimation(animIn);
        Animation animOut = AnimationUtils.loadAnimation(mContext, R.anim.anim_marquee_out);
        if (isSetAnimDuration) animOut.setDuration(animDuration);
        setOutAnimation(animOut);
    }

    /**
     * 如果循环的是textview，只需要传入对应的List即可
     */
    public void setTextViewData(List<String> list) {
        setTextViewData(list, 15, Color.BLACK);
    }

    /**
     *
     * @param list
     * @param textSize Unit : sp
     * @param textColor
     */
    public void setTextViewData(List<String> list, float textSize, int textColor) {
        List<View> textList = new ArrayList<>();
        for (String str : list) {
            TextView textView = new TextView(mContext);
            textView.setLines(1);
            textView.setTextSize(textSize);
            textView.setTextColor(textColor);
            textView.setText(str);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textList.add(textView);
        }
        setViews(textList);
    }


    /**
     * 设置循环滚动的View数组
     *
     * @param views
     */
    public void setViews(final List<View> views) {
        if (views == null || views.size() == 0) return;
        removeAllViews();
        for (int i = 0; i < views.size(); i++) {
            final int position = i;
            //设置监听回调
            views.get(i).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(position, views.get(position));
                    }
                }
            });
            ViewGroup viewGroup = (ViewGroup) views.get(i).getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            addView(views.get(i));
        }
        setFlipInterval(interval);
        startFlipping();
    }

    /**
     * 点击
     */
    private OnItemClickListener onItemClickListener;

    /**
     * 设置监听接口
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * item_view的接口
     */
    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }

    public int getInterval() {
        return interval;
    }

    /**
     * 设置轮播时间
     *
     * @param interval Unit ：ms
     */
    public void setInterval(int interval) {
        this.interval = interval;
    }
}
