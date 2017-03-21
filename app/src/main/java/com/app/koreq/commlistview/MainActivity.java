package com.app.koreq.commlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.app.koreq.commlistview.adapter.CommListAdapter;
import com.app.koreq.commlistview.bean.OneImageListBean;
import com.app.koreq.commlistview.bean.TextListBean;
import com.app.koreq.commlistviewlib.bean.BaseListBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<BaseListBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.main_list);
    }

    private void initData() {
        initList();
        CommListAdapter commListAdapter = new CommListAdapter(this, null);
        mListView.setAdapter(commListAdapter);
        commListAdapter.replaceData(mList);
        commListAdapter.notifyDataSetChanged();
    }

    private void initList() {
        mList = new ArrayList<>();

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
