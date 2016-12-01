package com.example.lwk.beans.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lwk.beans.LWKAdapter.HomeAdapter;
import com.example.lwk.beans.LWKModel.HomeHeaderList;
import com.example.lwk.beans.LWKModel.HomeList;
import com.example.lwk.beans.LWKModel.HomeitemList;
import com.example.lwk.beans.R;
import com.example.lwk.beans.ZhaiDouBehavior;
import com.example.lwk.beans.weight.MaoPullToRefreshRecyclerView;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LWK on 2016/11/26.
 */
public class HomeFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener, View.OnClickListener, HomeAdapter.SendImageMessage {

    public static final String TAG = HomeFragment.class.getSimpleName();
    private MaoPullToRefreshRecyclerView mRecycler;
    private int PAGE = 1;
    private String ITEM_URL="http://m.zhaidou.com/api/decorate/getChangeCases.action?v=3.6&version=1.0.0&clientType=WAP&businessType=01&pageSize=10";
    private String HEADER_URL="http://m.zhaidou.com/api/index/getBoardContent.action?v=3.6&version=1.0.0&clientType=WAP&businessType=01&boardCodes=05%2C06&_=";
    private long time;
    private RecyclerView refreshableView;
    private HomeAdapter adapter;
    private List<HomeList>data=new ArrayList<>();
    private FloatingActionButton mFloatButton;
    private ProgressBar mProgressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.home_main_fragment,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initHeader();
        setupView(State.DOWN);
        adapter.setListener(this);
    }

    private void initHeader() {
        RequestParams params=new RequestParams(HEADER_URL+time);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "header_onSuccess: "+result );
                Gson gson=new Gson();
                HomeHeaderList list = gson.fromJson(result, HomeHeaderList.class);
                HomeList homeList = new HomeList();
                homeList.setHea_Image(list.getData().get(0).getProgramPOList().get(0).getPcImage());

                homeList.setHea_Image0(list.getData().get(1).getProgramPOList().get(0).getPictureUrl());
                Log.e(TAG, "onSuccess: "+list.getData().get(1).getProgramPOList().get(0).getPictureUrl());
                homeList.setHea_Image1(list.getData().get(1).getProgramPOList().get(1).getPictureUrl());
                Log.e(TAG, "onSuccess: "+list.getData().get(1).getProgramPOList().get(1).getPictureUrl());
                homeList.setHea_Image2(list.getData().get(1).getProgramPOList().get(2).getPictureUrl());
                data.add(homeList);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "header _onError: " );
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    private void setupView(final State state) {
        switch (state) {
            case UP:
                if (PAGE<=9){PAGE++;
                }else {
                    PAGE=10;
                    Toast.makeText(getActivity(), "已经到底了", Toast.LENGTH_SHORT).show();
                }
                break;
            case DOWN:
                PAGE = 1;
                break;
        }

        RequestParams params = new RequestParams(ITEM_URL +"&pageNo="+PAGE+"&_"+time);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess: "+result );
                Gson gson=new Gson();
                HomeitemList homeitemList = gson.fromJson(result, HomeitemList.class);
                for (int i = 0; i < homeitemList.getData().getFreeClassicsCasePOs().size(); i++) {
                    HomeList model=new HomeList();
                    model.setItem_Image(homeitemList.getData().getFreeClassicsCasePOs().get(i).getMainPic());
                    model.setCaseName(homeitemList.getData().getFreeClassicsCasePOs().get(i).getCaseName());
                    model.setMainDesc(homeitemList.getData().getFreeClassicsCasePOs().get(i).getMainDesc());
                    model.setComment(homeitemList.getData().getFreeClassicsCasePOs().get(i).getCommentCount()+"");
                    data.add(model);
                    Log.e(TAG, "onSuccess: "+data.size() );
                }
                switch (state) {
                    case DOWN:
                        adapter.updateRes(data);
                        break;
                    case UP:
                        adapter.addRes(data);
                        break;
                }
                mRecycler.onRefreshComplete();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: "+ex.getMessage() );
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled: " );
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished: " );
            }
        });

    }

    private void initView() {
        mFloatButton = (FloatingActionButton)layout.findViewById(R.id.home_FloatingActionButton);
        mFloatButton.setOnClickListener(this);
        mProgressBar = ((ProgressBar) layout.findViewById(R.id.home_prigressbar));

        mRecycler = ((MaoPullToRefreshRecyclerView) layout.findViewById(R.id.home_RecyclerView));
        mRecycler.setOnRefreshListener(this);
        mRecycler.setMode(PullToRefreshBase.Mode.PULL_FROM_END);

        refreshableView = mRecycler.getRefreshableView();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        refreshableView.setLayoutManager(layoutManager);

        adapter = new HomeAdapter(getActivity());
        refreshableView.setAdapter(adapter);

        Date dt= new Date();
        time= dt.getTime();
    }

    @Override
    public void onClick(View v) {
        refreshableView.scrollToPosition(0);
        ZhaiDouBehavior.Y_height=0;
    }

    @Override
    public void onRefresh(PullToRefreshBase refreshView) {
        setupView(State.DOWN);
    }

    @Override
    public void sendload(Boolean load) {
        if (load) {
            mProgressBar.setVisibility(ProgressBar.GONE);
        }
    }


    enum State {
        DOWN, UP
    }


}
