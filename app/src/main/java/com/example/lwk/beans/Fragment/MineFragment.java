package com.example.lwk.beans.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lwk.beans.R;

/**
 * Created by LWK on 2016/11/26.
 */
public class MineFragment extends BaseFragment {
    public static final String TAG = MineFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.mine_main_fragment,container,false);

        return layout;
    }
}
