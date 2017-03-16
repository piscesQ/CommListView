package net.hyww.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/7/14.
 */
public class DoubleClickTextView extends TextView {

    private MYGestureListener mYGestureListener;
    private boolean mIsHandlingFocusChange=false;

    public DoubleClickTextView(Context context) {
        super(context);
        initView(context);
    }

    public DoubleClickTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DoubleClickTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    private void initView(Context context){
        setLongClickable(true);
        mYGestureListener=new MYGestureListener(context) ;
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mYGestureListener.getDector().onTouchEvent(event);
            }
        });
    }

    private OnDoubleClickListener listener;
    private OnClickListener clickListener;

    public interface OnDoubleClickListener {
        public void onDoubleClick();
    }

    public void setOnDoubleClickListener(OnDoubleClickListener listener) {
        this.listener = listener;
    }

    public class MYGestureListener extends GestureDetector.SimpleOnGestureListener implements
            OnTouchListener {

        private GestureDetector gDetector;

        public MYGestureListener() {
            super();
        }

        public MYGestureListener(Context con) {
            this(con, null);
        }

        public MYGestureListener(Context con, GestureDetector gDetector) {
            if (null == gDetector) {
                gDetector = new GestureDetector(con, this);
            };

            this.gDetector = gDetector;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            super.onShowPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            if (listener != null) {
                listener.onDoubleClick();
            }
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if(clickListener!=null){
                clickListener.onClick(DoubleClickTextView.this);
            }
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            return true;
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gDetector.onTouchEvent(event);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return super.onSingleTapUp(e);
        }

        public GestureDetector getDector() {
            return this.gDetector;
        }

    }

    public void setOnClickListener(OnClickListener listener1){
        this.clickListener=listener1;
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        mIsHandlingFocusChange = true;
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        mIsHandlingFocusChange = false;
    }

    @Override
    public void requestLayout() {
        if (!mIsHandlingFocusChange) {
            super.requestLayout();
        }
    }
}
