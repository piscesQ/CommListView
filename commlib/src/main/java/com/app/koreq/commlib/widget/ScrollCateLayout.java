package com.app.koreq.commlib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.app.koreq.commlib.R;
import com.app.koreq.commlib.bean.ScrollCateBean;
import com.app.koreq.commlib.utils.DensityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * author : YanBin on 7/3/17
 * since : v
 * description : 水平滚动的分类标签
 */
public class ScrollCateLayout extends FrameLayout implements View.OnClickListener {

    private Context mContext;
    private View mView;
    private List<ScrollCateBean> mList;
    private List<RadioButton> mRadioButtons;

    private LinearLayout mLinearLayout; //容器
    private ClickValueCateListener mClickListener;
    private HorizontalScrollView mScrollView;

    public interface ClickValueCateListener {
        void clickValueCateItem(ScrollCateBean bean, int position);
    }

    public ScrollCateLayout(Context context) {
        super(context);
        init();
    }

    public ScrollCateLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScrollCateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (mContext == null) mContext = getContext();
        mView = View.inflate(mContext, R.layout.scroll_cate_container, this);
        mScrollView = (HorizontalScrollView) mView.findViewById(R.id.scroll_view);
        mLinearLayout = (LinearLayout) mView.findViewById(R.id.scroll_container);

        mRadioButtons = new ArrayList<>();
    }

    public void fillData(List<ScrollCateBean> list) {
        clearInnerViews();
        if (list == null || list.size() == 0) return;
        mRadioButtons.clear();
        this.mList = list;
        for (int i = 0; i < list.size(); i++) {
            ScrollCateBean bean = list.get(i);
            getView(bean, i);
        }
    }

    public void clearInnerViews() {
        mLinearLayout.removeAllViews();
    }

    private void getView(final ScrollCateBean bean, final int position) {
        View view = View.inflate(mContext, R.layout.item_scroll_cate, null);
        final RadioButton radioButton = (RadioButton) view.findViewById(R.id.live_scroll_item);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.leftMargin = DensityUtils.dip2px(getContext(), 7);
        params.rightMargin = DensityUtils.dip2px(getContext(), 7);
        radioButton.setLayoutParams(params);
        String category = bean.getName();
//        if (category != null && category.length() > 4) {
//            category = category.substring(0, 4);
//        }
        if (position == 0) {
            radioButton.setChecked(true);
        }
        radioButton.setText(category);
        mRadioButtons.add(radioButton);
        mLinearLayout.addView(radioButton);
//        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                buttonView.setChecked(true);
//                for(RadioButton rb : mRadioButtons){
//                    if(rb != buttonView){
//                        rb.setChecked(false);
//                    }
//                }
//            }
//        });
        radioButton.setOnClickListener(new OnClickListener() {    //可以满足需求
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    mClickListener.clickValueCateItem(bean, position);
                }

                for (RadioButton rb : mRadioButtons) {
                    if (rb != radioButton) {
                        rb.setChecked(false);
                    }
                }
            }
        });
    }

    public void selectButton(int cateId) {
        int position = 0;
        for (int i = 0; i < mList.size(); i++) {
            ScrollCateBean bean = mList.get(i);
            long currentCateId = bean.getId();
            if (cateId == currentCateId) {
                position = i;
                break;
            }
        }
        RadioButton radioButton = mRadioButtons.get(position);
        radioButton.setChecked(true);
        for (RadioButton rb : mRadioButtons) {
            if (rb != radioButton) {
                rb.setChecked(false);
            }
        }
    }

    public ClickValueCateListener getClickListener() {
        return mClickListener;
    }

    public void setClickListener(ClickValueCateListener clickListener) {
        mClickListener = clickListener;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
    }
}
