package com.example.lwk.beans.Fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.lwk.beans.R;

/**
 * Created by LWK on 2016/12/2.
 */
public class Shopmenu extends AppCompatActivity implements View.OnClickListener {
    private TextView mBack;
    private ShopmenuViewPagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_menu_layout);
        initView();
    }

    private void initView() {
        mBack = (TextView) findViewById(R.id.shop_menu_back);

        mBack.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shop_menu_back:
                finish();

            break;
        }
    }
}
