package net.hyww.widget.scrollpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import net.hyww.widget.R;

/**
 * Created by zhou on 14-4-15.
 */
public class AutoScrollViewPagerDot extends LinearLayout {

    private int[] resDefID=new int[]{R.drawable.dot_off,R.drawable.dot_on};
//    private int[] resDefID=new int[]{R.drawable.oval_dot_88f,R.drawable.oval_dot_green};
//    private int[] resDefID=new int[]{R.drawable.oval_dot_33f,R.drawable.oval_dot_f};
    private final int ON=1;
    private final int OFF=0;

    public AutoScrollViewPagerDot(Context context) {
        super(context);
        init();
    }

    public AutoScrollViewPagerDot(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setGravity(Gravity.CENTER);
    }

    public void initView(int pageNumber) {
//        setBackgroundColor(0x60000000);
        removeAllViews();
        for (int i = 0; i < pageNumber; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(resDefID[OFF]);
            imageView.setAdjustViewBounds(true);
            imageView.setPadding(10, 3, 10, 3);
            this.addView(imageView);
        }
        if (pageNumber<2){
            setVisibility(INVISIBLE);
        }else {
            setVisibility(VISIBLE);
        }
    }

    private ImageView lastCache;

    public void setCurrentPage(int currentPage) {
        int total = getChildCount();
        if (total == 0){
            return;
        }
        if (currentPage + 1 > total) {
            currentPage %= total;
        }
        ImageView child = (ImageView) getChildAt(currentPage);
        if (child == null)
            return;
        child.setImageResource(resDefID[ON]);
        if (lastCache != null) {
            lastCache.setImageResource(resDefID[OFF]);
        }
        lastCache = child;
    }

    public void setResDefID(int[] resDefID) {
        this.resDefID = resDefID;
    }
}
