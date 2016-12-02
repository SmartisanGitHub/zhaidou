package com.example.lwk.beans.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.example.lwk.beans.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;

/**
 * Created by Administrator on 2016/11/28.
 */
public class MaoPullToRefreshRecyclerView extends PullToRefreshBase<RecyclerView> {

    private boolean canload;
    private int mLastChildCount =0;

    public MaoPullToRefreshRecyclerView(Context context) {
        super(context);
    }

    public MaoPullToRefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MaoPullToRefreshRecyclerView(Context context, Mode mode) {
        super(context, mode);
    }

    public MaoPullToRefreshRecyclerView(Context context, Mode mode, AnimationStyle animStyle) {
        super(context, mode, animStyle);
    }

    @Override
    public Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    @Override
    protected RecyclerView createRefreshableView(Context context, AttributeSet attrs) {
        RecyclerView recyclerView = new RecyclerView(context, attrs);
        recyclerView.setId(R.id.recycler_id);
        return recyclerView;
    }

    @Override
    protected boolean isReadyForPullEnd() {
        RecyclerView refreshableView = getRefreshableView();

        //获取当前数据总数
        int childCount = refreshableView.getAdapter().getItemCount();
        //int childCount = refreshableView.getAdapter().getItemCount();
        canload = childCount > mLastChildCount ? false : true;
        mLastChildCount = childCount;

        //获取RecyclerView的height
        int refreshableViewHeight = refreshableView.getHeight();
        //获取底边距
        int paddingBottom = refreshableView.getPaddingBottom();
//获取最后一个child
        View childAtEnd = refreshableView.getChildAt(refreshableView.getChildCount() - 1);
        if (childAtEnd == null) {
            return false;
        }
        // 获取最后一个item距离RecyclerView顶部的距离
        int childAtEndBottom = childAtEnd.getBottom();
        //获取最后一个item的底部外边距
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAtEnd.getLayoutParams();
        int bottomMargin = layoutParams.bottomMargin;
        return (refreshableViewHeight == paddingBottom + childAtEndBottom + bottomMargin) && canload;
    }

    @Override
    protected boolean isReadyForPullStart() {
        RecyclerView recyclerView = getRefreshableView();
        int paddingTop = recyclerView.getPaddingTop();
        View childAtzero = recyclerView.getChildAt(0);
        if (childAtzero == null) {
            return false;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAtzero.getLayoutParams();
        int topMargin = layoutParams.topMargin;
        int ToptoParent = childAtzero.getTop();

        return ToptoParent == topMargin + paddingTop;
    }

    @Override
    protected LoadingLayout createLoadingLayout(Context context, Mode mode, TypedArray attrs) {

        return new FrameAnimation(context, mode, getPullToRefreshScrollDirection(), attrs);
    }
}
