package net.hyww.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * 带角标的view/widget
 * Created by zhou on 14-6-19.
 */
public class SubscriptView extends FrameLayout {
    private int textVisibility;

    public SubscriptView(Context context) {
        super(context);
        init(context);
    }

    public SubscriptView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private TextView subscript;

    private void init(Context context) {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(params);
        subscript = new TextView(context);
        if (getResources() != null) {
            int size = getResources().getDimensionPixelSize(R.dimen.subscript_size);
            subscript.setLayoutParams(new LayoutParams(size, size, Gravity.RIGHT | Gravity.TOP));
            subscript.setTextColor(getResources().getColor(android.R.color.white));
        }
        subscript.setGravity(Gravity.CENTER);
        subscript.setTextSize(12f);
        subscript.setMaxEms(3);
        subscript.setBackgroundResource(R.drawable.subscript_number);
        this.addView(subscript);
    }

    public SubscriptView targetView(View view) {
        this.addView(view, getChildCount() - 1);
        return this;
    }

    public void setText(int textResID) {
        if (getResources() == null) {
            return;
        }
        String str = getResources().getString(textResID);
        setText(str);
    }

    public void setText(String text) {
        subscript.setText(text);
    }

    public void setTextVisibility(int textVisibility) {
        this.textVisibility = textVisibility;
        subscript.setVisibility(textVisibility);
    }

    public int getTextVisibility() {
        return textVisibility;
    }
}
