package com.aiyuba.hencoder._7textmeasure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.aiyuba.hencoder.util.Util;

/**
 * Created by maoyujiao on 2019/11/13.
 */

public class BarView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float LINEWITH = Util.dp2px(1);
    private float MARGIN = Util.dp2px(40);
    private float TEXTSIZE = Util.dp2px(12);
    float  mLeftBottomX,mLeftBottomY;
    float  mLeftTopX,mLeftTopY;
    private float mGapVertail;
    private float mGapHorizonal;
    private int mGapVertailNum = 5;
    private String[] indicates = {"100","80","60","40","20","0"};
    private String[] indicatesBottom = {"单词","语法","听力","阅读","口语","写作"};
    private String[] colors = {"#FF71B8D9","#FF4884AB","#FF93B5F4","#FF729AC2","#FFCDCFD1","#FF6257A2","#FFA878CC"};
    private float[] progresses = {0.2f,0.4f,0.6f,0.8f,0.2f,1.0f};
    private Rect rect = new Rect();

    public BarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setTextSize(TEXTSIZE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mLeftBottomX =  (int)MARGIN;
        mLeftBottomY = getHeight() - MARGIN;
        mLeftTopX = (int)MARGIN;
        mLeftTopY = (int)MARGIN;
        mGapVertail = (getHeight()- MARGIN * 2 ) / mGapVertailNum;
        mGapHorizonal = (getWidth() - MARGIN * 2 ) / (indicatesBottom.length * 3); //分为3 *legth份，间隙为1份，方框占2份

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(LINEWITH);
        paint.setTextAlign(Paint.Align.LEFT);
        //画左边的竖线
        canvas.drawLine(mLeftBottomX,mLeftBottomY,mLeftTopX,mLeftTopY,paint);
        //画水平线
        for(int i = 0;i< mGapVertailNum + 1;i++){
            canvas.drawLine(mLeftBottomX,mLeftTopY + i * mGapVertail,
                    getWidth() - MARGIN,
                    mLeftTopY + i * mGapVertail,paint);
            paint.getTextBounds(indicates[i],0,indicates[i].length(),rect);
            canvas.drawText(indicates[i],MARGIN - (rect.right + rect.left)* 1.2f,
                    mLeftTopY + i * mGapVertail - (rect.top + rect.bottom)/2,paint);
        }

        //画矩形和写文字
        for(int i = 0;i< indicatesBottom.length; i++){
            paint.setColor(Color.parseColor(colors[i]));
            paint.setStyle(Paint.Style.FILL);

            canvas.drawRect(MARGIN + mGapHorizonal + i * 3 * mGapHorizonal,
                    mLeftBottomY - progresses[i] * (getHeight() - MARGIN * 2),
                    MARGIN + mGapHorizonal + i * 3 * mGapHorizonal + 2 * mGapHorizonal,
                    mLeftBottomY,paint);
            paint.setColor(Color.BLACK);
            paint.getTextBounds(indicatesBottom[i],0,indicatesBottom[i].length(),rect);
            paint.setTextAlign(Paint.Align.CENTER);

            canvas.drawText(indicatesBottom[i],
                    MARGIN + mGapHorizonal + i * 3 * mGapHorizonal + mGapHorizonal,
                    mLeftBottomY + rect.bottom - rect.top,paint);
        }

    }


    /**
     * 自定义view绘制顺序
     * @param canvas
     */
    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }
}
