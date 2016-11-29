package com.example.lwk.beans.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lwk.beans.R;
import com.example.lwk.beans.WanActivity.ZaiXianfragment;
import com.example.lwk.beans.WanActivity.ZhinanFragment;

/**
 * Created by LWK on 2016/11/26.
 */
public class MagicFragment extends BaseFragment implements View.OnClickListener {


    public static final String TAG = MagicFragment.class.getSimpleName();
    private ImageView mGoKefu;
    private ImageView mDiy;
    private ImageView mGaiZaoanli;
    private ImageView mRuanZtk;
    private ImageView mSheCaiketang;
    private ImageView mZhiNan;
    private ImageView mZaiXiansheji;
    private Fragment mFragmentShow;
    private View layout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.magic_main_fragment, container, false);

        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {

        mGoKefu = (ImageView) layout.findViewById(R.id.gotokefu);
        mGoKefu.setOnClickListener(this);
        mDiy = (ImageView) layout.findViewById(R.id.magic_diy_dapei);
        mGaiZaoanli = (ImageView) layout.findViewById(R.id.magic_gaizaoanli);
        mRuanZtk = (ImageView) layout.findViewById(R.id.magic_ruanzhuangtuku);
        mSheCaiketang = (ImageView) layout.findViewById(R.id.magic_shecaiketang);
        mZhiNan = (ImageView) layout.findViewById(R.id.magic_ruanzhuangzhinan);
        mZaiXiansheji = (ImageView) layout.findViewById(R.id.magic_zhaixiansheji);
        mZaiXiansheji.setOnClickListener(this);
        mSheCaiketang.setOnClickListener(this);
        mDiy.setOnClickListener(this);
        mGaiZaoanli.setOnClickListener(this);
        mRuanZtk.setOnClickListener(this);
        mZhiNan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mFragmentShow = new MagicFragment();
        transaction.hide(mFragmentShow);
        switch (v.getId()) {
            case R.id.magic_ruanzhuangzhinan:
                mFragmentShow =new ZhinanFragment();
                break;
            case R.id.magic_diy_dapei:
                break;
            case R.id.magic_gaizaoanli:
                break;
            case R.id.magic_ruanzhuangtuku:
                break;
            case R.id.magic_shecaiketang:
                break;
            case R.id.magic_zhaixiansheji:
                mFragmentShow =new ZaiXianfragment();
                break;
            case R.id.gotokefu:
                break;
        }
        transaction.show(mFragmentShow);
        transaction.add(R.id.beans_main_fragmentshow,mFragmentShow);
        transaction.commit();
    }


}