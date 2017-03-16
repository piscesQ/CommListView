package net.hyww.widget.flipper;


import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.*;
import android.view.GestureDetector.OnGestureListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import net.hyww.widget.R;

/**
 * 锟皆讹拷锟斤拷锟斤拷专锟斤拷丶锟�
 */
public class FlipperViewWithIndex extends FrameLayout {

    private Context context;
    private MyFlipperView flipper;
    private LinearLayout index_layout;
    private FrameLayout ads_layout;
    private int index_count;

    private GestureDetector detector;
    private boolean isscrrol = false;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (index_count > 1) {
                int index = (Integer) flipper.getCurrentView().getTag();
                for (int i = 0; i < index_count; i++) {
                    if (i == index) {
                        index_layout.getChildAt(i).setBackgroundResource(
                                R.drawable.dian2);
                    } else {
                        index_layout.getChildAt(i).setBackgroundResource(
                                R.drawable.dian1);
                    }
                }
            }
            super.handleMessage(msg);
        }

    };

    public FlipperViewWithIndex(Context context) {
        super(context, null);
        init(context, null);
    }

    public FlipperViewWithIndex(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public FlipperViewWithIndex(Context context, AttributeSet attrs, int def) {
        super(context, attrs, def);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        this.context = context;
        detector = new GestureDetector(context, new detectorLisnter());
        int viewFlipperBgId = 0;
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.FlipperViewWithIndex);
        try {
            viewFlipperBgId = a.getResourceId(
                    R.styleable.FlipperViewWithIndex_viewFlipperbg, 0);
        } finally {
            a.recycle();
        }

        View v = LayoutInflater.from(context).inflate(
                R.layout.view_flipper_with_index, null);
        flipper = (MyFlipperView) v.findViewById(R.id.ads);
        flipper.setBackgroundResource(viewFlipperBgId);
        flipper.setLongClickable(true);
//        flipper.setHandler(mHandler);
        index_layout = (LinearLayout) v.findViewById(R.id.ads_index);
        ads_layout = (FrameLayout) v.findViewById(R.id.ads_layout);
        this.addView(v);
    }

    public MyFlipperView findFlipperView() {
        return flipper;
    }

    public void setFlipperBackground(int resid) {
        flipper.setBackgroundResource(resid);
    }

    public void viewFlipperAddView(int position, String url, int width,
                                   float height) {
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.drawable.learning_default_img_0)
//                .showImageForEmptyUri(R.drawable.learning_default_img_0)
//                .showImageOnFail(R.drawable.learning_default_img_0)
//                .cacheInMemory(true).cacheOnDisk(true)
//                .bitmapConfig(Bitmap.Config.ARGB_8888).build();
        ImageView adsIcon = new ImageView(context);
        adsIcon.setScaleType(ScaleType.CENTER_CROP);
        adsIcon.setTag(position);
        if (!TextUtils.isEmpty(url)) {
            if (!adsIcon.isDrawingCacheEnabled()) {
                Log.i("url", "" + url);
//                ImageLoader.getInstance().displayImage(url, adsIcon,options);
            } else {
                adsIcon.setImageBitmap(null);
            }
        } else {
            adsIcon.setVisibility(View.INVISIBLE);
        }
        flipper.addView(adsIcon);
    }

    public void viewFlipperAddView(int position, int resourceId) {
        ImageView adsIcon = new ImageView(context);
        adsIcon.setTag(position);
        adsIcon.setScaleType(ScaleType.FIT_XY);
        adsIcon.setBackgroundResource(resourceId);
        flipper.addView(adsIcon);
    }

    public void initIndexLayout(int count) {
        index_count = count;
        if (count <= 1) {
            flipper.setIsAnimation(false);
//            flipper.setHandler(null);
            return;
        }
        ads_layout.setVisibility(View.VISIBLE);
        for (int i = 0; i < count; i++) {
            ImageView indexIcon = new ImageView(context);
            if (i == 0) {
                indexIcon.setBackgroundResource(R.drawable.dian2);
            } else {
                indexIcon.setBackgroundResource(R.drawable.dian1);
            }
            DisplayMetrics ds = new DisplayMetrics();
            if (context instanceof Activity) {
                ((Activity) context).getWindowManager().getDefaultDisplay()
                        .getMetrics(ds);
            } else {
                WindowManager wm = (WindowManager) context.getApplicationContext()
                        .getSystemService(Context.WINDOW_SERVICE);
                wm.getDefaultDisplay().getMetrics(ds);
            }
            LinearLayout.LayoutParams p;
            if (ds.widthPixels < 480) {
                p = new LinearLayout.LayoutParams(5, 5);

            } else {
                p = new LinearLayout.LayoutParams(10, 10);
            }
            p.setMargins(0, 0, 10, 0);
            indexIcon.setLayoutParams(p);
            index_layout.addView(indexIcon);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        super.dispatchTouchEvent(ev);
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            getParent().requestDisallowInterceptTouchEvent(false);
            return true;
        }
        detector.onTouchEvent(ev);
        return true;
    }

    class detectorLisnter implements OnGestureListener {

        public boolean onDown(MotionEvent e) {
            // TODO Auto-generated method stub
            isscrrol = false;
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
        }

        public void onShowPress(MotionEvent e) {
            // TODO Auto-generated method stub

        }

        public boolean onSingleTapUp(MotionEvent e) {
            getParent().requestDisallowInterceptTouchEvent(false);
            return false;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            // TODO Auto-generated method stub

            if (e1.getY() - e2.getY() > 150 && !isscrrol) {
                getParent().requestDisallowInterceptTouchEvent(false);
                isscrrol = true;
                return true;
            } else if (e1.getY() - e2.getY() < -150 && !isscrrol) {
                getParent().requestDisallowInterceptTouchEvent(false);
                isscrrol = true;
                return true;
            } else if (e1.getX() - e2.getX() < -50 && !isscrrol) {
                getParent().requestDisallowInterceptTouchEvent(true);
                isscrrol = true;
                return true;
            } else if ((e1.getX() - e2.getX() > 50 && !isscrrol)) {
                getParent().requestDisallowInterceptTouchEvent(true);
                isscrrol = true;
                return true;
            }
            return false;
        }

        public void onLongPress(MotionEvent e) {
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            return false;
        }

    }

}
