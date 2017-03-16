package net.hyww.widget;

/**
 * Created by HYWW on 2014/8/28.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

/**
 * @功能 图文混排TextView，请使用{@link #setMText(CharSequence)}
 */
public class MTextView extends TextView {
    /**
     * 缓存测量过的数据
     */
    private static HashMap<String, SoftReference<MeasuredData>> measuredData = new HashMap<String, SoftReference<MeasuredData>>();
    private static int hashIndex = 0;
    /**
     * 存储当前文本内容，每个item为一行
     */
    ArrayList<LINE> contentList = new ArrayList<LINE>();
    private Context context;
    /**
     * 用于测量字符宽度
     */
    private TextPaint paint = new TextPaint();

    //	private float lineSpacingMult = 0.5f;
    private int textColor = Color.BLACK;

    private boolean singleLine = false;//是否当行
    /**
     * 当文本数据行数大于等于maxLines时显示showLines行
     */
    private int maxLines = Integer.MAX_VALUE;//最大行数
    private int showLines = 6;//显示行数
    private boolean moreLine;
    //图片间距
    private int imageSpanSpacing;
    private int imageSpanSpacingDp = 2;
    //行距
    private float lineSpacing;
    private int lineSpacingDP = 2;
    /**
     * 最大宽度
     */
    private int maxWidth;
    /**
     * 只有一行时的宽度
     */
    private int oneLineWidth = -1;
    /**
     * 已绘的行中最宽的一行的宽度
     */
    private float lineWidthMax = -1;
    /**
     * 存储当前文本内容,每个item为一个字符或者一个SpanObject
     */
    private ArrayList<Object> obList = new ArrayList<Object>();
    /**
     * 是否使用默认{@link #onMeasure(int, int)}和{@link #onDraw(Canvas)}
     */
    private boolean useDefault = false;
    private CharSequence text = "";

    private int minHeight;
    /**
     * 用以获取屏幕高宽
     */
    private DisplayMetrics displayMetrics;
    /**
     * {@link android.text.style.BackgroundColorSpan}用
     */
    private Paint textBgColorPaint = new Paint();
    /**
     * {@link android.text.style.BackgroundColorSpan}用
     */
    private Rect textBgColorRect = new Rect();

    private Paint textColorPaint = new Paint();

    private InitializeListener initializeListener;

    public MTextView(Context context) {
        super(context);
        this.context = context;
        init(context);
    }

