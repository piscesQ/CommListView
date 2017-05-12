package com.app.koreq.commlistview.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.koreq.commlistview.R;
import com.app.koreq.commlistview.utils.AESUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeDecryptActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_decrypt);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initView();
        initData();
    }

    private void initView() {
        Button btnDecrypt1 = (Button) findViewById(R.id.tree_decrypt_1);
        Button btnDecrypt2 = (Button) findViewById(R.id.tree_decrypt_2);
        mTvResult = (TextView) findViewById(R.id.tree_result);

        btnDecrypt1.setOnClickListener(this);
        btnDecrypt2.setOnClickListener(this);
        mTvResult.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.tree_decrypt_1: //点击解密按钮 - 解密参数
//                执行解密
                mTvResult.setText(decryptionStr("tree_encryption.txt"));
                break;
            case R.id.tree_decrypt_2: //点击解密按钮 - 解密结果
//                执行解密
                mTvResult.setText(decryptionStr("tree_encryption_2.txt"));
                break;
            case R.id.tree_result:  //点击结果TextView
                Toast.makeText(this, "click Result", Toast.LENGTH_SHORT).show();
                //复制到粘贴板
                copy2Broad(mTvResult.getText().toString());
                break;
        }
    }

    //"tree_encryption.txt"
    private String decryptionStr(String filePath) {
        StringBuilder builder = new StringBuilder();
        try {
            InputStreamReader reader = new InputStreamReader(getAssets().open(filePath), "utf-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String tempStr = null;
            while ((tempStr = bufferedReader.readLine()) != null) {
                builder.append(tempStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = builder.toString();

        try {
            String tempStr = result;
            result = AESUtils.decryptFromTr(AESUtils.AESKey, tempStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 复制到剪切板
     *
     * @param clipContent
     */
    private void copy2Broad(String clipContent) {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("article url", clipContent);
        clipboardManager.setPrimaryClip(clip);
        Toast.makeText(this, "copy success", Toast.LENGTH_LONG).show();
    }

    public static void launchAct(Context context) {
        Intent intent = new Intent(context, TreeDecryptActivity.class);
        context.startActivity(intent);
    }
}
