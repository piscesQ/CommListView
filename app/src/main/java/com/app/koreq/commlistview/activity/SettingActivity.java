package com.app.koreq.commlistview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.koreq.commlib.utils.DensityUtils;
import com.app.koreq.commlib.widget.ToastManager;
import com.app.koreq.commlistview.R;
import com.app.koreq.commlistview.setting.SettingBeanV2;
import com.app.koreq.commlistview.setting.SettingManager;
import com.app.koreq.commlistview.utils.GsonUtils;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {
    private SettingManager mManager;
    private LinearLayout mHeadContainer;
    private LinearLayout mListContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();
        initData();
    }

    private void initView() {
        mHeadContainer = (LinearLayout) findViewById(R.id.setting_head);
        mListContainer = (LinearLayout) findViewById(R.id.setting_list);

        TextView tvHeadTitle = new TextView(this);
        tvHeadTitle.setText("设置页面");
        tvHeadTitle.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tvHeadTitle.setPadding(0, DensityUtils.dip2px(this, 10), 0, DensityUtils.dip2px(this, 10));
        tvHeadTitle.setLayoutParams(params);
        mHeadContainer.addView(tvHeadTitle);
    }

    private void initData() {
        mManager = new SettingManager(this);
        // json对象解析和实现
//        String testListData = "{list:[[{\"linkGroup\":2,\"linkName\":\"家庭成员\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_invitation.png\",\"linkRule\":{\"bubble\":{\"color\":\"red\",\"words\":\"1\"},\"image\":\"http://s0.bbtree.com/public/myself/child_equipment.png\",\"redPoint\":1,\"text\":{\"color\":\"#ff0000\",\"words\":\"哈哈\"}},\"linkType\":2,\"linkUrl\":\"\",\"point\":\"JZ_Wo_YaoQingJiaRen\",\"type\":2},{\"linkGroup\":2,\"linkName\":\"智能硬件\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_equipment.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":1,\"text\":{\"color\":\"\",\"words\":\"续费\"}},\"linkType\":3,\"linkUrl\":\"\",\"point\":\"JZ_Wo_ZhiNengSheBei\",\"type\":3}],[{\"linkGroup\":3,\"linkName\":\"我的会员\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_vips.png\",\"linkRule\":{\"bubble\":{\"color\":\"red\",\"words\":\"\"},\"image\":\"http://s0.bbtree.com/public/myself/child_icon_flower.png\",\"redPoint\":1,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":4,\"linkUrl\":\"\",\"point\":\"JZ_Wo_HuiYuanZhongXin\",\"type\":4},{\"linkGroup\":3,\"linkName\":\"我的排名\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_ranking.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"http://s0.bbtree.com/public/myself/child_comment.png\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"排名\"}},\"linkType\":5,\"linkUrl\":\"\",\"point\":\"JZ_Wo_BanJiPaiHang\",\"type\":5},{\"linkGroup\":3,\"linkName\":\"我的小红花\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_icon_flower.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":1,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":6,\"linkUrl\":\"http://s0.bbtree.com/5.0/redFlowerRule.html?userId\\u003d107\\u0026childId\\u003d1003\\u0026r\\u003d1287362284\",\"point\":\"JZ_Wo_WoDeXiaoHongHua\",\"type\":1},{\"linkGroup\":3,\"linkName\":\"我的评论\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_comment.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"http://s0.bbtree.com/public/myself/child_icon_flower.png\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":7,\"linkUrl\":\"\",\"point\":\"JZ_Wo_WoDePingLun\",\"type\":6}],[{\"linkGroup\":4,\"linkName\":\"我的关注\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_follow.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"关注\"}},\"linkType\":8,\"linkUrl\":\"\",\"point\":\"JZ_Wo_WoDeGuanZhu\",\"type\":7},{\"linkGroup\":4,\"linkName\":\"我的动态\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_dynamic.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":9,\"linkUrl\":\"\",\"point\":\"JZ_Wo_WoDeDongTai\",\"type\":8},{\"linkGroup\":4,\"linkName\":\"我的收藏\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_collection.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":10,\"linkUrl\":\"\",\"point\":\"JZ_Wo_WoDeShouCang\",\"type\":9}],[{\"linkGroup\":5,\"linkName\":\"我的保险\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_Insurance.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":11,\"linkUrl\":\"http://s0.bbtree.com/insurance/pages/index.html?user_id\\u003d107\\u0026child_id\\u003d1003\\u0026r\\u003d322258932\",\"point\":\"cm_6\",\"type\":1}],[{\"linkGroup\":6,\"linkName\":\"我的账户\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_icon_bean.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":12,\"linkUrl\":\"\",\"point\":\"cm_6\",\"type\":10},{\"linkGroup\":6,\"linkName\":\"我的订单\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/c_my_order.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":13,\"linkUrl\":\"https://auction-static.bbtree.com/payweb/my-order.html?user_id\\u003d107\\u0026token\\u003d7693862a077220fe2d207c860a696d8c\\u0026username\\u003d18800000011\\u0026r\\u003d154833518\",\"point\":\"JZ_Wo_WoDeDingDan\",\"type\":1}],[{\"linkGroup\":7,\"linkName\":\"使用反馈\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_feedback.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":14,\"linkUrl\":\"\",\"point\":\"JZ_Wo_ShiYongFanKui\",\"type\":11},{\"linkGroup\":0,\"linkName\":\"设置\",\"linkPhoto\":\"local://2130839078\",\"linkRule\":{\"redPoint\":1},\"linkType\":0,\"type\":99}]]}";
//        SettingBeanV2 settingBeanV2 = GsonUtils.getGson().fromJson(testListData, SettingBeanV2.class);
//        mManager.createSettingView(mListContainer, settingBeanV2.list);

        // json数组解析和实现
        String testListData = "[[{\"linkGroup\":2,\"linkName\":\"家庭成员\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_invitation.png\",\"linkRule\":{\"bubble\":{\"color\":\"red\",\"words\":\"1\"},\"image\":\"http://s0.bbtree.com/public/myself/child_equipment.png\",\"redPoint\":1,\"text\":{\"color\":\"#ff0000\",\"words\":\"哈哈\"}},\"linkType\":2,\"linkUrl\":\"\",\"point\":\"JZ_Wo_YaoQingJiaRen\",\"type\":2},{\"linkGroup\":2,\"linkName\":\"智能硬件\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_equipment.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":1,\"text\":{\"color\":\"\",\"words\":\"续费\"}},\"linkType\":3,\"linkUrl\":\"\",\"point\":\"JZ_Wo_ZhiNengSheBei\",\"type\":3}],[{\"linkGroup\":3,\"linkName\":\"我的会员\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_vips.png\",\"linkRule\":{\"bubble\":{\"color\":\"red\",\"words\":\"\"},\"image\":\"http://s0.bbtree.com/public/myself/child_icon_flower.png\",\"redPoint\":1,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":4,\"linkUrl\":\"\",\"point\":\"JZ_Wo_HuiYuanZhongXin\",\"type\":4},{\"linkGroup\":3,\"linkName\":\"我的排名\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_ranking.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"http://s0.bbtree.com/public/myself/child_comment.png\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"排名\"}},\"linkType\":5,\"linkUrl\":\"\",\"point\":\"JZ_Wo_BanJiPaiHang\",\"type\":5},{\"linkGroup\":3,\"linkName\":\"我的小红花\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_icon_flower.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":1,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":6,\"linkUrl\":\"http://s0.bbtree.com/5.0/redFlowerRule.html?userId\\u003d107\\u0026childId\\u003d1003\\u0026r\\u003d1287362284\",\"point\":\"JZ_Wo_WoDeXiaoHongHua\",\"type\":1},{\"linkGroup\":3,\"linkName\":\"我的评论\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_comment.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"http://s0.bbtree.com/public/myself/child_icon_flower.png\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":7,\"linkUrl\":\"\",\"point\":\"JZ_Wo_WoDePingLun\",\"type\":6}],[{\"linkGroup\":4,\"linkName\":\"我的关注\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_follow.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"关注\"}},\"linkType\":8,\"linkUrl\":\"\",\"point\":\"JZ_Wo_WoDeGuanZhu\",\"type\":7},{\"linkGroup\":4,\"linkName\":\"我的动态\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_dynamic.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":9,\"linkUrl\":\"\",\"point\":\"JZ_Wo_WoDeDongTai\",\"type\":8},{\"linkGroup\":4,\"linkName\":\"我的收藏\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_collection.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":10,\"linkUrl\":\"\",\"point\":\"JZ_Wo_WoDeShouCang\",\"type\":9}],[{\"linkGroup\":5,\"linkName\":\"我的保险\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_Insurance.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":11,\"linkUrl\":\"http://s0.bbtree.com/insurance/pages/index.html?user_id\\u003d107\\u0026child_id\\u003d1003\\u0026r\\u003d322258932\",\"point\":\"cm_6\",\"type\":1}],[{\"linkGroup\":6,\"linkName\":\"我的账户\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_icon_bean.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":12,\"linkUrl\":\"\",\"point\":\"cm_6\",\"type\":10},{\"linkGroup\":6,\"linkName\":\"我的订单\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/c_my_order.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":13,\"linkUrl\":\"https://auction-static.bbtree.com/payweb/my-order.html?user_id\\u003d107\\u0026token\\u003d7693862a077220fe2d207c860a696d8c\\u0026username\\u003d18800000011\\u0026r\\u003d154833518\",\"point\":\"JZ_Wo_WoDeDingDan\",\"type\":1}],[{\"linkGroup\":7,\"linkName\":\"使用反馈\",\"linkPhoto\":\"http://s0.bbtree.com/public/myself/child_feedback.png\",\"linkRule\":{\"bubble\":{\"color\":\"\",\"words\":\"\"},\"image\":\"\",\"redPoint\":0,\"text\":{\"color\":\"\",\"words\":\"\"}},\"linkType\":14,\"linkUrl\":\"\",\"point\":\"JZ_Wo_ShiYongFanKui\",\"type\":11},{\"linkGroup\":0,\"linkName\":\"设置\",\"linkPhoto\":\"local://2130839078\",\"linkRule\":{\"redPoint\":1},\"linkType\":0,\"type\":99}]]";
        List<List<SettingBeanV2.DataBean>> settingList = GsonUtils.getGson().fromJson(testListData, new TypeToken<ArrayList<ArrayList<SettingBeanV2.DataBean>>>() {
        }.getType());

        mManager.createSettingView(mListContainer, settingList);
        mManager.setListener(new SettingManager.MeItemClickListener() {
            @Override
            public void clickItem(SettingBeanV2.DataBean itemData) {
                String linkName = itemData.linkName;
                ToastManager.showShortMessage(SettingActivity.this, "点击了 - " + linkName + " !! ");
            }
        });
    }

    public static void launchAct(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }
}
