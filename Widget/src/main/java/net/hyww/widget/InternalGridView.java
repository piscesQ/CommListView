package net.hyww.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

public class InternalGridView extends GridView {

    private boolean mIsHandlingFocusChange=false;

    public InternalGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InternalGridView(Context context) {
        super(context);
    }

    public InternalGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
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

//    @Override
//    public void requestLayout() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
//            if (!isInLayout()) {
//                super.requestLayout();
//            }
//        }
//    }

    private OnNoItemClickListener listener;
    public interface OnNoItemClickListener
    {
        public void onNoItemClick();
    }

    public void setOnNoItemClickListener(OnNoItemClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event)
    {
        // The pointToPosition() method returns -1 if the touch event
        // occurs outside of a child View.
        // Change the MotionEvent action as needed. Here we use ACTION_DOWN
        // as a simple, naive indication of a click.
        if (pointToPosition((int) event.getX(), (int) event.getY()) == -1
                && event.getAction() == MotionEvent.ACTION_DOWN)
        {
            return new MYGestureListener(getContext()).getDector().onTouchEvent(event);

        }
        return super.dispatchTouchEvent(event);
    }

    public class MYGestureListener extends GestureDetector.SimpleOnGestureListener implements
            OnTouchListener {

        private GestureDetector gDetector;

        public MYGestureListener(){
            super();
        }

        public MYGestureListener(Context con){
            this(con, null);
        }
        public MYGestureListener(Context con, GestureDetector gDetector){
            if(null == gDetector){
                gDetector = new GestureDetector(con, this);
            };

            this.gDetector = gDetector;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            //TODO viewFlipper.showNext()...whatever you want
            return false;
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gDetector.onTouchEvent(event);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            if (listener != null)
            {
                listener.onNoItemClick();
            }
            return super.onSingleTapUp(e);
        }

        public GestureDetector getDector(){
            return this.gDetector;
        }

    }


}
