
package com.example.lwk.beans.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lwk.beans.LWKAdapter.ShopRecyclerAdapter;
import com.example.lwk.beans.LWKModel.ShopAll;
import com.example.lwk.beans.LWKModel.ShopButtom;
import com.example.lwk.beans.LWKModel.ShopMiddle;
import com.example.lwk.beans.R;
import com.example.lwk.beans.url;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by LWK on 2016/11/28.
 */

public class ShopFragment extends com.example.lwk.beans.Fragment.BaseFragment implements View.OnClickListener {

    public static final String TAG = ShopFragment.class.getSimpleName();

    private TextView title;
    private ImageView icon;
    private TextView title2;
    private TextView title3;
    private TextView title4;
    private ImageView icon2;
    private ImageView icon3;
    private ImageView icon4;
    private RecyclerView mRecycler;
    private ShopRecyclerAdapter adapter;
    private List<ShopAll> listAll = new ArrayList<>();

    private FloatingActionButton floatbutton;
    private ImageView shopmenu;
    private EditText shopEdit;
    private ImageView shopChat;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.shop_main_fragment, container, false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();

        getImagesId();

    }

    private void getImagesId() {


        RequestParams params = new RequestParams(url.SHOP_HEADER);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ShopMiddle shopMiddle = gson.fromJson(result,ShopMiddle.class);
                for (int i = 0; i < shopMiddle.getData().get(0).getProgramPOList().size(); i++) {
                    ShopAll shopAll0 = new ShopAll();
                    shopAll0.setPictureUrl(shopMiddle.getData().get(0).getProgramPOList().get(i).getPictureUrl());

                    shopAll0.setType(0);
                    listAll.add(shopAll0);

                }
                x.image().bind(icon,shopMiddle.getData().get(2).getProgramPOList().get(0).getPictureUrl());
                x.image().bind(icon2,shopMiddle.getData().get(2).getProgramPOList().get(1).getPictureUrl());
                x.image().bind(icon3,shopMiddle.getData().get(2).getProgramPOList().get(2).getPictureUrl());
                x.image().bind(icon4,shopMiddle.getData().get(2).getProgramPOList().get(3).getPictureUrl());
                title.setText(shopMiddle.getData().get(2).getProgramPOList().get(0).getName());
                title2.setText(shopMiddle.getData().get(2).getProgramPOList().get(1).getName());
                title3.setText(shopMiddle.getData().get(2).getProgramPOList().get(2).getName());
                title4.setText(shopMiddle.getData().get(2).getProgramPOList().get(3).getName());



                setupView1();

                Log.e(TAG, "success: 1111111111111" );
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });



    }


    private void setupView1() {
        RequestParams params = new RequestParams(url.SHOP_HEADER1);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ShopMiddle shopMiddles = gson.fromJson(result, ShopMiddle.class);
                for (int i = 0; i < shopMiddles.getData().get(1).getProgramPOList().size(); i++) {
                    ShopAll shopAll1 = new ShopAll();
                    shopAll1.setPictureUrl(shopMiddles.getData().get(1).getProgramPOList().get(i).getPictureUrl());

                    shopAll1.setType(1);

                    listAll.add(shopAll1);
                }
                setupView2();




            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void setupView2() {
        RequestParams params = new RequestParams(url.SHOP_BUTTOM);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();
                ShopButtom shopButtom = gson.fromJson(result, ShopButtom.class);
                for (int i = 0; i < shopButtom.getData().getThemeList().size(); i++) {
                    ShopAll shopAll2 = new ShopAll();
                    shopAll2.setMainPic(shopButtom.getData().getThemeList().get(i).getMainPic());
                    shopAll2.setActivityName(shopButtom.getData().getThemeList().get(i).getActivityName());
                    shopAll2.setType(2);

                    listAll.add(shopAll2);
                 }



                adapter.updateRes(listAll);


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }



    private void initView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.shop_header, null);

        floatbutton = (FloatingActionButton) layout.findViewById(R.id.shop_main_fragment_float);


        floatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecycler.scrollToPosition(0);

            }
        });
        mRecycler = (RecyclerView) layout.findViewById(R.id.shop_main_fragment_Recycler);
        shopmenu = (ImageView)layout.findViewById(R.id.shop_menu);
        shopmenu.setOnClickListener(this);
        shopEdit = (EditText)layout. findViewById(R.id.shop_edit);
        shopEdit.setOnClickListener(this);
        shopChat = (ImageView) layout.findViewById(R.id.shop_chat);
        shopChat.setOnClickListener(this);
        title = (TextView) inflate.findViewById(R.id.shop_header_lv_four_title1);
        title2 = (TextView) inflate.findViewById(R.id.shop_header_lv_four_title2);
        title3 = (TextView) inflate.findViewById(R.id.shop_header_lv_four_title3);
        title4 = (TextView) inflate.findViewById(R.id.shop_header_lv_four_title4);
        icon = (ImageView) inflate.findViewById(R.id.shop_header_lv_four_image1);
        icon2 = (ImageView) inflate.findViewById(R.id.shop_header_lv_four_image2);
        icon3 = (ImageView) inflate.findViewById(R.id.shop_header_lv_four_image3);
        icon4= (ImageView) inflate.findViewById(R.id.shop_header_lv_four_image4);
        //为RecyclerView设置布局管理器，
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(layoutManager);
        adapter = new ShopRecyclerAdapter(getActivity());
        mRecycler.setAdapter(adapter);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.shop_menu :
                Intent intent = new Intent(getContext(),Shopmenu.class);
                startActivity(intent);
            break;
            case R.id.shop_edit:
            break;
            case R.id.shop_chat:
            break;
        }
    }
}

