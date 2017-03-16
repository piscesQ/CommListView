package net.hyww.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.media.audiofx.Visualizer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by zhou on 14-2-22.
 */
public class AudioView extends LinearLayout implements Visualizer.OnDataCaptureListener {

    private MediaPlayer mMediaPlayer;
    private CompletionListener listener;

    public AudioView(Context context) {
        super(context);
        this.setPadding(5, 5, 5, 5);
    }

    public AudioView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setPadding(5, 5, 5, 5);
    }

    private String playUrl = "";
    private boolean isPrepareing=false;
    public void play(String url) {
        if(mMediaPlayer==null){
            mMediaPlayer=new MediaPlayer();
        }
        if(mVisualizer==null){
            setupVisualizerFxAndUi();
        }
        if (playUrl.equals(url)&&((mMediaPlayer != null&&mMediaPlayer.isPlaying())||isPrepareing)) {
            return;
        }

        playUrl = url;
        this.setOrientation(LinearLayout.VERTICAL);
        try {
            isPrepareing=true;
            mMediaPlayer.reset();// 重置为初始状态
            mMediaPlayer.setDataSource(getContext(), Uri.parse(url));
            mMediaPlayer.prepareAsync();// 缓冲
        } catch (Throwable e) {
            return;
        }
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                // TODO Auto-generated method stub
                isPrepareing=false;
                mMediaPlayer.start();// 开始或恢复播放
            }
        });
        this.setOrientation(LinearLayout.VERTICAL);
