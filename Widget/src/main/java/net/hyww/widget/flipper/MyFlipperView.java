package net.hyww.widget.flipper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import net.hyww.widget.R;

public class MyFlipperView extends ViewFlipper {

    public static final int TOLEFT = 1;
    public static final int TORIGHT = 2;

    private Context context;
    private GestureDetector detector;
    private boolean isscrrol = false;
    private onSingleTapFlipperLisnter listener;
    private int delayMillis = 5000;
    // private Handler handler1;
    private boolean isAnimation = true;

    private int maxViewCount;

    private boolean isCache = false;
    private boolean loop =true;

    private final Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            if (msg.what == 1 && isAnimation) {
                removeMessages(1);
                showNext();
                msg = obtainMessage(1);
                sendMessageDelayed(msg, delayMillis);
            }
        }
    };

    public MyFlipperView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public MyFlipperView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }
    public void onDetachedFromWindow(){
        try {
            super.onDetachedFromWindow();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            super.stopFlipping();
        }


    }

    public int getCrruentId() {
        try {
            return (Integer) this.getCurrentView().getTag();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }

    public void setCacheState(int size) {
        if (size > maxViewCount)
            isCache = true;
    }

    public void setMaxViewCount(int maxViewCount){
        this.maxViewCount=maxViewCount;
    }

    public void setIsAnimation(boolean aniGo) {
        this.isAnimation = aniGo;
    }

    public void setLoop(boolean loop){
        this.loop=loop;
    }

    private void init() {
        detector = new GestureDetector(new detectorLisnter());
        setInAnimation(context, R.anim.push_left_in);
        Animation ai = AnimationUtils.loadAnimation(context,
                R.anim.push_left_out);
        ai.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(listener!=null)
                    listener.curruentView(getCrruentId());
                if (isCache)
                    flingToNext();
            }
        });
        setOutAnimation(ai);
    }

    public void setDelayMillis(int delayMillis) {
        this.delayMillis = delayMillis;
    }

    @SuppressLint("HandlerLeak")
    // public void setHandler(Handler handler) {
    // handler1 = handler;
    // }
    public void setOnSingletapFlipperListener(onSingleTapFlipperLisnter listener) {
        this.listener = listener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    class detectorLisnter implements OnGestureListener {

        public boolean onDown(MotionEvent e) {
            // TODO Auto-generated method stub
            isscrrol = false;

            return true;
        }

        public void onShowPress(MotionEvent e) {
            // TODO Auto-generated method stub

        }

        public boolean onSingleTapUp(MotionEvent e) {
            if (listener != null) {
                listener.onSingleTap(getCrruentId());
            }
            return false;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            // TODO Auto-generated method stub
            if (e1.getX() - e2.getX() > 100 && !isscrrol && isAnimation) {
                if(!loop&&getDisplayedChild() + 1==maxViewCount){
                    return true;
                }
                mHandler.removeMessages(1);
                Animation ai = AnimationUtils.loadAnimation(context,
                        R.anim.push_left_in);
                ai.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if(listener!=null)
                            listener.curruentView(getCrruentId());
                        if (isCache)
                            flingToPrevious();
                    }
                });
                setInAnimation(ai);
                setOutAnimation(AnimationUtils.loadAnimation(context,
                        R.anim.push_left_out));

                showNext();

                // if (handler1 != null)
                // handler1.sendEmptyMessage(0);
                mHandler.sendEmptyMessageDelayed(1, 5000);
                isscrrol = true;
                return true;
            } else if (e1.getX() - e2.getX() < -100 && !isscrrol && isAnimation) {
                if(!loop&&getDisplayedChild()==0){
                    return true;
                }
                mHandler.removeMessages(1);
                setInAnimation(AnimationUtils.loadAnimation(context,
                        R.anim.push_right_in));

                Animation ai = AnimationUtils.loadAnimation(context,
                        R.anim.push_right_out);
                ai.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if(listener!=null)
                            listener.curruentView(getCrruentId());
                        if (isCache)
                            flingToNext();
                    }
                });
                setOutAnimation(ai);
                showPrevious();
                setInAnimation(AnimationUtils.loadAnimation(context,
                        R.anim.push_left_in));
                ai = AnimationUtils
                        .loadAnimation(context, R.anim.push_left_out);
                ai.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if(listener!=null)
                            listener.curruentView(getCrruentId());
                        if (isCache)
                            flingToNext();
                    }
                });
                setOutAnimation(ai);
                mHandler.sendEmptyMessageDelayed(1, delayMillis);
                isscrrol = true;
                return true;
            }
            return false;
        }

        public void onLongPress(MotionEvent e) {
            // TODO Auto-generated method stub
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            return false;
        }

    }

    public void flingToNext() {
        if (null != listener) {
            if (getChildCount() == maxViewCount) {
                int disPlayedChild = getDisplayedChild() + 1;
                if (disPlayedChild >= maxViewCount) {
                    disPlayedChild = 0;
                }
                View view = getChildAt(disPlayedChild);
                listener.setViewData(view, getCrruentId() + 1);
            } else {
                View view = listener.getNextView(getCrruentId());
                addView(view, getChildCount());
            }
        }
    }

    public void flingToPrevious() {
        if (null != listener) {
            if (getChildCount() == maxViewCount) {
                int disPlayedChild = getDisplayedChild() - 1;
                if (disPlayedChild < 0) {
                    disPlayedChild = maxViewCount - 1;
                }
                View view = getChildAt(disPlayedChild);
                listener.setViewData(view, getCrruentId() - 1);
            } else {
                View view = listener.getPreviousView(getCrruentId());
                addView(view, getChildCount());
            }
        }
    }

    public void onResume() {
        mHandler.removeMessages(1);
        mHandler.sendEmptyMessageDelayed(1, delayMillis);
    }

    public void onPause() {
        mHandler.removeMessages(1);
    }

    public GestureDetector getGestureDetector(){
        return detector;
    }

    public interface onSingleTapFlipperLisnter {
        public void onSingleTap(int position);

        View getNextView(int listPosition);

        View getPreviousView(int listPosition);

        void setViewData(View view, int listPosition);

        void curruentView(int listPosition);
    }

}
