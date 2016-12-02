package com.example.lwk.beans.Fragment;


import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by LWK on 2016/11/26.
 */
public class BaseFragment extends Fragment {

    protected View layout;


    public BaseFragment (){}

    public void BaseFragment(View layout) {
        this.layout = layout;
    }
}
