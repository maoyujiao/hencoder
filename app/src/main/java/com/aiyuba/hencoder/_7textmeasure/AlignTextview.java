package com.aiyuba.hencoder._7textmeasure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.aiyuba.hencoder.util.Util;

/**
 * Created by maoyujiao on 2019/9/29.
 */

public class AlignTextview extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Rect rect = new Rect();
    Rect rect1 = new Rect();

    public AlignTextview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setTextSize(Util.dp2px(80));
        paint.getTextBounds("ababbab",0, "ababbab".length() ,rect);
        canvas.drawText("ababbab",-rect.left,80,paint);

        paint.setTextSize(Util.dp2px(10));
        paint.getTextBounds("ababbab",0, "ababbab".length() ,rect1);
        canvas.drawText("ababbab",-rect1.left,100+paint.getFontSpacing(),paint);

    }
}
