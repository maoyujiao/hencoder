package com.aiyuba.hencoder._7textmeasure;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import android.widget.Toast;

import com.aiyuba.hencoder.util.Util;

/**
 * Created by maoyujiao on 2019/9/29.
 */

public class MultiTextAndPicView extends View {
    private Bitmap bitmap;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float[] curWith = new float[1];
    private float vertilOffset = Util.dp2px(50);
    private float imageOffset = Util.dp2px(50);
    private float bitmapRadius = Util.dp2px(100);
    private Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean justo sem, sollicitudin in maximus a, vulputate id magna. Nulla non quam a massa sollicitudin commodo fermentum et est. Suspendisse potenti. Praesent dolor dui, dignissim quis tellus tincidunt, porttitor vulputate nisl. Aenean tempus lobortis finibus. Quisque nec nisl laoreet, placerat metus sit amet, consectetur est. Donec nec quam tortor. Aenean aliquet dui in enim venenatis, sed luctus ipsum maximus. Nam feugiat nisi rhoncus lacus facilisis pellentesque nec vitae lorem. Donec et risus eu ligula dapibus lobortis vel vulputate turpis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In porttitor, risus aliquam rutrum finibus, ex mi ultricies arcu, quis ornare lectus tortor nec metus. Donec ultricies metus at magna cursus congue. Nam eu sem eget enim pretium venenatis. Duis nibh ligula, lacinia ac nisi vestibulum, vulputate lacinia tortor.";
    public MultiTextAndPicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap = Util.getBitmap(context,(int)bitmapRadius);
        paint.setTextSize(Util.dp2px(16));
        paint.getFontMetrics(fontMetrics);
        String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aen";
        Log.e("长度", "长度" + str.length());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,getWidth() - bitmap.getWidth(), imageOffset, paint);
        float vertilOffset = -fontMetrics.top; //初始化，第一行为0
        for (int start = 0; start < text.length();) {
            int textWith;
            float textTop = vertilOffset + fontMetrics.top;
            float textBottom = vertilOffset + fontMetrics.bottom;
            if(textTop > imageOffset  &&  textTop < imageOffset + bitmapRadius
                    || textBottom > imageOffset && textBottom < imageOffset + bitmapRadius){
                //
                textWith = (int)(getWidth() - bitmapRadius);
            }else {
                textWith = getWidth();
            }
            int count = paint.breakText(text,start,text.length(),true, textWith, curWith);
            canvas.drawText(text,start,start + count,0,vertilOffset,paint);
            vertilOffset += paint.getFontSpacing();
            start +=count;

        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);

    }

}