    public MTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
    }

    public MTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        imageSpanSpacing = DensityUtil.dip2px(context, imageSpanSpacingDp);
        paint.setAntiAlias(true);
        textColorPaint.setAntiAlias(true);
        lineSpacing = DensityUtil.dip2px(context, lineSpacingDP);
        minHeight = DensityUtil.dip2px(context, 20);
        displayMetrics = new DisplayMetrics();
        if (!TextUtils.isEmpty(getHint())) {
            setMText(getHint());
        }
        if (!TextUtils.isEmpty(getText())) {
            setMText(getText());
        }
        setGravity(Gravity.LEFT);
    }


    @Override
    public void setMaxWidth(int maxpixels) {
        super.setMaxWidth(maxpixels);
        maxWidth = maxpixels;
    }

    @Override
    public void setMinHeight(int minHeight) {
        super.setMinHeight(minHeight);
        this.minHeight = minHeight;
    }

    public void setImageSpanSpacingDp(int imageSpanSpacingDp) {
        this.imageSpanSpacingDp = imageSpanSpacingDp;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (useDefault) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int width = 0, height = 0;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        switch (widthMode) {
            case MeasureSpec.EXACTLY:
                width = widthSize;
                break;
            case MeasureSpec.AT_MOST:
                width = widthSize;
                break;
            case MeasureSpec.UNSPECIFIED:

                ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                width = displayMetrics.widthPixels;
                break;
            default:
                break;
        }
        if (maxWidth > 0)
            width = Math.min(width, maxWidth);
        textColor = getTextColors().getDefaultColor();
        paint.setTextSize(this.getTextSize());
        paint.setColor(textColor);
        int realHeight = measureContentHeight((int) width);

        //如果实际行宽少于预定的宽度，减少行宽以使其内容横向居中
        int leftPadding = getCompoundPaddingLeft();
        int rightPadding = getCompoundPaddingRight();
        width = Math.min(width, (int) lineWidthMax + leftPadding + rightPadding);

        if (oneLineWidth > -1) {
            width = oneLineWidth;
        }
        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                height = heightSize;
                break;
            case MeasureSpec.AT_MOST:
                height = realHeight;
                break;
            case MeasureSpec.UNSPECIFIED:
                height = realHeight;
                break;
            default:
                break;
        }

        height += getCompoundPaddingTop() + getCompoundPaddingBottom();

        height = Math.max(height, minHeight);
        super.onMeasure(MeasureSpec.makeMeasureSpec(width, widthMode), MeasureSpec.makeMeasureSpec(height, heightMode));
        setMeasuredDimension(width, height);
        if (initializeListener != null) {
            initializeListener.initializeFinish(this);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (useDefault) {
            super.onDraw(canvas);
            return;
        }
        if (contentList.isEmpty())
            return;
        int width;

        Object ob;

        int leftPadding = getCompoundPaddingLeft();
        int topPadding = getCompoundPaddingTop();

        float height = 0 + topPadding + lineSpacing;
        //只有一行时
//        if (oneLineWidth != -1) {
//            height = getMeasuredHeight() / 2 - contentList.get(0).height / 2;
//        }
        height = topPadding;
        int contentLines = contentList.size();
        for (int i = 0; i < contentLines; i++) {
            LINE aContentList = contentList.get(i);
            //绘制一行
            float realDrawedWidth = leftPadding;
            for (int j = 0; j < aContentList.line.size(); j++) {
                ob = aContentList.line.get(j);
                width = aContentList.widthList.get(j);

                if (ob instanceof String) {
                    canvas.drawText((String) ob, realDrawedWidth, height + aContentList.height - paint.getFontMetrics().descent, paint);
                    realDrawedWidth += width;
                } else if (ob instanceof SpanObject) {
                    Object span = ((SpanObject) ob).span;
                    if (span instanceof ImageSpan) {
                        ImageSpan is = (ImageSpan) span;
                        Drawable d = is.getDrawable();
//                        height =height+ (aContentList.height-width)/2;
                        int realImageWidth = width - imageSpanSpacing;
                        int left = (int) (realDrawedWidth);
                        int top = (int) height + (aContentList.height - realImageWidth) / 2;
                        int right = (int) (realDrawedWidth + realImageWidth);
                        int bottom = (int) (height + (aContentList.height - realImageWidth) / 2 + realImageWidth);
                        d.setBounds(left, top, right, bottom);
                        d.draw(canvas);
                        realDrawedWidth += width;
                    } else if (span instanceof BackgroundColorSpan) {
                        textBgColorPaint.setColor(((BackgroundColorSpan) span).getBackgroundColor());
                        textBgColorPaint.setStyle(Paint.Style.FILL);
                        textBgColorRect.left = (int) realDrawedWidth;
                        int textHeight = (int) getTextSize();
                        textBgColorRect.top = (int) (height + aContentList.height - textHeight - paint.getFontMetrics().descent);
                        textBgColorRect.right = textBgColorRect.left + width;
                        textBgColorRect.bottom = (int) (height + aContentList.height);
                        canvas.drawRect(textBgColorRect, textBgColorPaint);
                        canvas.drawText(((SpanObject) ob).source.toString(), realDrawedWidth, height + aContentList.height - paint.getFontMetrics().descent, paint);
                        realDrawedWidth += width;
                    } else if (span instanceof ForegroundColorSpan) {
                        textColorPaint.setColor(((ForegroundColorSpan) span).getForegroundColor());
                        textColorPaint.setTextSize(paint.getTextSize());
                        canvas.drawText(((SpanObject) ob).source.toString(), realDrawedWidth, height + aContentList.height - paint.getFontMetrics().descent, textColorPaint);
                        realDrawedWidth += width;
                    } else if (span instanceof ClickableSpan) {
                        TextPaint textPaint = new TextPaint();
                        ((ClickableSpan) span).updateDrawState(textPaint);
                        textColorPaint.setColor(textPaint.getColor());
                        textColorPaint.setTextSize(paint.getTextSize());
                        //textColorPaint.setFlags(Paint.UNDERLINE_TEXT_FLAG); //设置下划线
                        canvas.drawText(((SpanObject) ob).source.toString(), realDrawedWidth, height + aContentList.height - paint.getFontMetrics().descent, textColorPaint);
                        realDrawedWidth += width;
                    } else if (span instanceof StyleSpan) {

                    } else//做字符串处理
                    {
                        canvas.drawText(((SpanObject) ob).source.toString(), realDrawedWidth, height + aContentList.height - paint.getFontMetrics().descent, paint);
                        realDrawedWidth += width;
                    }
                }

            }
            if (i < contentLines - 1) {
                height += aContentList.height + lineSpacing;
            } else {
                height += aContentList.height;
            }
        }

    }

    @Override
    public void setTextColor(int color) {
        super.setTextColor(color);
        textColor = color;
    }

    @Override
    public void setSingleLine(boolean singleLine) {
        this.singleLine = singleLine;
        super.setSingleLine(singleLine);
    }


    public void setMaxLines(int maxLines) {
        this.maxLines = maxLines;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    /**
     * 用于带ImageSpan的文本内容所占高度测量
     *
     * @param width 预定的宽度
     * @return 所需的高度
     */
    private int measureContentHeight(int width) {
        int cachedHeight = getCachedData(text.toString(), width);

        if (cachedHeight > 0) {
            return cachedHeight;
        }

        // 已绘的宽度
        float obWidth = 0;
        float obHeight = 0;

        float textSize = this.getTextSize();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        //行高
        float lineHeight = fontMetrics.bottom - fontMetrics.top;
        //计算出的所需高度
        float height = lineSpacing;

        int leftPadding = getCompoundPaddingLeft();
        int rightPadding = getCompoundPaddingRight();

        float drawedWidth = 0;
        float tempDrawedwidth = 0;

        boolean splitFlag = false;//BackgroundColorSpan拆分用

        width = width - leftPadding - rightPadding;

        oneLineWidth = -1;

        contentList.clear();

        StringBuilder sb;
        moreLine = false;
        LINE line = new LINE();
        for (int i = 0; i < obList.size(); i++) {
            Object ob = obList.get(i);

            if (ob instanceof String) {

                obWidth = paint.measureText((String) ob);
                obHeight = textSize;
                if (ob.equals("\n")) {//字符串为换行字符 直接开始下一行
                    splitFlag = true;
                }
            } else if (ob instanceof SpanObject) {
                Object span = ((SpanObject) ob).span;
                if (span instanceof ImageSpan) {
                    Rect r = ((ImageSpan) span).getDrawable().getBounds();
                    obWidth = r.right - r.left + imageSpanSpacing;
                    obHeight = r.bottom - r.top;
                    if (obHeight > lineHeight)
                        lineHeight = obHeight;
                } else if (span instanceof BackgroundColorSpan) {
                    String str = ((SpanObject) ob).source.toString();
                    obWidth = paint.measureText(str);
                    obHeight = textSize;

                    //如果太长,拆分
                    int k = str.length() - 1;
                    while (width - drawedWidth < obWidth) {
                        obWidth = paint.measureText(str.substring(0, k--));
                    }
                    if (k < str.length() - 1) {
                        splitFlag = true;
                        SpanObject so1 = new SpanObject();
                        so1.start = ((SpanObject) ob).start;
                        so1.end = so1.start + k;
                        so1.source = str.substring(0, k + 1);
                        so1.span = ((SpanObject) ob).span;

                        SpanObject so2 = new SpanObject();
                        so2.start = so1.end;
                        so2.end = ((SpanObject) ob).end;
                        so2.source = str.substring(k + 1, str.length());
                        so2.span = ((SpanObject) ob).span;

                        ob = so1;
                        obList.set(i, so2);
                        i--;
                    }
                } else if (span instanceof ForegroundColorSpan) {
                    String str = ((SpanObject) ob).source.toString();
                    obWidth = paint.measureText(str);
                    obHeight = textSize;
                } else if (span instanceof StyleSpan) {
                    continue;
                }//做字符串处理
                else {
                    String str = ((SpanObject) ob).source.toString();
                    obWidth = paint.measureText(str);
                    obHeight = textSize;
                }
            }

            //这一行满了，存入contentList,新起一行
            if (width - drawedWidth < obWidth || splitFlag) {
                splitFlag = false;
                lineHeight = obHeight;
                if (singleLine || (contentList.size() == maxLines - 1 && maxLines <= showLines))//单行
                {
                    if (i <= obList.size()) {
                        if (line.line.size() == 0)
                            continue;
                        Object object = line.line.get(line.line.size() - 1);
                        if (object instanceof String) {
                            String content = (String) object;
                            if (content.length() == 0) {
                                content = "...";
                            } else {
                                String lastObject = content.substring(content.length() - 1, content.length());
                                if (lastObject.getBytes().length == lastObject.length()) {//英文替换两个字符
                                    int endsub = content.length() - 2;
                                    if (endsub < 0) {
                                        endsub = content.length();
                                    }
                                    content = content.substring(0, endsub) + "...";
                                } else {//中文替换一个字符
                                    content = content.substring(0, content.length() - 1) + "...";
                                }
                            }
                            line.line.set(line.line.size() - 1, content);
                        } else {
                            line.line.set(line.line.size() - 1, "...");
                        }
                        moreLine = true;
                    }
                    break;
                }

                contentList.add(line);
//                if (drawedWidth > lineWidthMax) {
//                    lineWidthMax = drawedWidth;
//                }
                tempDrawedwidth = Math.max(drawedWidth, tempDrawedwidth);
                drawedWidth = 0;
                height += line.height + lineSpacing;

                if (contentList.size() == maxLines - 1 && maxLines > showLines) {
                    if (i <= obList.size()) {
                        while (showLines <= contentList.size()) {
                            int lastIndex = contentList.size() - 1;
                            height = height - contentList.get(lastIndex).height - lineSpacing;
                            if (showLines == contentList.size()) {
                                line = contentList.get(contentList.size() - 1);
                                lineHeight = line.height;
                            }
                            contentList.remove(lastIndex);
                        }

                        Object object = line.line.get(line.line.size() - 1);
                        if (object instanceof String) {
                            String content = (String) object;
                            if (content.length() == 0) {
                                content = "...";
                            } else {
                                String lastObject = content.substring(content.length() - 1, content.length());
                                if (lastObject.getBytes().length == lastObject.length()) {//英文替换两个字符
                                    int endsub = content.length() - 2;
                                    if (endsub < 0) {
                                        endsub = content.length();
                                    }
                                    content = content.substring(0, endsub) + "...";
                                } else {//中文替换一个字符
                                    content = content.substring(0, content.length() - 1) + "...";
                                }
                            }
                            line.line.set(line.line.size() - 1, content);
                        } else {
                            line.line.set(line.line.size() - 1, "...");
                        }
                    }
                    moreLine = true;
                    break;
                }

                line = new LINE();

            }

            drawedWidth += obWidth;

            if (ob instanceof String && line.line.size() > 0 && (line.line.get(line.line.size() - 1) instanceof String)) {
                int size = line.line.size();
                sb = new StringBuilder();
                sb.append(line.line.get(size - 1));
                sb.append(ob);
                ob = sb.toString();
                obWidth = obWidth + line.widthList.get(size - 1);
                line.line.set(size - 1, ob);
                line.widthList.set(size - 1, (int) obWidth);
                line.height = (int) lineHeight;

            } else if (ob instanceof String && ob.equals("\n")) {
                line.line.add("");
                line.widthList.add(0);
                line.height = (int) lineHeight;
            } else {
                line.line.add(ob);
                line.widthList.add((int) obWidth);
                line.height = (int) lineHeight;
            }

        }

        tempDrawedwidth = Math.max(tempDrawedwidth, drawedWidth);
        lineWidthMax = tempDrawedwidth;

        if (line != null && line.line.size() > 0) {
            contentList.add(line);
            height += lineHeight - lineSpacing;
        }
        if (contentList.size() <= 1) {
            oneLineWidth = (int) drawedWidth + leftPadding + rightPadding;
            height = lineHeight;
        }

//        if (!type)
//            cacheData(width,moreLine, (int) height);
        return (int) height;
    }

    public boolean isMoreLine() {
        return moreLine;
    }

    public int getCurTextLines() {
        return contentList.size();
    }

    /**
     * 获取缓存的测量数据，避免多次重复测量
     *
     * @param text
     * @param width
     * @return height
     */
    @SuppressWarnings("unchecked")
    private int getCachedData(String text, int width) {
        SoftReference<MeasuredData> cache = measuredData.get(text + maxLines);
        if (cache == null)
            return -1;
        MeasuredData md = cache.get();
        if (md != null && md.textSize == this.getTextSize() && width == md.width) {
            lineWidthMax = md.lineWidthMax;
            contentList = (ArrayList<LINE>) md.contentList.clone();
            oneLineWidth = md.oneLineWidth;

//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < contentList.size(); i++) {
//                LINE line = contentList.get(i);
//                sb.append(line.toString());
//            }
            moreLine = md.moreLine;
            return md.measuredHeight;
        } else
            return -1;
    }

    /**
     * 缓存已测量的数据
     *
     * @param width
     * @param height
     */
    @SuppressWarnings("unchecked")
    private void cacheData(int width, boolean moreLine, int height) {
        MeasuredData md = new MeasuredData();
        md.contentList = (ArrayList<LINE>) contentList.clone();
        md.textSize = this.getTextSize();
        md.lineWidthMax = lineWidthMax;
        md.oneLineWidth = oneLineWidth;
        md.measuredHeight = height;
        md.width = width;
        md.hashIndex = ++hashIndex;
        md.moreLine = moreLine;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < contentList.size(); i++) {
//            LINE line = contentList.get(i);
//            sb.append(line.toString());
//        }

        SoftReference<MeasuredData> cache = new SoftReference<MeasuredData>(md);
        measuredData.put(text.toString() + maxLines, cache);
    }

    /**
     * 用本函数代替{@link #setText(CharSequence)}
     *
     * @param cs
     */
    private boolean type = false;

    public void setMText(CharSequence cs, InitializeListener initializeListener, boolean type) {
        if (TextUtils.isEmpty(cs))
            return;
        text = cs;
        this.type = type;
        setText(text);
        obList.clear();
        ArrayList<SpanObject> isList = new ArrayList<MTextView.SpanObject>();
        useDefault = false;
        if (cs instanceof SpannableString) {
            SpannableString ss = (SpannableString) cs;
            CharacterStyle[] spans = ss.getSpans(0, ss.length(), CharacterStyle.class);
            for (int i = 0; i < spans.length; i++) {

                int s = ss.getSpanStart(spans[i]);
                int e = ss.getSpanEnd(spans[i]);

                if(spans[i].getUnderlying() instanceof ClickableSpan){
                    for (int n = s; n < e; n++) {
                        SpanObject iS = new SpanObject();
                        iS.span = spans[i];
                        iS.start = n;
                        iS.end = n + 1;
                        iS.source = ss.subSequence(n, n + 1);
                        isList.add(iS);
                    }
                }else{
                    SpanObject iS = new SpanObject();
                    iS.span = spans[i];
                    iS.start = s;
                    iS.end = e;
                    iS.source = ss.subSequence(s, e);
                    isList.add(iS);
                }

            }
        } else if (cs instanceof SpannableStringBuilder) {
            SpannableStringBuilder ss = (SpannableStringBuilder) cs;
            CharacterStyle[] spans = ss.getSpans(0, ss.length(), CharacterStyle.class);
            for (int i = 0; i < spans.length; i++) {

                int s = ss.getSpanStart(spans[i]);
                int e = ss.getSpanEnd(spans[i]);
                SpanObject iS = new SpanObject();
                iS.span = spans[i];
                iS.start = s;
                iS.end = e;
                iS.source = ss.subSequence(s, e);
                isList.add(iS);
            }
        }

        //对span进行排序，以免不同种类的span位置错乱
        SpanObject[] spanArray = new SpanObject[isList.size()];
        isList.toArray(spanArray);
        Arrays.sort(spanArray, 0, spanArray.length, new SpanObjectComparator());
        isList.clear();
        for (int i = 0; i < spanArray.length; i++) {
            isList.add(spanArray[i]);
        }

        String str = cs.toString();

        for (int i = 0, j = 0; i < cs.length(); ) {
            if (j < isList.size()) {
                SpanObject is = isList.get(j);
                if (i < is.start) {
                    Integer cp = str.codePointAt(i);
                    //支持增补字符
                    if (Character.isSupplementaryCodePoint(cp)) {
                        i += 2;
                    } else {
                        i++;
                    }

                    obList.add(new String(Character.toChars(cp)));

                } else if (i >= is.start) {
                    obList.add(is);
                    j++;
                    i = is.end;
                }
            } else {
                Integer cp = str.codePointAt(i);
                if (Character.isSupplementaryCodePoint(cp)) {
                    i += 2;
                } else {
                    i++;
                }

                obList.add(new String(Character.toChars(cp)));
            }
        }
        this.initializeListener = initializeListener;
        requestLayout();
    }

    public void setMText(CharSequence cs) {
        setMText(cs, null, type);
    }

    public void setInitializeListener(InitializeListener listener) {
        this.initializeListener = listener;
    }


    public void setUseDefault(boolean useDefault) {
        this.useDefault = useDefault;
        if (useDefault) {
            this.setText(text);
            this.setTextColor(textColor);
        }
    }

    /**
     * 设置行距
     *
     * @param lineSpacingDP 行距，单位dp
     */
    public void setLineSpacingDP(int lineSpacingDP) {
        this.lineSpacingDP = lineSpacingDP;
        lineSpacing = DensityUtil.dip2px(context, lineSpacingDP);
    }

    /**
     * 获取行距
     *
     * @return 行距，单位dp
     */
    public int getLineSpacingDP() {
        return lineSpacingDP;
    }
//
//    OnClickListener temp_l;
//    @Override
//    public void setOnClickListener(OnClickListener l) {
//        super.setOnClickListener(this);
//        temp_l=l;
//    }
//
//    @Override
//    public void onClick(View v) {
//        temp_l.onClick(v);
//        Log.e("onclick",v.getContext().getClass().getSimpleName()+"->"+v.getResources().getResourceEntryName(v.getId()));
//    }


    public interface InitializeListener {
        public void initializeFinish(MTextView view);
    }

    /**
     * @功能: 存储Span对象及相关信息
     * @下午5:21:37
     */
    class SpanObject {
        public Object span;
        public int start;
        public int end;
        public CharSequence source;
    }

    /**
     * @version SocialClient 1.2.0
     * @功能: 对SpanObject进行排序
     * @下午5:21:30
     */
    class SpanObjectComparator implements Comparator<SpanObject> {
        @Override
        public int compare(SpanObject lhs, SpanObject rhs) {

            return lhs.start - rhs.start;
        }

    }

    /**
     * @功能: 存储测量好的一行数据
     * @下午5:22:12
     */
    class LINE {
        public ArrayList<Object> line = new ArrayList<Object>();
        public ArrayList<Integer> widthList = new ArrayList<Integer>();
        public int height;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("height:" + height + "   ");
            for (int i = 0; i < line.size(); i++) {
                sb.append(line.get(i) + ":" + widthList.get(i));
            }
            return sb.toString();
        }

    }

    /**
     * @功能: 缓存的数据
     * @下午5:22:25
     */
    class MeasuredData {
        public int measuredHeight;
        public float textSize;
        public int width;
        public float lineWidthMax;
        public int oneLineWidth;
        public int hashIndex;
        public boolean moreLine;
        ArrayList<LINE> contentList;

    }

    private long lastClickTime;

    private static final long CLICK_DELAY = 500l;
    // 本次点击是否已相应长按事件
    private boolean LongClickCalled = true;
    private float lastX = 0;
    private float lastY = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();
        lastX = x;
        lastY = y;
        float deltaX = Math.abs(x - lastX);
        float deltaY = Math.abs(y - lastY);

        if (action == MotionEvent.ACTION_UP ||
                action == MotionEvent.ACTION_DOWN
                ) {

            try {
                x -= getTotalPaddingLeft();
                y -= getTotalPaddingTop();
            } catch (Exception e) {
                e.printStackTrace();
            }

            x += getScrollX();
            y += getScrollY() - getCompoundPaddingTop();
            int off = 0;//点击字符位置
            for (int i = 0; i < contentList.size(); i++) {
                float lineHeight = contentList.get(i).height + lineSpacing;
                if (i == 0 || i == contentList.size() - 1) {
                    lineHeight = contentList.get(i).height + lineSpacing / 2;
                }
                LINE aContentList = contentList.get(i);
                if (y > lineHeight) {
                    y = y - lineHeight;
                    for (int n = 0; n < aContentList.line.size(); n++) {
                        Object object = aContentList.line.get(n);
                        if (object instanceof String) {
                            off = off + object.toString().length();
                        } else if (object instanceof SpanObject) {
                            off = off + ((SpanObject) object).source.length();
                        }
                    }
                } else if (Math.abs(y) < lineHeight) {
                    int tempwidth = getCompoundPaddingLeft();
                    for (int n = 0; n < aContentList.widthList.size(); n++) {
                        int width = aContentList.widthList.get(n);
                        if (tempwidth < x) {
                            Object object = aContentList.line.get(n);
                            if (object instanceof String) {
                                off = off + object.toString().length() - 1;
                            } else if (object instanceof SpanObject) {
                                off = off + ((SpanObject) object).source.length();
                            }
                            tempwidth = tempwidth + width;
                        } else {
                            break;
                        }
                    }
                    if(tempwidth < x){
                        off=-1;
                    }
                    break;
                }
            }
            if(off==-1)
                return super.onTouchEvent(event);

            ClickableSpan[] link = Spannable.Factory.getInstance().newSpannable(text).getSpans(off, off, ClickableSpan.class);

            if (link.length != 0) {
                if (action == MotionEvent.ACTION_UP) {
                    if (System.currentTimeMillis() - lastClickTime < CLICK_DELAY) {
                        link[0].onClick(this);
                    }
                } else if (action == MotionEvent.ACTION_DOWN) {
                    lastClickTime = System.currentTimeMillis();
                    LongClickCalled = false;
                }
                return true;
            } else {
                return super.onTouchEvent(event);
            }
        } else if (action == MotionEvent.ACTION_MOVE && !LongClickCalled) {
            long delta = System.currentTimeMillis() - lastClickTime;
            if (delta > CLICK_DELAY && !LongClickCalled && deltaX < 20 && deltaY < 20) {
                LongClickCalled = true;
                performLongClick();
            }
        }
        return super.onTouchEvent(event);

    }


