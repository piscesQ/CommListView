package com.app.koreq.commlistview.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.app.koreq.commlib.widget.ToastManager;
import com.app.koreq.commlistview.R;
import com.app.koreq.qrcode.activity.CaptureActivity;
import com.app.koreq.qrcode.encoding.EncodingHandler;

public class QRCodeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtKeyword;
    private ImageView mIvEncode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        initView();
        initData();
    }

    private void initView() {
        mEtKeyword = (EditText) findViewById(R.id.qrcode_edit);
        mIvEncode = (ImageView) findViewById(R.id.qrcode_encode_img);
        Button btnEncode = (Button) findViewById(R.id.qrcode_encode);
        Button btnDecode = (Button) findViewById(R.id.qrcode_decode);

        btnEncode.setOnClickListener(this);
        btnDecode.setOnClickListener(this);
    }

    private void initData() {

    }

    public static void launchAct(Context context) {
        Intent intent = new Intent(context, QRCodeActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.qrcode_encode:    //编码
                try {
//                    Bitmap mBitmap = EncodingHandler.createQRCode("www.baidu.com", 300);
//                    qrcodeImg.setImageBitmap(mBitmap);
                    String keyword = mEtKeyword.getText().toString();
                    if (!TextUtils.isEmpty(keyword)) {
                        Bitmap logo = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                        Bitmap encodeImage = EncodingHandler.createQRCode(keyword, 600, 600, logo);
                        mIvEncode.setImageBitmap(encodeImage);
                    } else {
                        ToastManager.showShortMessage(this, "请输入需要编码的字符串");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.qrcode_decode:    //解码
                CaptureActivity.launchAct(this);
                break;
        }
    }
}
