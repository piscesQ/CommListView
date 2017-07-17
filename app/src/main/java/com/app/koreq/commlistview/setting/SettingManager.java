package com.app.koreq.commlistview.setting;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.koreq.commlib.utils.ListUtils;
import com.app.koreq.commlib.widget.CircleTextView;
import com.app.koreq.commlistview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author : YanBin on 7/12/17
 * description : 设置页面 - 管理类
 */
public class SettingManager {
    public static final int MENU_WEB = 1; //web页
    public static final int MENU_FAMILY_MEMBER = 2; //家庭成员 （邀请家人） new！！ MENU_MY_INVITATION
    public static final int SMART_HARDWARE = 3;//智能硬件
    public static final int MENU_MYVIP = 4;//我的会员
    public static final int MENU_RANKING = 5;//我的排行
    public static final int MENU_MY_COMMENT = 6;//我的评论
    public static final int MENU_MY_ATTENTION = 7;//我的关注
    public static final int MENU_MY_DYNAMIC = 8;//我发布的动态
    public static final int MENU_MY_FAVORITE = 9;//我的收藏
    public static final int MENU_MY_ACCOUNT = 10;//我的账户  new  智慧豆 MENU_BBTREE_DOU
    public static final int MENU_MY_FEEDBACK = 11;//使用反馈
    public static final int MENU_BABY_IN_PARK = 12;//宝宝入园
    public static final int MENU_SETTING = 99;//设置

    //    public static final int MENU_INVITATION = 5;//邀请家人
//    public static final int MENU_ME_SETTING = 6;//个人设置
//    public static final int MENU_PUNCH = 10;//考勤请假
//    public static final int MENU_FEEDBACK = 8;//意见反馈
//    public static final int MENU_TIE_CARD = 9;//考勤卡绑定
//    public static final int MENU_OLD_PUNCH = 11;//旧版考勤请假
//    public static final int MENU_MY_FAVORITES = 12;//我的收藏
//    public static final int MENU_SHARE_GROW = 21;//分享成长;

    public static final String LOCAL_RES_PREFIX = "local://";

    private Context mContext;
    private MeItemClickListener mListener;
    private int mUnReadNum; //统计红点和气泡数量

    public interface MeItemClickListener {
        void clickItem(SettingBeanV2.DataBean itemData);
    }

    public SettingManager(Context context) {
        this.mContext = context;
    }

    //填充每组数据
    public View createGroup(LinearLayout group, List<SettingBeanV2.DataBean> groupList) throws Exception {
        if (groupList == null || groupList.size() == 0) {
            return group;
        }

        if (group == null) {
            group = new LinearLayout(mContext);
            group.setOrientation(LinearLayout.VERTICAL);
        }

        int listSize = ListUtils.getSize(groupList);
        int childCount = group.getChildCount();

        if (childCount > listSize) {
            group.removeViews(listSize, childCount - listSize);
        }

        for (int i = 0; i < listSize; i++) {
            View itemView = null;
            ViewHolder holder = null;
            if (childCount - 1 >= i) { //复用布局对象
                itemView = group.getChildAt(i);
                holder = (ViewHolder) itemView.getTag();
            } else {  //新建布局对象
                itemView = View.inflate(mContext, R.layout.item_setting, null);
                holder = new ViewHolder();
                holder.itemLogo = (ImageView) itemView.findViewById(R.id.setting_logo);
                holder.itemName = (TextView) itemView.findViewById(R.id.setting_name);
                holder.bubbleNum = (CircleTextView) itemView.findViewById(R.id.setting_bubble);
                holder.descText = (TextView) itemView.findViewById(R.id.setting_desc_text);
                holder.descImg = (ImageView) itemView.findViewById(R.id.setting_desc_img);
                holder.redPoint = (ImageView) itemView.findViewById(R.id.setting_desc_red);
                holder.lineDivider = itemView.findViewById(R.id.setting_line_divider);
                holder.groupDivider = itemView.findViewById(R.id.setting_group_divider);

                itemView.setTag(holder);
                group.addView(itemView);
            }

            final SettingBeanV2.DataBean itemData = groupList.get(i);
            if (itemData == null) continue;
            SettingBeanV2.DataBean.LinkRuleBean itemRule = itemData.linkRule;
            String linkPhoto = itemData.linkPhoto;
            if (isFromLocal(linkPhoto)) {   //判断图片是否存在本地
                String strResId = linkPhoto.substring(LOCAL_RES_PREFIX.length());
                try {
                    holder.itemLogo.setImageResource(Integer.parseInt(strResId));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //TODO kore 加载图片
//                ImageLoader.loadImageAsync(holder.itemLogo, linkPhoto,
//                        DisplayImageOptionsCfg.getInstance().getOptions(0, new SimpleBitmapDisplayer()));
            }

            holder.itemName.setText(itemData.linkName);
            if (itemRule != null) {
                String bubbleText = "";
                int bubbleBg = 0;
                String descText = "";
                String descImgUrl = "";
                String descTextColor = "#999999";
                try {
                    descImgUrl = itemRule.image;

                    descText = itemRule.text.words;
                    descTextColor = itemRule.text.color;

                    bubbleText = "";
                    String bubbleWords = itemRule.bubble.words;
                    int bubbleNum = Integer.parseInt(TextUtils.isEmpty(bubbleWords) ? "0" : bubbleWords);
                    if (bubbleNum > 0 && bubbleNum <= 99) {
                        bubbleText = String.valueOf(bubbleNum);
                    } else if (bubbleNum > 0) {
                        bubbleText = "99+";
                    }
                    String bubbleColor = itemRule.bubble.color;
                    if (bubbleColor != null && bubbleColor.length() >= 1)
                        bubbleBg = Color.parseColor(bubbleColor);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (TextUtils.isEmpty(bubbleText)) {
                    holder.bubbleNum.setVisibility(View.GONE);
                } else {
                    holder.bubbleNum.setVisibility(View.VISIBLE);
                    holder.bubbleNum.setText(bubbleText);
                    mUnReadNum++;
                    if (bubbleBg > 0) {
                        holder.bubbleNum.setBgColor(bubbleBg);
                    }
                }

                if (TextUtils.isEmpty(descText)) {
                    holder.descText.setVisibility(View.GONE);
                } else {
                    holder.descText.setVisibility(View.VISIBLE);
                    holder.descText.setText(descText);
                    if (!TextUtils.isEmpty(descTextColor) && descTextColor.startsWith("#"))
                        holder.descText.setTextColor(Color.parseColor(descTextColor));
                }

                if (TextUtils.isEmpty(descImgUrl)) {
                    holder.descImg.setVisibility(View.GONE);
                } else {
                    holder.descImg.setVisibility(View.VISIBLE);
                    //TODO kore 加载图片
//                    ImageLoader.loadImageAsync(holder.descImg, descImgUrl,
//                            DisplayImageOptionsCfg.getInstance().getOptions(0, new SimpleBitmapDisplayer()));
                }

                if (itemRule.redPoint == 0) {
                    holder.redPoint.setVisibility(View.INVISIBLE);
                } else {
                    holder.redPoint.setVisibility(View.VISIBLE);
                    mUnReadNum++;
                }
            }
            if (i == listSize - 1) {
                holder.lineDivider.setVisibility(View.GONE);
                holder.groupDivider.setVisibility(View.VISIBLE);
            } else {
                holder.lineDivider.setVisibility(View.VISIBLE);
                holder.groupDivider.setVisibility(View.GONE);
            }
            final ViewHolder finalHolder = holder;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        finalHolder.redPoint.setVisibility(View.INVISIBLE);
                        finalHolder.bubbleNum.setVisibility(View.GONE);
                        mListener.clickItem(itemData);
                    }
                }
            });
        }