//    public static class LocalLinkMovementMethod extends LinkMovementMethod {
//        static LocalLinkMovementMethod sInstance;
//        private long lastClickTime;
//
//        private static final long CLICK_DELAY = 500l;
//
//        public static LocalLinkMovementMethod getInstance() {
//            if (sInstance == null)
//                sInstance = new LocalLinkMovementMethod();
//
//            return sInstance;
//        }
//
//        @Override
//        public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
//            int action = event.getAction();
//
//            if (action == MotionEvent.ACTION_UP ||
//                    action == MotionEvent.ACTION_DOWN) {
//                float x = event.getX();
//                float y = event.getY();
//
//                x -= widget.getTotalPaddingLeft();
//                y -= widget.getTotalPaddingTop();
//
//                x += widget.getScrollX();
//                y += widget.getScrollY()-((MTextView) widget).getCompoundPaddingTop() ;
//                ArrayList<LINE> contentList = ((MTextView) widget).contentList;
//                int off = 0;//点击字符位置
//                for (int i = 0; i < contentList.size(); i++) {
//                    float lineHeight = ((MTextView) widget).contentList.get(i).height+((MTextView) widget).lineSpacing;
//                    if(i==0||i==contentList.size()-1){
//                        lineHeight = ((MTextView) widget).contentList.get(i).height+((MTextView) widget).lineSpacing/2;
//                    }
//                    LINE aContentList = contentList.get(i);
//                    if (y > lineHeight) {
//                        y = y - lineHeight;
//                        for (int n = 0; n < aContentList.line.size(); n++) {
//                            Object object = aContentList.line.get(n);
//                            if (object instanceof String) {
//                                off = off + object.toString().length();
//                            } else if (object instanceof SpanObject) {
//                                off = off + ((SpanObject) object).source.length();
//                            }
//                        }
//                    } else if (Math.abs(y) < lineHeight) {
//                        int tempwidth=((MTextView) widget).getCompoundPaddingLeft();
//                        for(int n=0;n<aContentList.widthList.size();n++){
//                            int width = aContentList.widthList.get(n);
//                            if(tempwidth<x){
//                                Object object = aContentList.line.get(n);
//                                if (object instanceof String) {
//                                    off = off + object.toString().length()-1;
//                                } else if (object instanceof SpanObject) {
//                                    off = off + ((SpanObject) object).source.length();
//                                }
//                                tempwidth=tempwidth+width;
//                            }else{
//                                break;
//                            }
//                        }
//                        break;
//                    }
//                }
//                ClickableSpan[] link = buffer.getSpans(off, off, ClickableSpan.class);
//
//                if (link.length != 0) {
//                    if (widget instanceof MTextView) {
//                        ((MTextView) widget).dontConsumeNonUrlClicks = true;
//                        ((MTextView) widget).linkHit = true;
//                    }
//                    if (action == MotionEvent.ACTION_UP) {
//                        if (System.currentTimeMillis() - lastClickTime < CLICK_DELAY) {
////                            Selection.removeSelection(buffer);
//                            link[0].onClick(widget);
//                        }
//                    } else if (action == MotionEvent.ACTION_DOWN) {
////                        Selection.setSelection(buffer,
////                                buffer.getSpanStart(link[0]),
////                                buffer.getSpanEnd(link[0]));
//                        lastClickTime = System.currentTimeMillis();
//                    }
//
//                    return true;
//                } else {
//                    if (widget instanceof MTextView) {
//                        ((MTextView) widget).dontConsumeNonUrlClicks = false;
//                        ((MTextView) widget).linkHit = false;
//                    }
//                    Selection.removeSelection(buffer);
//                }
//            }
//            return super.onTouchEvent(widget, buffer, event);
//        }
//    }

    @Override
    public boolean hasFocusable() {
        return false;
    }

}
