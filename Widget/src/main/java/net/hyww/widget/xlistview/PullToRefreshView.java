package net.hyww.widget.xlistview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.*;
import android.widget.*;
import net.hyww.widget.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PullToRefreshView extends LinearLayout {
    // refresh states
    private static final int PULL_TO_REFRESH = 2;
    private static final int RELEASE_TO_REFRESH = 3;
    public static final int REFRESHING = 4;

    // pull state
    private static final int PULL_UP_STATE = 0;
    private static final int PULL_DOWN_STATE = 1;
    /**
     * last y
     */
    private int mLastMotionY;
    /**
     * lock
     */
    private boolean mLock;
    /**
     * header view
     */
    private View mHeaderView;
    /**
     * footer view
     */
    private View mFooterView;
    /**
     * list or grid
     */
    private AdapterView<?> mAdapterView;
    /**
     * scrollview
     */
    private ScrollView mScrollView;
    /**
     * header view height
     */
    private int mHeaderViewHeight;
    /**
     * footer view height
     */
    private int mFooterViewHeight;

    /**
     * 空白的tv
     */
    private TextView mStretchTv;

    /**
     * 显示动画的Imageview
     */
    private ImageView mHeaderImageview_baby;
    /**
     * 文字部分布局
     */
    private LinearLayout xlistview_header_text;

    /**
     * header tip text
     */
    private TextView mHeaderTextView;
    /**
     * footer tip text
     */
    private TextView mFooterTextView;
    /**
     * header refresh time
     */
    private TextView mHeaderUpdateTextView;
    /**
     * footer refresh time
     */
    // private TextView mFooterUpdateTextView;
    /**
     * header progress bar
     */
    //private ProgressBar mHeaderProgressBar;
    /**
     * footer progress bar
     */
    private ProgressBar mFooterProgressBar;
    /**
     * layout inflater
     */
    private LayoutInflater mInflater;
    /**
     * header view current state
     */
    public int mHeaderState;
    /**
     * footer view current state
     */
    private int mFooterState;
    /**
     * pull state,pull up or pull down;PULL_UP_STATE or PULL_DOWN_STATE
     */
    private int mPullState;

    /**
     * footer refresh listener
     */
    private OnFooterRefreshListener mOnFooterRefreshListener;
    /**
     * footer refresh listener
     */
    private OnHeaderRefreshListener mOnHeaderRefreshListener;

    private int mTouchSlop;

    private boolean footerRefreshState = true;//是否可以加载更多 默认可以

    private boolean headerRefreshState = true;//是否可以下拉刷新 默认可以
    private int   screenWidth;
    private int ANIMDIST=80;
    private int width=0;
    private int maxTVWidth;


    /**
     * last update time
     */
    // private String mLastUpdateTime;
    public PullToRefreshView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PullToRefreshView(Context context) {
        super(context);
        init();
    }

    /**
     * init
     *
     * @description
     */
    private void init() {

        final ViewConfiguration configuration = ViewConfiguration
                .get(getContext());
        mTouchSlop = configuration.getScaledTouchSlop();

        mInflater = LayoutInflater.from(getContext());
        addHeaderView();

    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void addHeaderView() {
        // header view
        mHeaderView = mInflater.inflate(R.layout.xlistview_header, this, false);

        mStretchTv = (TextView) mHeaderView.findViewById(R.id.tv_stretch);
        xlistview_header_text= (LinearLayout) mHeaderView.findViewById(R.id.xlistview_header_text);
        mHeaderImageview_baby= (ImageView) mHeaderView.findViewById(R.id.xlistview_heade_baby);
        mHeaderTextView = (TextView) mHeaderView.findViewById(R.id.xlistview_header_hint_textview);
        mHeaderUpdateTextView = (TextView) mHeaderView.findViewById(R.id.xlistview_header_time);

        //帧动画
        mHeaderImageview_baby.setBackgroundResource(R.drawable.baby_anim);
        AnimationDrawable anim = (AnimationDrawable) mHeaderImageview_baby.getBackground();
        anim.start();
        //动画 滑动最大距离
         maxTVWidth= (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 43, getContext().getResources()
                        .getDisplayMetrics());

        // header layout
        measureView(mHeaderView);
        mHeaderViewHeight = mHeaderView.getMeasuredHeight();
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                mHeaderViewHeight);
        params.topMargin = -(mHeaderViewHeight);
        // mHeaderView.setLayoutParams(params1);
        addView(mHeaderView, params);

    }

    private void addFooterView() {
        // footer view
        mFooterView = mInflater.inflate(R.layout.xlistview_footer, this, false);
        mFooterTextView = (TextView) mFooterView
                .findViewById(R.id.xlistview_footer_hint_textview);
        mFooterProgressBar = (ProgressBar) mFooterView
                .findViewById(R.id.xlistview_footer_progressbar);
        // footer layout
        measureView(mFooterView);
        mFooterViewHeight = mFooterView.getMeasuredHeight();
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                mFooterViewHeight);
        addView(mFooterView, params);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        addFooterView();
        initContentAdapterView();
    }

    /**
     * init AdapterView like ListView,GridView and so on;or init ScrollView
     */
    private void initContentAdapterView() {
        int count = getChildCount();
        if (count < 3) {
            throw new IllegalArgumentException(
                    "this layout must contain 3 child views,and AdapterView or ScrollView must in the second position!");
        }
        View view = null;
        for (int i = 0; i < count - 1; ++i) {
            view = getChildAt(i);
            if (view instanceof AdapterView<?>) {
                mAdapterView = (AdapterView<?>) view;
            }
            if (view instanceof ScrollView) {
                // finish later
                mScrollView = (ScrollView) view;
            }
        }
        if (mAdapterView == null && mScrollView == null) {
            throw new IllegalArgumentException(
                    "must contain a AdapterView or ScrollView in this layout!");
        }
    }

    private void measureView(View child) {
        ViewGroup.LayoutParams p = child.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight,
                    MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0,
                    MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        int y = (int) e.getRawY();
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastMotionY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaY = y - mLastMotionY;
                final int distance = Math.abs(deltaY);
                final boolean overscroll = getScrollY() != 0;
                if (overscroll || distance > mTouchSlop) {
                    if (isRefreshViewScroll(deltaY)) {
                        return true;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return false;
    }

    public void setLock(boolean lock) {
        mLock = lock;
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setTVLocation(int deltaY){
        // 获取屏幕宽度
        WindowManager manager = (WindowManager) getContext()
                .getSystemService(getContext().WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
         screenWidth=display.getWidth();
        int screenHeight=display.getHeight();
       // Log.e("One","160="+80*160/screenWidth+"");

        LayoutParams params = (LayoutParams) mHeaderView.getLayoutParams();
        float newTopMargin = params.topMargin + deltaY * 0.3f;
        if(pulldownListener!=null){
            pulldownListener.onPulldownDp(newTopMargin);
        }
       // Log.e("One","mHeaderViewHeight="+mHeaderViewHeight +" changingHeaderViewTopMargin(value);="+ changingHeaderViewTopMargin(deltaY));
        //比例= (头部布局高度+头部布局上面外边距)*1.0f/头部布局高度
        float slideRatio=(mHeaderViewHeight+newTopMargin)*1.0f/mHeaderViewHeight;

         width= (int) (maxTVWidth*slideRatio);   //160= 80 *屏幕宽度
        if(width>=maxTVWidth){// 150 需要调整适配其他手机位置   x= 手机屏幕宽度*150 /mx3手机屏幕宽度（1080）
            width=maxTVWidth;
        }
       // Log.e("One","width="+width);
        RelativeLayout.LayoutParams  tvParams= (RelativeLayout.LayoutParams) mStretchTv.getLayoutParams();
        tvParams.width=width;
      //  Log.e("One","params.width="+width);
        mStretchTv.setLayoutParams(tvParams);
        tvParams.leftMargin=5;
        if(width==maxTVWidth){
            // 小孩 滑动完 显示文本布局
            xlistview_header_text.setVisibility(View.VISIBLE);
        }else{
            xlistview_header_text.setVisibility(View.GONE);
        }
    }

    //指定动画结束位置
    public  void setAnimStopLocation(){
        setHeaderTopMargin(0);
        RelativeLayout.LayoutParams  tvParams= (RelativeLayout.LayoutParams) mStretchTv.getLayoutParams();
        //tvParams.width=maxTVWidth;
        mStretchTv.setLayoutParams(tvParams);
        tvParams.leftMargin= (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 43, getContext().getResources()
                        .getDisplayMetrics());;
        // 小孩 滑动完 显示文本布局
        xlistview_header_text.setVisibility(View.VISIBLE);
        this.invalidate();
    }

    //设置动画开始位置
    public void setAnimStartLocation(){
        RelativeLayout.LayoutParams  tvParams= (RelativeLayout.LayoutParams) mStretchTv.getLayoutParams();
        tvParams.width=0;
        mStretchTv.setLayoutParams(tvParams);
        tvParams.leftMargin=0;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mLock) {
            return true;
        }
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaY = y - mLastMotionY;
              //  Log.e("One","y---->>"+y);
               // Log.e("One","mLastMotionY---->>"+mLastMotionY);
                setTVLocation(deltaY);

                if (mPullState == PULL_DOWN_STATE&&headerRefreshState) {
                    headerPrepareToRefresh(deltaY);

                } else if (mPullState == PULL_UP_STATE && footerRefreshState) {
                    footerPrepareToRefresh(deltaY);
                }
                mLastMotionY = y;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                int topMargin = getHeaderTopMargin();
                if (mPullState == PULL_DOWN_STATE&&headerRefreshState) {
                    if (topMargin >= 0) {
                        headerRefreshing();
                    } else {
                        setHeaderTopMargin(-mHeaderViewHeight);
                    }
                } else if (mPullState == PULL_UP_STATE && footerRefreshState) {
                    if (Math.abs(topMargin) >= mHeaderViewHeight/2
                            + mFooterViewHeight) {
                        footerRefreshing();
                    } else {
                        setHeaderTopMargin(-mHeaderViewHeight);
                    }
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private boolean isRefreshViewScroll(int deltaY) {
        if (mHeaderState == REFRESHING || mFooterState == REFRESHING) {
            return false;
        }
        if (mAdapterView != null) {
            if (deltaY > 0) {
                View child = mAdapterView.getChildAt(0);
                if (child == null) {
                    return false;
                }
                if (mAdapterView.getFirstVisiblePosition() == 0
                        && child.getTop() == 0) {
                    mPullState = PULL_DOWN_STATE;
                    return true;
                }
                int top = child.getTop();
                int padding = mAdapterView.getPaddingTop();
                if (mAdapterView.getFirstVisiblePosition() == 0
                        && Math.abs(top - padding) <= 8) {
                    mPullState = PULL_DOWN_STATE;
                    return true;
                }

            } else if (deltaY < 0) {
                View lastChild = mAdapterView.getChildAt(mAdapterView
                        .getChildCount() - 1);
                if (lastChild == null) {
                    return false;
                }
                if (lastChild.getBottom() <= getHeight()
                        && mAdapterView.getLastVisiblePosition() == mAdapterView
                        .getCount() - 1) {
                    mPullState = PULL_UP_STATE;
                    return true;
                }
            }
        }
        if (mScrollView != null) {
            View child = mScrollView.getChildAt(0);
            if (deltaY > 0 && mScrollView.getScrollY() == 0) {
                mPullState = PULL_DOWN_STATE;
                return true;
            } else if (deltaY < 0
                    && child.getMeasuredHeight() <= getHeight()
                    + mScrollView.getScrollY()) {
                mPullState = PULL_UP_STATE;
                return true;
            }
        }
        return false;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void headerPrepareToRefresh(int deltaY) {
        //Log.e("One","deltaY：="+deltaY);
        int newTopMargin = changingHeaderViewTopMargin(deltaY);
        if (newTopMargin >= 0 && mHeaderState != RELEASE_TO_REFRESH) {
            mHeaderUpdateTextView.setVisibility(View.VISIBLE);
            mHeaderState = RELEASE_TO_REFRESH;
        } else if (newTopMargin < 0 && newTopMargin > -mHeaderViewHeight) {

           /* //调用动画
          animator.start();*/

			/*mHeaderImageView.clearAnimation();
			mHeaderImageView.startAnimation(mFlipAnimation);*/
            // mHeaderImageView.
            //mHeaderTextView.setText(R.string.pull_to_refresh_pull_label);
            mHeaderState = PULL_TO_REFRESH;
        }
    }

    private void footerPrepareToRefresh(int deltaY) {
        setFooterViewVisibility(View.VISIBLE);
        int newTopMargin = changingHeaderViewTopMargin(deltaY);
        if (Math.abs(newTopMargin) >= (mHeaderViewHeight/2 + mFooterViewHeight)
                && mFooterState != RELEASE_TO_REFRESH) {
            mFooterTextView
                    .setText(R.string.pull_to_refresh_footer_release_label);
            mFooterState = RELEASE_TO_REFRESH;
        } else if (Math.abs(newTopMargin) < (mHeaderViewHeight/2 + mFooterViewHeight)) {
            mFooterTextView.setText(R.string.pull_to_refresh_footer_pull_label);
            mFooterState = PULL_TO_REFRESH;
        }
    }

    private int changingHeaderViewTopMargin(int deltaY) {
        LayoutParams params = (LayoutParams) mHeaderView.getLayoutParams();
        float newTopMargin = params.topMargin + deltaY * 0.3f;
        if (deltaY > 0 && mPullState == PULL_UP_STATE
                && Math.abs(params.topMargin) <= mHeaderViewHeight) {
            return params.topMargin;
        }
        if (deltaY < 0 && mPullState == PULL_DOWN_STATE
                && Math.abs(params.topMargin) >= mHeaderViewHeight) {
            return params.topMargin;
        }
        params.topMargin = (int) newTopMargin;
        mHeaderView.setLayoutParams(params);
        invalidate();
        return params.topMargin;
    }

    public void headerRefreshing() {
        mHeaderState = REFRESHING;
        if(width==0){//证明没有滑动,是直接调用的刷新方法
            setAnimStopLocation();
        }else{
            setHeaderTopMargin(0);
        }
        width=0;
		/*mHeaderImageView.setVisibility(View.GONE);
		mHeaderImageView.clearAnimation();
		mHeaderImageView.setImageDrawable(null);
		mHeaderProgressBar.setVisibility(View.VISIBLE);*/
        // mHeaderTextView.setText(R.string.pull_to_refresh_refreshing_label);
        if (mOnHeaderRefreshListener != null) {
            mOnHeaderRefreshListener.onHeaderRefresh(this);
        }
    }

    private void footerRefreshing() {
        mFooterState = REFRESHING;
        int top = mHeaderViewHeight + mFooterViewHeight;
        setHeaderTopMargin(-top);
        mFooterProgressBar.setVisibility(View.VISIBLE);
        mFooterTextView
                .setText(R.string.pull_to_refresh_footer_refreshing_label);
        if (mOnFooterRefreshListener != null) {
            mOnFooterRefreshListener.onFooterRefresh(this);
        }
    }

    public void setFooterViewVisibility(int visibility){
        if(mFooterView!=null&&visibility!=mFooterView.getVisibility())
            mFooterView.setVisibility(visibility);
    }

    private void setHeaderTopMargin(int topMargin) {
        LayoutParams params = (LayoutParams) mHeaderView.getLayoutParams();
        params.topMargin = topMargin;
        mHeaderView.setLayoutParams(params);
        invalidate();
    }

    public void onHeaderRefreshComplete() {
        setHeaderTopMargin(-mHeaderViewHeight);
        setAnimStartLocation();//刷新完成,置空动画推动TextView的宽度
	/*	mHeaderImageView.setVisibility(View.VISIBLE);
		mHeaderImageView.setImageResource(R.drawable.xlistview_arrow);*/
        // mHeaderTextView.setText(R.string.pull_to_refresh_pull_label);
        //mHeaderProgressBar.setVisibility(View.GONE);

        xlistview_header_text.setVisibility(View.GONE);
        mHeaderState = PULL_TO_REFRESH;
    }

    /**
     * 获取当前系统时间
     * @return
     */
    private String getCurrentTime(){
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(new Date());
    }

    /**
     * Resets the list to a normal state after a refresh.
     *
     * @param lastUpdated
     *            Last updated at.
     */
    public void onHeaderRefreshComplete(CharSequence lastUpdated) {
        setLastUpdated(lastUpdated);
        onHeaderRefreshComplete();
    }

    public void onFooterRefreshComplete() {
        setHeaderTopMargin(-mHeaderViewHeight);
        mFooterTextView.setText(R.string.pull_to_refresh_footer_pull_label);
        mFooterProgressBar.setVisibility(View.GONE);
        mFooterState = PULL_TO_REFRESH;
    }

    /**
     * Set a text to represent when the list was last updated.
     *
     * @param lastUpdated
     *            Last updated at.
     */
    public void setLastUpdated(CharSequence lastUpdated) {
//        if (lastUpdated != null) {
            mHeaderUpdateTextView.setVisibility(View.VISIBLE);
            mHeaderUpdateTextView.setText(/*lastUpdated*/getCurrentTime());
           // Log.e("xu", "当前刷新时间："+lastUpdated);
//        } else {
//            mHeaderUpdateTextView.setVisibility(View.GONE);
//        }
    }

    private int getHeaderTopMargin() {
        LayoutParams params = (LayoutParams) mHeaderView.getLayoutParams();
        return params.topMargin;
    }

    public void setOnHeaderRefreshListener(
            OnHeaderRefreshListener headerRefreshListener) {
        mOnHeaderRefreshListener = headerRefreshListener;
    }

    public void setOnFooterRefreshListener(
            OnFooterRefreshListener footerRefreshListener) {
        mOnFooterRefreshListener = footerRefreshListener;
    }

    /**
     * Interface definition for a callback to be invoked when list/grid footer
     * view should be refreshed.
     */
    public interface OnFooterRefreshListener {
        public void onFooterRefresh(PullToRefreshView view);
    }

    /**
     * Interface definition for a callback to be invoked when list/grid header
     * view should be refreshed.
     */
    public interface OnHeaderRefreshListener {
        public void onHeaderRefresh(PullToRefreshView view);
    }

    public void setRefreshFooterState(boolean state) {
        this.footerRefreshState = state;
    }
    public void setRefreshHeaderState(boolean state) {
        this.headerRefreshState = state;
    }


    /**
     * 下拉距离监听
     */
    private OnPulldownListener pulldownListener;
    public void setPulldownListener(OnPulldownListener pulldownListener) {
        this.pulldownListener = pulldownListener;
    }
    public interface OnPulldownListener{
        void onPulldownDp(float distance);
    }

}
