package com.app.koreq.commlib.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.app.koreq.commlib.R;
import com.app.koreq.commlib.utils.DebugLog;
import com.app.koreq.commlib.utils.DensityUtils;

/**
 * project : CommListView
 * author : YanBin on 7/2/17
 * version : v
 * description : 可折叠的按钮，展开后包含多个按钮
 */
public class FoldButton extends FrameLayout implements View.OnClickListener,
        ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

    public static final int MODE_MENU = 0;
    public static final int MODE_BUTTON = 1;
    private Context mCtx;
    private LinearLayout scrollLinearLayout;
    private HorizontalScrollView scrollView;
    private LinearLayout linearLayout;
    private OnClickListener mOnClickListener;
    private int mMode;
    private ValueAnimator mAnimator;
    private View parent;
    private int minWidth = -1;
    private int maxWidth = -1;
    private int height = -1;
    private boolean isOpened = false;
    private boolean hasSettedMode = false;
    private RelativeLayout imageLayout;
    private LayoutParams buttonLayourParams;
    private int mOpenedImage;
    private int mClosedImage;
    private int marginLeft = 0;
    private OnClickListener listener;
    private ImageView imageView;
    private LayoutParams maskViewParams;
    private ImageView mask;

    private ClickInnerListener mListener;

    public interface ClickInnerListener {
        void clickInnerButton();
    }

    public FoldButton(Context context) {
        this(context, null);
    }

    public FoldButton(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public FoldButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mCtx = context;
        initView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FoldButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mCtx = context;
        initView();
    }

    /**
     * 初始化视图
     */
    private void initView() {

        RelativeLayout scrollContainer = (RelativeLayout) LayoutInflater.from(mCtx).inflate(R.layout.fold_button_container, null);
        linearLayout = new LinearLayout(mCtx);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
//        linearLayout.setPadding(0,0, DensityUtils.dip2px(mCtx,27),0);
        ViewGroup.LayoutParams linearParams =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        scrollView = (HorizontalScrollView) scrollContainer.findViewById(R.id.fabutton_scroll);
        scrollView.setHorizontalScrollBarEnabled(false);
        LinearLayout.LayoutParams scrollViewParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER_VERTICAL);
        scrollView.addView(linearLayout, linearParams);
        scrollViewParams.leftMargin = DensityUtils.dip2px(mCtx, 7);
        scrollView.setAlpha(0);

        ImageView settingView = new ImageView(mCtx);
        settingView.setImageResource(R.drawable.fold_button_setting);
        settingView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.clickInnerButton();
                }
            }
        });

        scrollLinearLayout = new LinearLayout(mCtx);
        scrollLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        scrollLinearLayout.setGravity(Gravity.CENTER_VERTICAL);
        FrameLayout.LayoutParams scrollLinearParams =
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER_VERTICAL);
        scrollLinearParams.rightMargin = DensityUtils.dip2px(mCtx, 33);

        scrollLinearLayout.addView(scrollContainer, scrollViewParams);
        scrollLinearLayout.addView(settingView);
        this.addView(scrollLinearLayout, scrollLinearParams);

        mask = new ImageView(mCtx);
        mask.setImageResource(R.drawable.fold_button_mask);
        mask.setScaleType(ImageView.ScaleType.FIT_XY);
        maskViewParams = new LayoutParams(DensityUtils.dip2px(mCtx, 40), DensityUtils.dip2px(mCtx, 20), Gravity.CENTER_VERTICAL | Gravity.END);
