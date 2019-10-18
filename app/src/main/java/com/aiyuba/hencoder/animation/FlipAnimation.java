package com.aiyuba.hencoder.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;

import okhttp3.Interceptor;

/**
 * Created by maoyujiao on 2019/10/10.
 */

public class FlipAnimation extends View {
    ViewDragHelper dragHelper;
    View view;
    public FlipAnimation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        ClipData.newPlainText();
//        view.animate().translationX().start();
//        view.startAnimation();
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(,,);
//        //多个属性动画，Animationset  和 PropertyValuesHolder
//        AnimatorSet set = new AnimatorSet();
//        AnimationSet
//        set.playSequentially(objectAnimator,objectAnimator);
//        set.playTogether();
//        set.start();
//        ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(,);
//        ObjectAnimator objectAnimator2 = ObjectAnimator.ofObject(,);
//
//        //同一属性的不同阶段 KeyFrame
//        //Interpolator
//
//        Keyframe keyframe = Keyframe.ofFloat(,) //时间 完成值
//        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe(,);
//        ViewPropertyAnimator;
//        //可用于只需要渐变的属性值，甚至界面都不需要刷新，提供一个渐变值
//        ValueAnimator;
//        Animator.AnimatorListener animatorListener;
//        objectAnimator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });

    }

    @Override
    public void computeScroll() {
        super.computeScroll();
//        ViewCompat.postInvalidateOnAnimation(this);
//        dragHelper.continueSettling();
    }
}
