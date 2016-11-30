package com.example.lwk.beans;

import android.animation.Animator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

/**
 * Created by Administrator on 2016/11/29.
 */
public class ZhaiDouBehavior extends CoordinatorLayout.Behavior {
    private static final String TAG = ZhaiDouBehavior.class.getSimpleName();
    private int Y_height = 0;
    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();
    public ZhaiDouBehavior() {
    }

    public ZhaiDouBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        ViewCompat.animate(child).scaleX(0).scaleY(0).start();
        return true;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);


//        Log.e(TAG, "onNestedPreScroll: " + dy);
//        Log.e(TAG, "onNestedPreScroll_height: " + Y_height);
        Y_height += dy;
        if (Y_height < 400) {
            if(Y_height<0){
                Y_height=0;
//                Log.e(TAG, "onNestedPreScroll_height: " + Y_height);
            }
            ViewCompat.animate(child).scaleX(0).scaleY(0).start();
        } else {
            ViewCompat.animate(child).scaleX(1).scaleY(1).start();
        }

    }

/*    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {

        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

        Y_height += dyConsumed;
        Log.e(TAG, "onNestedScroll_dy: " + dyConsumed);
        Log.e(TAG, "onNestedScroll_height: " + Y_height);
        if (Y_height < 400) {
            ViewCompat.animate(child).scaleX(0).scaleY(0).start();
        } else {
            ViewCompat.animate(child).scaleX(1).scaleY(1).start();
        }
    }*/


}
