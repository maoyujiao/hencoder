package com.iyuba.pratice.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.aiyuba.hencoder.util.Util;

/**
 * Created by maoyujiao on 2019/11/15.
 */

public class MulityTextAndBitmap extends View {
    private Paint paint;
    private Path path;
    private Paint.FontMetrics fontMetrics;
    private float RADIUS = Util.dp2px(50);
    private float TEXTSIZE = Util.dp2px(15);
    private float MAGRIN = Util.dp2px(30);
    private Context context;
    private float measuredY = 0;
    private int drawTextCount = 0;
    private int temp;
    private float[] measureWith;
    private String textStr = "我要加油，争取早日成为大牛我要加油，争取早日成为大牛我要加油，争取早日成为大牛我要加油，争取早日成为大牛我要加油，争取早日成为大牛我要加油，争取早日成为大牛";
    public MulityTextAndBitmap(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

    }
    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(TEXTSIZE);
        fontMetrics = paint.getFontMetrics();
        path = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.save();
        path.addCircle(MAGRIN + RADIUS,RADIUS,RADIUS, Path.Direction.CW);
//        canvas.clipPath(path);
//        canvas.clipRect(new RectF(0,0, RADIUS * 2,RADIUS * 2));
        canvas.drawCircle(RADIUS,RADIUS,RADIUS,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(Util.getBitmap(context,(int)RADIUS),RADIUS,RADIUS,paint);
        paint.setXfermode(null);
//        canvas.restore();

        if(measuredY + fontMetrics.bottom - fontMetrics.top < MAGRIN + RADIUS ){
            temp = paint.breakText(textStr,drawTextCount,textStr.length(),true,getWidth(),measureWith);
        }
        canvas.drawText(textStr,drawTextCount,temp,0,40,paint);
    }
}
