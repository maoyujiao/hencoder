package com.aiyuba.hencoder._6measure;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.aiyuba.hencoder.util.Util;

/**
 * Created by maoyujiao on 2019/9/27.
 */

public class CircleView extends View {
    private static final int RADIUS = Util.dp2px(100);
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Context context;
    private Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    private Bitmap bitmap;
    RectF savedArea = new RectF();
    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        bitmap = Util.getBitmap(context,RADIUS * 2);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        savedArea.set(getWidth()/2 - RADIUS,getHeight()/2- RADIUS,getWidth()/2 + RADIUS,getHeight()/2 + RADIUS);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int count = canvas.saveLayer(savedArea,paint);//什么临行缓冲，没这句话不行
        canvas.drawCircle(getWidth()/2,getHeight()/2,RADIUS,paint);
        paint.setXfermode(xfermode);
        canvas.drawBitmap(bitmap,getWidth()/2 - RADIUS,getHeight()/2 - RADIUS,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(count);

    }
}
