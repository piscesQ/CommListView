package com.app.koreq.commlistview.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.koreq.commlistview.R;

public abstract class BaseAct extends AppCompatActivity {

    /**
     * project : CommListView
     * author : YanBin on 3/19/17
     * version : v3.2
     * description : 入口
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        initView();
        initData();
    }

    /**
     * layout文件 返回值样例：R.layout.activity_rx_java
     *
     * @return
     */
    public int getLayoutId(){
        return R.layout.activity_base;
    }

    /**
     * 加载视图
     */
    public abstract void initView();

    /**
     * 加载数据
     */
    public abstract void initData();
}
