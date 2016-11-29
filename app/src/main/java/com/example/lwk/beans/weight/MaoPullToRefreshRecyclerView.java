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
        int height = refreshableView.getHeight();
        int paddingBottom = refreshableView.getPaddingBottom();
        int childCount = refreshableView.getChildCount();
        View childAt = refreshableView.getChildAt(childCount - 1);
        if (childAt==null) {
            return false;
        }
        int bottom = childAt.getBottom();
        RecyclerView.LayoutParams layoutParams= (RecyclerView.LayoutParams) childAt.getLayoutParams();
        int bottomMargin = layoutParams.bottomMargin;
        return height==paddingBottom+bottom+bottomMargin;
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

        return new FrameAnimation(context, mode,getPullToRefreshScrollDirection(),attrs);
    }
}
