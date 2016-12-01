package com.example.lwk.beans.WanActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lwk.beans.R;
import com.example.lwk.beans.WanModel.ColorModel;
import com.example.lwk.beans.WanModel.SofPhomoel;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

public class SoftPhotosfragment extends AppCompatActivity implements SoftListAdapter.OnItemClick ,SoftListAdapter2.OnItemClick{
    private String URL="http://portal-web.zhaidou.com/decorate/getSoftDecorateStyles.action";
    private ListView mPhotosListview;
    private SoftListAdapter adapter;
    private String TAG =SoftPhotosfragment.class.getCanonicalName();
    private Intent intent;
    private SoftListAdapter2 adapter2;
    private TextView mText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent itent = getIntent();
        String stra = itent.getStringExtra("stra");

        setContentView(R.layout.activity_soft_photosfragment);
        if ("color".equals(stra)){
            URL =itent.getStringExtra("name");
            initView2();
            setupView2();
        }else {
            initView();
            setupView();
        }

    }

    private void setupView2() {
        OkHttpUtils.get()
                .url(URL)
                .build()
                .execute(new Callback<ColorModel>() {
                    @Override
                    public ColorModel parseNetworkResponse(Response response, int id) throws Exception {
                        Log.e(TAG, "parseNetworkResponse: 00000");
                        String result = response.body().string();
                        Gson gson = new Gson();
                        return gson.fromJson(result, ColorModel.class);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: 111111");
                    }

                    @Override
                    public void onResponse(ColorModel response, int id) {
                        adapter2.updateRes(response.getData().getPostsPOList());
                        Log.e(TAG, "onResponse: 222222" );
                    }
                });

    }

    private void initView2() {
        mPhotosListview = (ListView) findViewById(R.id.softphotos);
        mText = (TextView) findViewById(R.id.title);
        mText.setText("色彩课堂");
        adapter2 = new SoftListAdapter2(this, null);
        adapter2.setOnIteemClick(this);
        mPhotosListview.setAdapter(adapter2);
    }


    private void initView() {
        mPhotosListview = (ListView) findViewById(R.id.softphotos);
        adapter = new SoftListAdapter(this, null);
        adapter.setOnIteemClick(this);
        mPhotosListview.setAdapter(adapter);

    }
    private void setupView() {
        OkHttpUtils.get()
                .url(URL)
                .build()
                .execute(new Callback<SofPhomoel>() {
                    @Override
                    public SofPhomoel parseNetworkResponse(Response response, int id) throws Exception {
                        Log.e(TAG, "parseNetworkResponse: 00000");
                        String result = response.body().string();
                        Gson gson = new Gson();
                        return gson.fromJson(result, SofPhomoel.class);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: 111111");
                    }

                    @Override
                    public void onResponse(SofPhomoel response, int id) {
                        adapter.updateRes(response.getData());
                        Log.e(TAG, "onResponse: 222222" );
                    }
                });
    }
    public void goBack(View view) {
        finish();
    }


    @Override
    public void onClick(int position) {
        intent = new Intent(this,DIYdapeiFragment.class);
        intent.putExtra("id",String.valueOf(position+1));
        intent.putExtra("name","photo");
        startActivity(intent);
    }


    @Override
    public void onClick2(String tag) {
        intent = new Intent(this,DIYdapeiFragment.class);
        intent.putExtra("id",tag);
        intent.putExtra("name","color");
        startActivity(intent);
    }
}
