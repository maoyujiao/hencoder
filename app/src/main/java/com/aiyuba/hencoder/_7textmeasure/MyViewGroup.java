package com.aiyuba.hencoder._7textmeasure;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by maoyujiao on 2019/10/10.
 */

public class MyViewGroup extends ViewGroup {
    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        getParent().requestDisallowInterceptTouchEvent(true);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
