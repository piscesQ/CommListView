package com.app.koreq.commlib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Selection;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.koreq.commlib.R;
import com.app.koreq.commlib.utils.DensityUtils;

/**
 * 仿支付宝支付密码View
 */
public class PayPwdEditText extends RelativeLayout {

    private EditText editText; //文本编辑框
    private Context context;

    private LinearLayout linearLayout; //文本密码的文本
    private TextView[] textViews; //文本数组

    private int pwdlength = 6; //密码长度， 默认6

    private OnTextFinishListener onTextFinishListener;


    public PayPwdEditText(Context context) {
        this(context, null);
    }

    public PayPwdEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PayPwdEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;

        //获取xml中的属性 得到的全是值单位是 像素
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PayPwdEditText);
        int bgDrawable = typedArray.getResourceId(R.styleable.PayPwdEditText_payBgDrawable, 0);   //正常
        int pwdLength = typedArray.getInt(R.styleable.PayPwdEditText_payPwdLength, 6);   //正常
        float splitLineWid = typedArray.getDimension(R.styleable.PayPwdEditText_paySplitLineWidth, 0);   //正常
        int splitLineColor = typedArray.getColor(R.styleable.PayPwdEditText_paySplitLineColor, Color.YELLOW);   //正常
        int pwdColor = typedArray.getColor(R.styleable.PayPwdEditText_payPwdColor, Color.BLUE);   //正常
        int pwdSize = (int) typedArray.getDimension(R.styleable.PayPwdEditText_payPwdSize, DensityUtils.dip2px(context, 15));   //正常
        typedArray.recycle();   //需要回收

        initStyle(bgDrawable, pwdLength, splitLineWid, splitLineColor, pwdColor, pwdSize);
    }

    /**
     * @param bgdrawable    背景drawable
     * @param pwdlength     密码长度
     * @param splilinewidth 分割线宽度
     * @param splilinecolor 分割线颜色
     * @param pwdcolor      密码字体颜色
     * @param pwdsize       密码字体大小
     */
    public void initStyle(int bgdrawable, int pwdlength, float splilinewidth, int splilinecolor, int pwdcolor, int pwdsize) {
        this.pwdlength = pwdlength;
        initEdit(bgdrawable);
        initShowInput(bgdrawable, pwdlength, splilinewidth, splilinecolor, pwdcolor, pwdsize);
    }

    /**
     * 初始化编辑框
     *
     * @param bgcolor
     */
    private void initEdit(int bgcolor) {
        editText = new EditText(context);
        editText.setBackgroundResource(bgcolor);
        editText.setCursorVisible(false);
        editText.setTextSize(0);
        editText.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD | InputType.TYPE_CLASS_NUMBER);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(pwdlength)});
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Editable etext = editText.getText();
                Selection.setSelection(etext, etext.length());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                initDatas(s);
                if (s.length() == pwdlength) {
                    if (onTextFinishListener != null) {
                        onTextFinishListener.onFinish(s.toString().trim());
                    }
                }
            }
        });
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        addView(editText, lp);

    }

    /**
     * @param bgcolor       背景drawable
     * @param pwdlength     密码长度
     * @param slpilinewidth 分割线宽度
     * @param splilinecolor 分割线颜色
     * @param pwdcolor      密码字体颜色
     * @param pwdsize       密码字体大小
     */
    public void initShowInput(int bgcolor, int pwdlength, float slpilinewidth, int splilinecolor, int pwdcolor, int pwdsize) {
        //添加密码框父布局
        linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundResource(bgcolor);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        addView(linearLayout);

        //添加密码框
        textViews = new TextView[pwdlength];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT);
        params.weight = 1;
        params.gravity = Gravity.CENTER;

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams((int) slpilinewidth, LayoutParams.MATCH_PARENT);
        for (int i = 0; i < textViews.length; i++) {
            final int index = i;
            TextView textView = new TextView(context);
            textView.setGravity(Gravity.CENTER);
            textViews[i] = textView;
            textViews[i].setTextSize(DensityUtils.px2dip(context, pwdsize));
            textViews[i].setTextColor(pwdcolor);
            textViews[i].setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD | InputType.TYPE_CLASS_NUMBER);

            LinearLayout llText = new LinearLayout(context);
            llText.setOrientation(LinearLayout.VERTICAL);

            LinearLayout.LayoutParams paramsTv = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 0);
            paramsTv.weight = 1;
            llText.addView(textView, paramsTv);

            LinearLayout.LayoutParams paramsLine = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 1);
            paramsLine.leftMargin = DensityUtils.dip2px(context, 12);
            paramsLine.rightMargin = DensityUtils.dip2px(context, 12);
            View underline = new View(context);
            underline.setBackgroundColor(Color.RED);
            llText.addView(underline, paramsLine);

            linearLayout.addView(llText, params);

            if (i < textViews.length - 1) {
                View view = new View(context);
                view.setBackgroundColor(splilinecolor);
                linearLayout.addView(view, params2);
            }
        }
    }

    /**
     * 是否显示明文
     *
     * @param isShowNum
     */
    public void setShowNum(boolean isShowNum) {
        int length = textViews.length;
        for (int i = 0; i < length; i++) {
            if (isShowNum) {
                textViews[i].setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                textViews[i].setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    /**
     * 设置显示类型
     *
     * @param type
     */
    public void setInputType(int type) {
        int length = textViews.length;
        for (int i = 0; i < length; i++) {
            textViews[i].setInputType(type);
        }
    }

    /**
     * 清除文本框
     */
    public void clearText() {
        editText.setText("");
        for (int i = 0; i < pwdlength; i++) {
            textViews[i].setText("");
        }
    }

    public void setOnTextFinishListener(OnTextFinishListener onTextFinishListener) {
        this.onTextFinishListener = onTextFinishListener;
    }

    /**
     * 根据输入字符，显示密码个数
     *
     * @param s
     */
    public void initDatas(Editable s) {
        if (s.length() > 0) {
            int length = s.length();
            for (int i = 0; i < pwdlength; i++) {
                if (i < length) {
                    for (int j = 0; j < length; j++) {
                        char ch = s.charAt(j);
                        textViews[j].setText(String.valueOf(ch));
                    }
                } else {
                    textViews[i].setText("");
                }
            }
        } else {
            for (int i = 0; i < pwdlength; i++) {
                textViews[i].setText("");
            }
        }
    }

    public String getPwdText() {
        if (editText != null)
            return editText.getText().toString().trim();
        return "";
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public interface OnTextFinishListener {
        void onFinish(String str);
    }

    public void setFocus() {
        editText.requestFocus();
        editText.setFocusable(true);
        showKeyBord(editText);
    }

    /**
     * 显示键盘
     *
     * @param view
     */
    public void showKeyBord(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);

    }

}
