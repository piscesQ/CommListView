package net.hyww.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.HorizontalScrollView;

public class SyncHorizontalScrollView extends HorizontalScrollView {
	private Activity mContext;

	public void setSomeParam(View view, Activity context) {
		this.mContext = context;
		DisplayMetrics dm = new DisplayMetrics();
		this.mContext.getWindowManager().getDefaultDisplay().getMetrics(dm);
	}

	public SyncHorizontalScrollView(Context context) {
		super(context);
	}

	public SyncHorizontalScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
}
