package com.app.koreq.commlistview.activity.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.koreq.commlib.bean.ScrollCateBean;
import com.app.koreq.commlib.utils.DensityUtils;
import com.app.koreq.commlib.widget.FoldButton;
import com.app.koreq.commlib.widget.ScrollCateLayout;
import com.app.koreq.commlib.widget.ToastManager;
import com.app.koreq.commlib.widget.UPMarqueeView;
import com.app.koreq.commlistview.R;
import com.app.koreq.commlistview.utils.GsonUtils;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * project : CommListView
 * author : YanBin on 7/2/17
 * version : v3.0
 * description : 自定义控件Demo
 */
public class CustomViewActivity extends Activity implements View.OnClickListener {

    private ScrollCateLayout mScrollCateLayout; //水平滚动的标签分类
    private List<ScrollCateBean> mScrollList;
    private FoldButton mFoldButton;

    private UPMarqueeView mMarqueeView;
    private List<String> mMarqueeData;
    private View mSettingText;
    private View mSettingImg;
    private View mSettingRed;
    private boolean textFlag;
    private boolean imgFlag;
    private boolean redFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        initView();
        initData();
    }

    private void initView() {
        //容器
        LinearLayout mContainer = (LinearLayout) findViewById(R.id.custom_view_container);

        //水平滚动的标签分类
        mScrollCateLayout = new ScrollCateLayout(this);
        LinearLayout.LayoutParams scrollCateParams =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mContainer.addView(mScrollCateLayout, scrollCateParams);

        //可折叠、展开的button
        mFoldButton = new FoldButton(this);
        LinearLayout.LayoutParams foldButtonParams =
                new LinearLayout.LayoutParams(DensityUtils.dip2px(this, 35), DensityUtils.dip2px(this, 35));
        foldButtonParams.gravity = Gravity.RIGHT;
        mContainer.addView(mFoldButton, foldButtonParams);

        //------------------------------------------------------------------------------------------
        //垂直轮播的View，支持各种View
//        参考：https://github.com/dreamlivemeng/UpMarqueeTextView-master
        mMarqueeView = (UPMarqueeView) findViewById(R.id.custom_marquee);
        mMarqueeView.setOnItemClickListener(new UPMarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                ToastManager.showShortMessage(CustomViewActivity.this, mMarqueeData.get(position));
            }
        });

        //------------------------------------------------------------------------------------------
        //设置项
        View textState = findViewById(R.id.setting_text_status);
        View imgState = findViewById(R.id.setting_img_status);
        View redState = findViewById(R.id.setting_red_status);
        mSettingText = findViewById(R.id.setting_desc_text);
        mSettingImg = findViewById(R.id.setting_desc_img);
        mSettingRed = findViewById(R.id.setting_desc_red);
        textState.setOnClickListener(this);
        imgState.setOnClickListener(this);
        redState.setOnClickListener(this);

    }

    private void initData() {
        String gsonData = "[{name:\"推荐\",id:1},{name:\"社会\",id:2},{name:\"热门\",id:3},{name:\"电影\",id:4}," +
                "{name:\"音乐\",id:5},{name:\"娱乐\",id:6},{name:\"视频\",id:7},{name:\"天气\",id:8},{name:\"旅游\",id:9}]";
        mScrollList = GsonUtils.getGson().fromJson(gsonData, new TypeToken<ArrayList<ScrollCateBean>>() {
        }.getType());
        mScrollCateLayout.fillData(mScrollList);

        setFabButtonState(true, mScrollList, "1");

        //------------------------------------------------------------------------------------------
        mMarqueeData = new ArrayList<>();
        mMarqueeData.add("1-最是人间留不住，朱颜辞镜花辞树");
        mMarqueeData.add("2-人生若只如初见，何事秋风悲画扇，等闲变却故人心，却道故人心易变");
        mMarqueeData.add("3-天南地北双飞客，老翅几回寒暑");
        mMarqueeData.add("4-红酥手，黄藤酒，满城春色宫墙柳。东风恶欢情薄，一杯愁绪，几年离索，错错错");
        mMarqueeData.add("5-春如旧，人空瘦，泪痕红浥鲛绡透，桃花落，闲池阁，山盟虽在，锦书难脱，莫莫莫");
        mMarqueeData.add("6-东风恶，欢情薄，雨送黄昏花易落，晓风干，泪痕残，欲笺心事，独倚斜阑，难难难");
        mMarqueeData.add("7-人成各，今非昨，病魂常似秋千索，角声寒，夜阑珊，怕人寻问，咽泪装欢，瞒瞒瞒");
        mMarqueeView.setTextViewData(mMarqueeData);
    }

    private void setFabButtonState(boolean isMenu, List<ScrollCateBean> subGroupInfo, final String groupId) {
        if (mFoldButton != null) {
            mFoldButton.setVisibility(View.VISIBLE);
            int widthPixels = DensityUtils.maxWidth();
            if (isMenu) {
//                if (!mFoldButton.isOpened()) {
                mFoldButton.setMode(FoldButton.MODE_MENU);
                mFoldButton.setBackgroundResource(R.drawable.fab_background);
                mFoldButton.setOpenAndCloseImage(R.drawable.home_bottom_arrow_right, R.drawable.home_bottom_arrow_left);
                if (subGroupInfo != null) {
                    int tWidth = DensityUtils.dip2px(this, 30);
//                    int normalColor = getResources().getColor(R.color.white40);
//                    int pressedColor = getResources().getColor(R.color.gray_95);
//                    ColorStateList colorStateList =
//                            com.zhongsou.souyue.common.utils.Utils.createColorStateList(normalColor, pressedColor, pressedColor, normalColor);
                    for (int x = 0; x < subGroupInfo.size(); x++) {
                        ScrollCateBean bean = subGroupInfo.get(x);
                        TextView textView = createGroupTabView(bean);
                        mFoldButton.addInnerButton(textView, false);
                        try {
//                            tWidth += (model.getTitle().length() * DensityUtils.dip2px(this, 15));
                            tWidth += computeStringLength(textView);
                            tWidth += DensityUtils.dip2px(this, 14);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    mFoldButton.setOptionsListener(new FoldButton.ClickInnerListener() {

                        @Override
                        public void clickInnerButton() {
                            mFoldButton.onClick(null);
                        }
                    });

                    tWidth += DensityUtils.dip2px(this, 25);
                    tWidth += DensityUtils.dip2px(this, 14);
                    int maxWidth = widthPixels - DensityUtils.dip2px(this, 30);
                    if (tWidth > maxWidth) {
                        tWidth = maxWidth;
                    }
                    Log.e("fabutton", "width = " + tWidth);
                    mFoldButton.setMaxWidth(tWidth);
                }
            } else {
                mFoldButton.setMode(FoldButton.MODE_BUTTON);
                mFoldButton.setBackgroundResource(R.drawable.home_page_enter_normal);
            }
            mFoldButton.setOnClickListener(this);
            mFoldButton.setButtonState();
        }
    }

    private TextView createGroupTabView(final ScrollCateBean m) {
        //TODO kore 此处使用 item_scroll_cate 用来做测试，由于里面RadioButton，所以点击效果有差异！！
        TextView tv = (TextView) View.inflate(this, R.layout.item_scroll_cate, null);
        tv.setText(m.getName());
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastManager.showShortMessage(CustomViewActivity.this, "Name = " + m.getName());
            }
        });
        return tv;
    }

    private int computeStringLength(TextView view) {
        view.measure(0, 0);
        return view.getMeasuredWidth();
    }


    public static void launchAct(Context context) {
        Intent intent = new Intent(context, CustomViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.setting_text_status:
                if (textFlag) {
                    mSettingText.setVisibility(View.VISIBLE);
                } else {
                    mSettingText.setVisibility(View.GONE);
                }
                textFlag = !textFlag;
                break;
            case R.id.setting_img_status:
                if (imgFlag) {
                    mSettingImg.setVisibility(View.VISIBLE);
                } else {
                    mSettingImg.setVisibility(View.GONE);
                }
                imgFlag = !imgFlag;
                break;
            case R.id.setting_red_status:
                if (redFlag) {
                    mSettingRed.setVisibility(View.VISIBLE);
                } else {
                    mSettingRed.setVisibility(View.GONE);
                }
                redFlag = !redFlag;
                break;

        }
    }
}