//        maskViewParams.rightMargin =  DensityUtils.dip2px(mCtx,3);
        maskViewParams.rightMargin = 3;
        this.addView(mask, maskViewParams);

        imageView = new ImageView(mCtx);
        LayoutParams imageLayoutParams = new LayoutParams(DensityUtils.dip2px(mCtx, 15), DensityUtils.dip2px(mCtx, 15));
        imageLayoutParams.gravity = Gravity.CENTER;
        imageLayout = new RelativeLayout(mCtx);
        imageLayout.setGravity(Gravity.CENTER);
        imageLayout.addView(imageView, imageLayoutParams);
        buttonLayourParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, Gravity.END);
        buttonLayourParams.rightMargin = 1;
        this.addView(imageLayout, buttonLayourParams);

        imageLayout.setOnClickListener(this);
        setMode(MODE_BUTTON);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        parent = (View) getParent();
        height = getHeight();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * @param view       要添加的view
     * @param isLastView 是否是最后一个view
     */
    public void addInnerButton(View view, boolean isLastView) {
        if (mMode == MODE_BUTTON) {
            throw new IllegalStateException("button state cannot add inner view");
        }
        linearLayout.addView(view);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
        params.gravity = Gravity.CENTER_VERTICAL;
        params.rightMargin = DensityUtils.dip2px(mCtx, 4);
        params.height = DensityUtils.dip2px(mCtx, 25);
        if (isLastView) {
            params.rightMargin = DensityUtils.dip2px(mCtx, 8);
        }
        params.leftMargin = DensityUtils.dip2px(mCtx, 4);
        requestLayout();
    }

    public void removeAllInnerView() {
        linearLayout.removeAllViews();
    }

    public void setMode(int mode) {
        this.mMode = mode;
        if (isOpened) {
            try {
                mAnimator.cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
            isOpened = false;
            onAnimationStart(null);
            open(minWidth);
            scrollView.setAlpha(0);
            onAnimationEnd(null);
        }
        if (mode == MODE_BUTTON) {
            scrollView.setVisibility(GONE);
            imageLayout.setVisibility(GONE);
            mask.setVisibility(GONE);
            setClickable(true);
            removeAllInnerView();
        } else {
            setClickable(false);
            setFocusable(false);
            scrollView.setVisibility(VISIBLE);
            imageLayout.setVisibility(VISIBLE);
            removeAllInnerView();
        }
    }

    public void setOpenAndCloseImage(int open, int close) {
        this.mClosedImage = close;
        this.mOpenedImage = open;
    }

    public void setMaxWidth(int max) {
        this.maxWidth = max;
//        DebugLog.log("FoldButton", "maxWidth = " + max);
    }

    @Override
    public void onClick(View v) {
        if (minWidth == -1) {
            minWidth = getMeasuredWidth();
        }
        if (maxWidth == -1) {
            maxWidth = parent.getMeasuredWidth() - minWidth;
        }
        if (maxWidth < minWidth)
            maxWidth = minWidth;
        if (!isOpened) {
            isOpened = true;
            playAnimation(minWidth, maxWidth);
        } else {
            isOpened = false;
            playAnimation(maxWidth, minWidth);
        }
        if (mMode == MODE_MENU) {
            if (!mAnimator.isRunning()) {
                mAnimator.start();
            }
        }
    }

    private void playAnimation(int min, int max) {
        mAnimator = ValueAnimator.ofInt(min, max);
        mAnimator.setDuration(150);
        mAnimator.addListener(this);
        mAnimator.addUpdateListener(this);
    }

    public boolean isOpened() {
        return isOpened;
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
//        getAnimatedValue()的值是一系列数字  在ValueAnimator.ofInt(min, max)的min和max之间！！！
        int abs = (int) animation.getAnimatedValue();
        open(abs);
//        animation.getAnimatedFraction() 动画执行的进度 范围： 0.0 ~ 1.0  ！！！！！
        if (isOpened) {
            scrollView.setAlpha(animation.getAnimatedFraction());
        } else {
            scrollView.setAlpha(1 - animation.getAnimatedFraction());
        }
//        DebugLog.log("FoldButton", "Fraction = " + animation.getAnimatedFraction());
    }

    private void open(int interpolation) {
//        DebugLog.log("FoldButton", "interpolation = " + interpolation);
        ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
        layoutParams.width = interpolation;
        requestLayout();
    }

    @Override
    public void onAnimationStart(Animator animation) {
        this.removeView(imageLayout);
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        onAnimationCancel(animation);
    }

    @Override
    public void onAnimationCancel(Animator animation) {
        buttonLayourParams.width = minWidth;
        try {
            setButtonState();
            this.addView(imageLayout, buttonLayourParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

//    public int  DensityUtils.dip2px(mCtx,float dpValue) {
//        final float scale = mCtx.getResources().getDisplayMetrics().density;
//        return (int) (dpValue * scale + 0.5f);
//    }

    public void setButtonState() {
        if (mMode == MODE_BUTTON) {
            return;
        }
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        if (isOpened) {
            //处于打开状态
            mask.setVisibility(GONE);
//            maskViewParams.width = maxWidth/3;
//            mask.requestLayout();
            if (mOpenedImage != 0) {
                imageView.setBackgroundResource(mOpenedImage);
            } else {
                imageView.setBackgroundDrawable(new ColorDrawable(Color.YELLOW));
            }
        } else {
            mask.setVisibility(GONE);
            //处于关闭状态
            if (mClosedImage != 0) {
                imageView.setBackgroundResource(mClosedImage);
            } else {
                imageView.setBackgroundDrawable(new ColorDrawable(Color.GREEN));
            }
        }
    }

    public void setOptionsListener(ClickInnerListener listener) {
        mListener = listener;
    }
}