//        mMediaPlayer = MediaPlayer.create(getContext(), Uri.parse(url));

        if (mVisualizer!=null) {
            try {
                mVisualizer.setEnabled(true);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                playUrl="";
                if (mVisualizer!=null) {
                    try {
                        mVisualizer.setEnabled(false);
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
                if(listener!=null){
                    listener.onCompletion();
                }
            }
        });
//        mMediaPlayer.start();
    }

    private int colorRes;

    public void setLineColor(int colorRes) {
        this.colorRes = colorRes;
    }

    private SpectrumView mSpectrumView;
    private Visualizer mVisualizer;
    private static final float VISUALIZER_HEIGHT_DIP = 200.0f;

    /**
     * 生成一个VisualizerView对象，使音频频谱的波段能够反映到 VisualizerView上
     */
    private void setupVisualizerFxAndUi() {
        mSpectrumView = new SpectrumView(getContext());
        mSpectrumView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (int) (VISUALIZER_HEIGHT_DIP * getResources()
                        .getDisplayMetrics().density)));
        this.removeAllViews();
        this.addView(mSpectrumView);

        try {
            if (mVisualizer != null) {
                mVisualizer.release();
            }
            mVisualizer = new Visualizer(mMediaPlayer.getAudioSessionId());
            // 参数内必须是2的位数
            mVisualizer.setCaptureSize(1024);// 一定是fix的1024


            // 设置允许波形表示，并且捕获它
            mVisualizer.setDataCaptureListener(this, Visualizer.getMaxCaptureRate(), false, true);//更新频率，影响性能
        } catch (RuntimeException e) {
            mVisualizer=null;
        }
    }
    public void pause(){
        if (mMediaPlayer != null) {
//            mMediaPlayer.stop();
            mMediaPlayer.pause();
        }
    }

    public void reOpen(){
        if (mMediaPlayer != null) {
//            mMediaPlayer.stop();
            mMediaPlayer.start();
        }
    }
    public boolean isPlaying(){
        return mMediaPlayer!=null && mMediaPlayer.isPlaying();
    }
    public void stop() {
        if (mMediaPlayer != null) {
//            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer=null;
        }
        if (mVisualizer != null) {
            mVisualizer.release();
        }
    }

    @Override
    public void onWaveFormDataCapture(Visualizer visualizer, byte[] fft, int i) {

    }

    @Override
    public void onFftDataCapture(Visualizer visualizer, byte[] fft, int i) {
        mSpectrumView.updateVisualizer(fft);
    }


    class SpectrumView extends View {
        private final int mIndicatorCount = 32;
        private float[] mIndicators = new float[mIndicatorCount];
        private float[] mOldIndicators = new float[mIndicatorCount];
        private int mMultiplier;
        private float[] mStrength;

        private Paint mPaint = new Paint();
        //private final Object mLock = new Object();

        private float[] mPeeks = new float[mIndicatorCount];
        private int[] mPeeksDelay = new int[mIndicatorCount];

        private SpectrumView(Context context) {
            super(context);
            init();
        }

        private void init() {
            mPaint.setStrokeWidth(1f);
            //mPaint.setAntiAlias(true);
            if (colorRes == -1) {
                mPaint.setColor(Color.WHITE);
            } else {
                mPaint.setColor(colorRes);
            }
        }

        public void updateVisualizer(byte[] mbyte) {
            //synchronized (mLock)
            {
                if (mStrength == null || mStrength.length != mbyte.length) {
                    mStrength = new float[mbyte.length * 3 / (2 * 4)];
                    mMultiplier = mStrength.length / mIndicatorCount;
                }
                mStrength[0] = (float) Math.sqrt((float) mbyte[0] * mbyte[0]
                        + (float) mbyte[1] * mbyte[1])
                        / (mbyte.length);
                for (int i = 1; i < mStrength.length; i++) {
                    mStrength[i] = (float) (2 * Math.sqrt((float) mbyte[2 * i]
                            * mbyte[2 * i] + (float) mbyte[2 * i + 1]
                            * mbyte[2 * i + 1]) / (mbyte.length));
                }

                // synchronized(mLock)
                {
                    for (int a = 0, bd = 0; bd < mIndicatorCount; a += mMultiplier, bd++) {
                        float wFs = 0;
                        for (int b = 0; b < mMultiplier; b++) {
                            wFs += mStrength[a + b];
                        }

                        wFs = (wFs * (float) Math.log(bd + 2.0F));

                        if (wFs > 1.0F) {
                            wFs = 1.0F;
                        }
                        if (wFs < 0.0F) {
                            wFs = 0.0F;
                        }

                        if (wFs >= (mOldIndicators[bd] - 0.1f)) {
                            mOldIndicators[bd] = wFs;
                        } else {
                            mOldIndicators[bd] -= 0.1f;
                            if (mOldIndicators[bd] < 0) {
                                mOldIndicators[bd] = 0;
                            }
                            wFs = mOldIndicators[bd];
                        }
                        mIndicators[bd] = wFs;
                    }
                }
            }
            invalidate();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // TODO Auto-generated method stub
            super.onDraw(canvas);

            if (mStrength == null)
                return;

            // synchronized(mLock)
            {
                //mRect.set(0, 0, getWidth(), getHeight());

                int indicatorWidth = getWidth() / mIndicatorCount;

                for (int i = 0; i < mIndicatorCount; i++) {

                    int height = (int) (mIndicators[i] * getHeight());

                    Rect rect = new Rect(i * indicatorWidth, // left
                            getHeight() - height, // top
                            (i + 1) * indicatorWidth - 1, // right
                            getHeight()); // bottom

                    canvas.drawRect(rect, mPaint);

                    if (mPeeks[i] < height) {
                        mPeeks[i] = height;
                        mPeeksDelay[i] = 10;   //停留的时间参数
                    } else {
                        mPeeksDelay[i]--;
                        if (mPeeksDelay[i] < 0) {
                            mPeeks[i] -= 10;  //下降的时间参数
                        }
                        if (mPeeks[i] == 0)
                            mPeeks[i] = 0;
                        ;
                    }

                    int pY = (int) mPeeks[i];
                    if (pY % 2 == 1)
                        pY++;

                    pY = getHeight() - pY;

                    canvas.drawLine(i * indicatorWidth, pY, (i + 1)
                            * indicatorWidth - 1, pY, mPaint);

                }
            }
        }
    }

    class VisualizerView extends View {

        private byte[] mBytes;
        private float[] mPoints;
        // 矩形区域
        private Rect mRect = new Rect();
        // 画笔
        private Paint mPaint = new Paint();

        // 初始化画笔
        private void init() {
            mBytes = null;
            mPaint.setStrokeWidth(1f);
            mPaint.setAntiAlias(true);
            mPaint.setColor(Color.BLUE);
        }

        public VisualizerView(Context context) {
            super(context);
            init();
        }

        public void updateVisualizer(byte[] mbyte) {
            mBytes = mbyte;
            invalidate();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // TODO Auto-generated method stub
            super.onDraw(canvas);

            if (mBytes == null) {
                return;
            }
            if (mPoints == null || mPoints.length < mBytes.length * 4) {
                mPoints = new float[mBytes.length * 4];
            }

            mRect.set(0, 0, getWidth(), getHeight());

            for (int i = 0; i < mBytes.length - 1; i++) {
                mPoints[i * 4] = mRect.width() * i / (mBytes.length - 1);
                mPoints[i * 4 + 1] = mRect.height() / 2
                        + ((byte) (mBytes[i] + 128)) * (mRect.height() / 2)
                        / 128;
                mPoints[i * 4 + 2] = mRect.width() * (i + 1)
                        / (mBytes.length - 1);
                mPoints[i * 4 + 3] = mRect.height() / 2
                        + ((byte) (mBytes[i + 1] + 128)) * (mRect.height() / 2)
                        / 128;
            }

            canvas.drawLines(mPoints, mPaint);

        }
    }

    public  void setOnCompletionListener(CompletionListener listener){
        this.listener=listener;
    }

    public interface CompletionListener{
        public void onCompletion();
    }
}
