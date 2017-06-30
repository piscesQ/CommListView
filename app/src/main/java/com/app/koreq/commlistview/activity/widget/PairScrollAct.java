package com.app.koreq.commlistview.activity.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.app.koreq.commlistview.R;
import com.app.koreq.commlistview.commlist.adapter.CommListAdapter;
import com.app.koreq.commlistview.utils.GsonUtils;
import com.app.koreq.commlistviewlib.bean.BaseListBean;
import com.app.koreq.commlib.widget.PairScorllWidget.PairScrollView;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * project : CommListView
 * author : YanBin on 4/11/17
 * version : v3.0
 * description : PairScrollView Demo类
 */
public class PairScrollAct extends AppCompatActivity {

    private ListView mListView;
    private PairScrollView mPairView;
    private List<BaseListBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pair_scroll);

        initView();
        initData();
    }

    private void initView() {
        mPairView = (PairScrollView) findViewById(R.id.pair_scroll);
        mListView = (ListView) findViewById(R.id.pair_list);

        mPairView.setmTouchEnable(true);
    }

    private void initData() {
        mList = new ArrayList<>();
//        initList();
        getTestData();
        CommListAdapter listAdapter = new CommListAdapter(this, null);
        mListView.setAdapter(listAdapter);

        listAdapter.replaceData(mList.subList(0, 5));   //取前5条数据看看不满屏的情况
        listAdapter.notifyDataSetChanged();
    }

    private void getTestData() {
        StringBuilder builder = new StringBuilder();
        try {
            InputStreamReader reader = new InputStreamReader(getAssets().open("data.txt"), "utf-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String tempStr = null;
            while ((tempStr = bufferedReader.readLine()) != null) {
                builder.append(tempStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = builder.toString();

        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(result);
        mList = GsonUtils.getCustomGson().fromJson(jsonElement, new TypeToken<ArrayList<BaseListBean>>() {
        }.getType());
    }

    public static void launchAct(Context context) {
        Intent intent = new Intent(context, PairScrollAct.class);
        context.startActivity(intent);
    }
}

