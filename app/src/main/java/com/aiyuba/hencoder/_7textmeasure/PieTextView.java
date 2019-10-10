package com.aiyuba.hencoder._7textmeasure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.aiyuba.hencoder.util.Util;

import java.util.Random;

/**
 * Created by maoyujiao on 2019/9/29.
 */

public class PieTextView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private static float RADIUS = Util.dp2px(100);
    RectF rectF = new RectF();
    Rect rect = new Rect();
    Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    public PieTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){

        paint.setTextSize(Util.dp2px(40));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.getFontMetrics(fontMetrics);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF.set(getWidth()/2 - RADIUS,getHeight()/2 - RADIUS,getWidth()/2 + RADIUS,getWidth()/2 + RADIUS);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Util.dp2px(4));
        paint.setColor(Color.GRAY);//必须设置颜色，否则都显示为red，不知道为啥
        canvas.drawCircle(getWidth()/2,getHeight()/2, RADIUS,paint);

        paint.setColor(Color.RED);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(rectF,-45,150,false,paint);

        paint.setStrokeWidth(Util.dp2px(2));
        paint.setStyle(Paint.Style.FILL);
        paint.getTextBounds("love you",0,"love you".length(),rect);

        //采用文字的Rect
        canvas.drawText("love you",getWidth()/2,getHeight() /2 - (rect.bottom + rect.top)/2,paint);

        //采用文字的asscent desscent
        int offset = (int)(fontMetrics.descent + fontMetrics.ascent)/2;
//        canvas.drawText("love you",getWidth()/2,getHeight() /2 - offset,paint);

    }
}