//        View divider = new View(mContext);
//        divider.setBackgroundColor(mContext.getResources().getColor(R.color.gray_f5));
//        LinearLayout.LayoutParams dividerParams = new LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT, DensityUtils.dip2px(mContext, 10));
//        group.addView(divider, dividerParams);

        return group;
    }

    /**
     * 判断图片是否存在本地   如果 url以"local://"开头，则是本地资源
     *
     * @param url 本地资源格式： local:// + 资源id
     * @return
     */
    private boolean isFromLocal(String url) {
        boolean ret = false;
        if (!TextUtils.isEmpty(url) && url.startsWith(LOCAL_RES_PREFIX)) ret = true;
        return ret;
    }

    /**
     * 获取未读消息数量 即显示的气泡和小红点的数目
     *
     * @return
     */
    public int getUnReadNum() {
        return mUnReadNum;
    }

    public void resetUnReadNum() {
        mUnReadNum = 0;
    }

    private List<LinearLayout> groupsView = new ArrayList<>();

    public void createSettingView(@NonNull LinearLayout container, @NonNull List<List<SettingBeanV2.DataBean>> allGroupList) {
        int size = allGroupList.size();
        for (int i = 0; i < size; i++) {
            List<SettingBeanV2.DataBean> group = allGroupList.get(i);
            LinearLayout groupView = getGroupView(i);
            View showGroup = null;
            try {
                showGroup = createGroup(groupView, group);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (showGroup != null && showGroup.getParent() == null) {
                container.addView(showGroup);
            }
        }
        if (container.getChildCount() > size) {
            container.removeViews(size, container.getChildCount() - size);
        }
    }

    private LinearLayout getGroupView(int position) {
        if (groupsView == null) groupsView = new ArrayList<>();
        if (position < groupsView.size()) {
            return groupsView.get(position);
        } else {
            return initGroupView();
        }
    }

    private LinearLayout initGroupView() {
        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.VERTICAL);
        groupsView.add(layout);
        return layout;
    }

    static class ViewHolder {
        ImageView itemLogo;
        TextView itemName;
        CircleTextView bubbleNum;
        TextView descText;
        ImageView descImg;
        ImageView redPoint;
        View lineDivider;
        View groupDivider;
    }

    public MeItemClickListener getListener() {
        return mListener;
    }

    public void setListener(MeItemClickListener listener) {
        mListener = listener;
    }
}
