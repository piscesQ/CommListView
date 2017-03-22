package com.app.koreq.commlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.app.koreq.commlistview.adapter.CommListAdapter;
import com.app.koreq.commlistview.bean.OneImageListBean;
import com.app.koreq.commlistview.bean.TextListBean;
import com.app.koreq.commlistview.utils.GsonUtils;
import com.app.koreq.commlistviewlib.bean.BaseListBean;
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
 * author : YanBin on 3/19/17
 * version : v1.0
 * description :
 */
public class CommListActivity extends AppCompatActivity {

    private ListView mListView;
    private List<BaseListBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comm_list);

        initView();
        initData();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.main_list);
    }

    private void initData() {
        mList = new ArrayList<>();
//        initList();
        getTestData();
        CommListAdapter commListAdapter = new CommListAdapter(this, null);
        mListView.setAdapter(commListAdapter);
        commListAdapter.replaceData(mList);
        commListAdapter.notifyDataSetChanged();
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

    private void initList() {

        TextListBean textListBean = new TextListBean();
        textListBean.setViewType(1);
        textListBean.setInvokeType(1);
        textListBean.setTitle("textListBean1");

        mList.add(textListBean);

        textListBean = new TextListBean();
        textListBean.setViewType(1);
        textListBean.setInvokeType(10);
        textListBean.setTitle("textListBean2");

        mList.add(textListBean);

        OneImageListBean oneImageListBean = new OneImageListBean();
        oneImageListBean.setViewType(11);
        oneImageListBean.setInvokeType(11);
        oneImageListBean.setTitle("oneImageBean1");
        oneImageListBean.setUrl("url1");

        mList.add(oneImageListBean);

        oneImageListBean = new OneImageListBean();
        oneImageListBean.setViewType(11);
        oneImageListBean.setInvokeType(11);
        oneImageListBean.setTitle("oneImageBean2");
        oneImageListBean.setUrl("url2");

        mList.add(oneImageListBean);
    }
}
