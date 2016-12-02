package com.example.lwk.beans.Fragment;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by LWK on 2016/12/1.
 */
 public class TeachBehavior extends CoordinatorLayout.Behavior {

    public TeachBehavior() {
    }

    public TeachBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 判定是否关注 嵌套滚动事件，true代表关注，false 代表不关注
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    /**
     * 与onStartNestedScroll 配对使用的，关注滚动事件，在滚动的时候做一些事情
     */
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);


    }
}
