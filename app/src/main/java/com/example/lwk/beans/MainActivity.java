package com.example.lwk.beans;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.example.lwk.beans.Fragment.HomeFragment;
import com.example.lwk.beans.Fragment.MagicFragment;
import com.example.lwk.beans.Fragment.MineFragment;
import com.example.lwk.beans.Fragment.ShopFragment;
import com.example.lwk.beans.Fragment.ShopHeader;
import com.example.lwk.beans.Fragment.ShoppingcartFragment;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private RadioGroup mRadioGroup;
    private Fragment mFragmentShow;
    private NavigationView mNevigation;
    private DrawerLayout mDraw;

    public String ms ="no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mDraw = (DrawerLayout) findViewById(R.id.beans_main_drawer);
        mNevigation = (NavigationView) findViewById(R.id.teach_navigation);
        mRadioGroup = (RadioGroup) findViewById(R.id.beans_main_controller);
        mRadioGroup.setOnCheckedChangeListener(this);
        mDraw.setScrimColor(Color.TRANSPARENT);

        //加载第一个界面
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mFragmentShow = new HomeFragment();
        transaction.add(R.id.beans_main_fragmentshow, mFragmentShow,HomeFragment.TAG);
        transaction.commit();
        setupDrawerContent(mNevigation);
    }

    private void setupDrawerContent(NavigationView mNevigation) {


        mNevigation.setNavigationItemSelectedListener(this);



    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.beans_main_controller_home :
                switchPage(HomeFragment.TAG,HomeFragment.class);
                break;
            case R.id.beans_main_controller_shop:
                switchPage(ShopHeader.TAG,ShopFragment.class);
                break;
            case R.id.beans_main_controller_magic :
                switchPage(MagicFragment.TAG,MagicFragment.class);

                break;
            case R.id.beans_main_controller_shoppingcart:
                switchPage(ShoppingcartFragment.TAG,ShoppingcartFragment.class);
                break;
            case R.id.beans_main_controller_mine :
                switchPage(MineFragment.TAG,MineFragment.class);
                break;
        }
    }

    private void switchPage(String tag, Class<?extends Fragment> cls) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if(mFragmentShow!=null){
            transaction.hide(mFragmentShow);
        }
        mFragmentShow = fm.findFragmentByTag(tag);
        if (mFragmentShow!=null) {
            transaction.show(mFragmentShow);
        }else{
            try {
                mFragmentShow= cls.getConstructor().newInstance();
                transaction.add(R.id.beans_main_fragmentshow,mFragmentShow,tag);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        transaction.commit();

    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        item.setChecked(true);
        mDraw.closeDrawers();
        return true;
    }


}
