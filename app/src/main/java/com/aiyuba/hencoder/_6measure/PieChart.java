package com.aiyuba.hencoder._6measure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.aiyuba.hencoder.util.Util;

/**
 * Created by maoyujiao on 2019/9/27.
 */

public class PieChart extends View {
    private static final int[] ANGLES = new int[]{60,120,80,100};
    private static final String[] COLORS = new String[]{"#FFB78193","#FF3F51B5","#FFFFDC40","#FF40FFAC"};
    private static final int RADIUS = Util.dp2px(100);
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    RectF rectF = new RectF();


    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF.set(getWidth()/2 - RADIUS,getHeight()/2 - RADIUS,getWidth()/2 + RADIUS,getHeight()/2 + RADIUS);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int curAngle = 0;
        for(int i = 0;i<ANGLES.length;i++) {
            paint.setColor(Color.parseColor(COLORS[i]));
            canvas.save();
            if(i == 2){
                canvas.translate((float) (Util.dp2px(10) * Math.cos(Math.toRadians(curAngle + ANGLES[i] / 2))),
                        (float) (Util.dp2px(10) * Math.sin(Math.toRadians(curAngle + ANGLES[i] / 2))));
            }
            canvas.drawArc(rectF, curAngle,ANGLES[i],true,paint);
            curAngle += ANGLES[i];
            canvas.restore(); //画布平移后需要恢复
        }

    }
}
