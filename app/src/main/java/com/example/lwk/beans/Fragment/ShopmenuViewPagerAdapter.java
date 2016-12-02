package com.example.lwk.beans.Fragment;

import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by LWK on 2016/12/2.
 */
public class ShopmenuViewPagerAdapter extends PagerAdapter {
    private List<String > titles;
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
