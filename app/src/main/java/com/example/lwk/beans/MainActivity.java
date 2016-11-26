package com.example.lwk.beans;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.lwk.beans.Fragment.HomeFragment;
import com.example.lwk.beans.Fragment.MagicFragment;
import com.example.lwk.beans.Fragment.MineFragment;
import com.example.lwk.beans.Fragment.ShopFragment;
import com.example.lwk.beans.Fragment.ShoppingcartFragment;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup mRadioGroup;
    private Fragment mFragmentShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.beans_main_controller);
        mRadioGroup.setOnCheckedChangeListener(this);

        //加载第一个界面
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mFragmentShow = new HomeFragment();
        transaction.add(R.id.beans_main_fragmentshow, mFragmentShow,HomeFragment.TAG);
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.beans_main_controller_home :
                switchPage(HomeFragment.TAG,HomeFragment.class);
                break;
            case R.id.beans_main_controller_shop:
                switchPage(ShopFragment.TAG,ShopFragment.class);
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
        transaction.hide(mFragmentShow);
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

            transaction.commit();

        }
    }


}
