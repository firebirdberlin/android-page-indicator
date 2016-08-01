package com.firebirdberlin.pageindicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;


public class PageIndicator extends View {
    private Context mContext;
    private int pageCount = 3;
    private int currentPage = 0;
    private int color;
    private static final String attr_namespace = "pageindicator";

    public PageIndicator(Context context) {
        super(context);
        mContext = context;
        color = getSystemColor(android.R.attr.textColor);
    }

    public PageIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        String colorString = getAttributeStringValue(attrs, attr_namespace, "color", "android:attr/textColor");
        if (colorString.startsWith("#") ) {
            color = Color.parseColor(colorString);
        } else {
            color = context.getResources().getIdentifier(colorString, null, null);
            color = getSystemColor(color);
        }
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setCurrentPage(int currentPage) {
        if ( currentPage >= pageCount ) {
            return;
        }
        this.currentPage = currentPage;
        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int textColor = color;

        int x = getWidth();
        int y = getHeight();

        final RectF rect = new RectF();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);

        // draw the page indicator
        int radius = y;
        paint.setColor(textColor);
        paint.setAlpha(255);

        int offset = -pageCount * radius;
        for (int i = 0 ; i < pageCount; i++ ) {
            rect.set(x / 2 + 2 * i * y + offset, 0, x / 2 + (2*i +1) * y + offset, y);
            paint.setStyle((i == currentPage) ? Paint.Style.FILL : Paint.Style.STROKE);
            paint.setStrokeWidth(1);
            canvas.drawArc(rect, -90, 360, true, paint);

        }
    }

    private int getSystemColor(int colorID) {
        Resources.Theme theme = mContext.getTheme();
        TypedValue styleID = new TypedValue();
        if (theme.resolveAttribute(colorID, styleID, true)) {
            return styleID.data;
        }
        return Color.parseColor("#FFFFFF");
    }

    private static String getAttributeStringValue(AttributeSet attrs, String namespace,
                                                  String name, String defaultValue) {
        String value = attrs.getAttributeValue(namespace, name);
        if (value == null) value = defaultValue;

        return value;
    }
}
