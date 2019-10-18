package com.aiyuba.hencoder._6measure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.aiyuba.hencoder.util.Util;

/**
 * Created by maoyujiao on 2019/10/11.
 */

public class SaveLayerLearn extends View {

    private float OFFSET = 100;
    private float measureWidth ;
    private float measureHeight ;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public SaveLayerLearn(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //设置画笔的颜色
        mPaint.setColor(Color.RED);
        //设置画笔的样式
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        measureHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.CYAN);
        int saveCount = canvas.saveLayer(OFFSET,OFFSET,measureWidth - OFFSET,measureHeight - OFFSET,mPaint, Canvas.ALL_SAVE_FLAG);
        canvas.drawColor(Color.parseColor("#f0ffcc"));
        int saveCount1 = canvas.saveLayer(OFFSET*2,OFFSET*2,measureWidth - OFFSET*2,measureHeight - OFFSET*2,mPaint, Canvas.ALL_SAVE_FLAG);
        canvas.drawColor(Color.parseColor("#f0cccc"));
        //saveCount返回到saveCount之前的layer，并把图像保存在当前的layer中
        canvas.restoreToCount(saveCount1);
        canvas.drawCircle(300, 300, 380, mPaint);
        canvas.restoreToCount(saveCount);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(300, 300, 300, mPaint);

    }
}
