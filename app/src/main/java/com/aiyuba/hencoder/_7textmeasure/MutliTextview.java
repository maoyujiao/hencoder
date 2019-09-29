package com.aiyuba.hencoder._7textmeasure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.aiyuba.hencoder.util.Util;

/**
 * Created by maoyujiao on 2019/9/29.
 */

public class MutliTextview extends View {
    StaticLayout staticLayout ;
    TextPaint textPaint = new TextPaint();
    public MutliTextview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        textPaint.setTextSize(Util.dp2px(20));
        textPaint.setColor(Color.GRAY);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        staticLayout = new StaticLayout("我和我的祖国我和我的祖国我和我的祖国我和我的祖国我和我的祖国我和我的祖国我和我的祖国我和我的祖国我和我的祖国我和我的祖国",
                textPaint,getWidth(),Layout.Alignment.ALIGN_NORMAL,1,0,false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        staticLayout.draw(canvas);
    }
}
