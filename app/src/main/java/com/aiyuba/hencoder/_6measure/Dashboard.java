package com.aiyuba.hencoder._6measure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.aiyuba.hencoder.util.Util;

/**
 * Created by maoyujiao on 2019/9/27.
 */

public class Dashboard extends View {
    private static final int ANGLE = 120;
    private RectF rectF;
    private static final int Radius = Util.dp2px(70);
    private static final int COUNT = 20;
    private Paint paint;
    private static int index = 4;
    private PathDashPathEffect pathDashPathEffect;
    private Path dash = new Path();

    public Dashboard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        rectF = new RectF();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF.set(getWidth()/2 - Radius ,getHeight()/2 - Radius,getWidth()/2 + Radius,getHeight()/2 + Radius);
        dash.addRect(0,0,Util.dp2px(2),Util.dp2px(10), Path.Direction.CW);
        Path arch = new Path();
        arch.addArc(rectF,90 + ANGLE / 2, 360 - ANGLE);
        PathMeasure pathMeasure = new PathMeasure(arch,false);
        pathDashPathEffect = new PathDashPathEffect(dash,(pathMeasure.getLength() - Util.dp2px(2))/COUNT, 0,PathDashPathEffect.Style.ROTATE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(rectF,90 + ANGLE / 2, 360 - ANGLE,false,paint);
        paint.setPathEffect(pathDashPathEffect);
        canvas.drawArc(rectF,90 + ANGLE / 2, 360 - ANGLE,false,paint);
        canvas.drawLine(getWidth()/2,getHeight()/2,(float)(Radius* Math.cos(Math.toRadians(getAngleFromMark(index))))+getWidth()/2,(float) (Radius* Math.sin(Math.toRadians(getAngleFromMark(index))))+getHeight()/2,paint);
    }

    private int getAngleFromMark(int index){
        return 90 + ANGLE/2 + index * (360-ANGLE) /20;
    }
}
