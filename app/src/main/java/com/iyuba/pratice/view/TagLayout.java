package com.iyuba.pratice.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by maoyujiao on 2019/11/18.
 */

public class TagLayout extends ViewGroup {
    private List<Rect> bounds = new ArrayList<>();
    private MarginLayoutParams marginLayoutParams;

    public TagLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //自定义layout不需要调用suer.onMeasure(),但别忘记最后调用setMeasuredDimension()，来保存该layout的大小
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //fix 第一次使用的全局变量useWith，useHeight，第一个子view但发现会显示有问题，不是左上角而是显示在中间的一个位置
        //注意，onMeasure方式会每16ms调用一次，所以如果用全局的话，初始化第一行的useWith，useHeight就不是0，就会有问题。
        //注意按此全局逻辑则useheight应该会一直增加的，但实际后面刷新几次后该view位置就不在变化了，猜测可能后面就不会调用RequestLayout重新测量布局了，后面在验证吧。
        int useWith = 0;
        int useHeight = 0;
        int maxHeight = 0;
        int with = MeasureSpec.getSize(widthMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
            if (useWith == 0) {
                useHeight += marginLayoutParams.topMargin;
            }
            useWith += marginLayoutParams.leftMargin;
            //内部会自己算child withMeasureSpeci,heghtMeasureSpci
            //当withUsed >= with时，不会在测量了，即下一个子view的measureWith为0,故此处 withUsed为0。
            measureChild(view, widthMeasureSpec, heightMeasureSpec);
            if (useWith + view.getMeasuredWidth() + marginLayoutParams.rightMargin > with) {
                useWith = 0;
                useHeight += maxHeight + marginLayoutParams.bottomMargin; //注意使用getMeasureHeight,使用getHeight会是0
                maxHeight = 0;
            }
            maxHeight = Math.max(maxHeight, view.getMeasuredHeight());
            //记录下子view的位置，以便在onlayout方式，调用子view的layout(left,top,right,bottom)
            //注意此处list的添加方式
            Rect childBound;
            if (bounds.size() <= i) {
                childBound = new Rect();
                bounds.add(childBound);
            } else {
                childBound = bounds.get(i);
            }
            childBound.set(new Rect(useWith != 0 ? useWith : useWith + marginLayoutParams.leftMargin,
                    useHeight,
                    useWith + view.getMeasuredWidth(),
                    useHeight + view.getMeasuredHeight()));
            useWith += view.getMeasuredWidth() + marginLayoutParams.rightMargin;
        }
        setMeasuredDimension(with, useHeight);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            view.layout(bounds.get(i).left,
                    bounds.get(i).top,
                    bounds.get(i).right,
                    bounds.get(i).bottom);
        }

    }

    /**
     * 当view.getLayoutParam,强转为MarginLayoutParam时，需要重写该方法
     * @param attrs
     * @return
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
