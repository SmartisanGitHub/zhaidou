package com.example.lwk.beans.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lwk.beans.R;
import com.example.lwk.beans.WanActivity.DIYdapeiFragment;
import com.example.lwk.beans.WanActivity.SoftPhotosfragment;
import com.example.lwk.beans.WanActivity.ZhinanFragment;

/**
 * Created by LWK on 2016/11/26.
 */
public class MagicFragment extends com.example.lwk.beans.Fragment.BaseFragment implements View.OnClickListener {


    public static final String TAG = MagicFragment.class.getSimpleName();
    private ImageView mGoKefu;
    private ImageView mDiy;
    private ImageView mGaiZaoanli;
    private ImageView mRuanZtk;
    private ImageView mSheCaiketang;
    private ImageView mZhiNan;
    private ImageView mZaiXiansheji;
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
        Intent intent =new Intent(getActivity(), ZhinanFragment.class) ;
        Intent intent2 = new Intent(getActivity(), SoftPhotosfragment.class);
        switch (v.getId()) {
            case R.id.magic_ruanzhuangzhinan:
                intent.putExtra("name","http://m.zhaidou.com/decorate/guide?source=android");
                startActivity(intent);
                break;
            case R.id.magic_diy_dapei:
                Intent intent1 = new Intent(getActivity(), DIYdapeiFragment.class);
                startActivity(intent1);
                break;
            case R.id.magic_gaizaoanli:
                intent.putExtra("name","http://m.zhaidou.com/case");
                startActivity(intent);
                break;
            case R.id.magic_ruanzhuangtuku:
                Toast.makeText(getActivity(), "软件图库", Toast.LENGTH_SHORT).show();
                startActivity(intent2);
                break;
            case R.id.magic_shecaiketang:
                Toast.makeText(getActivity(), "色彩课堂", Toast.LENGTH_SHORT).show();
                intent2.putExtra("name","http://portal-web.zhaidou.com/zd/getPosts.action?plug=006&pageSize=10&pageNo=1");
                intent2.putExtra("stra","color");
                startActivity(intent2);
                break;
            case R.id.magic_zhaixiansheji:
                intent.putExtra("name","http://www.zhaidou.com/design?source=android");
                startActivity(intent);
                break;
            case R.id.gotokefu:
                intent.putExtra("name","http://m.zhaidou.com/service");
                startActivity(intent);
                break;
        }
    }


}