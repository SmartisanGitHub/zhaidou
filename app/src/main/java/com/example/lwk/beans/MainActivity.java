package com.example.lwk.beans;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lwk.beans.Fragment.HomeFragment;
import com.example.lwk.beans.Fragment.MagicFragment;
import com.example.lwk.beans.Fragment.MineFragment;
import com.example.lwk.beans.Fragment.ShopFragment;
import com.example.lwk.beans.Fragment.ShoppingcartFragment;
import com.umeng.analytics.MobclickAgent;

import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RadioGroup mRadioGroup;
    private Fragment mFragmentShow;
    private NavigationView mNevigation;
    private DrawerLayout mDraw;
    private boolean isExit = false;  //双击退出标志
    public String ms = "no";


    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);

    }

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
        transaction.add(R.id.beans_main_fragmentshow, mFragmentShow, HomeFragment.TAG);
        transaction.commit();
        setupDrawerContent(mNevigation);
    }

    private void setupDrawerContent(NavigationView mNevigation) {


        mNevigation.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.beans_main_controller_home:
                switchPage(HomeFragment.TAG, HomeFragment.class);
                break;
            case R.id.beans_main_controller_shop:
                switchPage(ShopFragment.TAG,ShopFragment.class);
                break;
            case R.id.beans_main_controller_magic:
                switchPage(MagicFragment.TAG, MagicFragment.class);

                break;
            case R.id.beans_main_controller_shoppingcart:
                switchPage(ShoppingcartFragment.TAG, ShoppingcartFragment.class);
                break;
            case R.id.beans_main_controller_mine:
                switchPage(MineFragment.TAG, MineFragment.class);
                break;
        }
    }

    private void switchPage(String tag, Class<? extends Fragment> cls) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (mFragmentShow != null) {
            transaction.hide(mFragmentShow);
        }
        mFragmentShow = fm.findFragmentByTag(tag);
        if (mFragmentShow != null) {
            transaction.show(mFragmentShow);
        } else {
            try {
                mFragmentShow = cls.getConstructor().newInstance();
                transaction.add(R.id.beans_main_fragmentshow, mFragmentShow, tag);

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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode== KeyEvent.KEYCODE_BACK) {
            if (!isExit==true) {
                isExit=true;
                Toast.makeText(MainActivity.this, "再按一次推出", Toast.LENGTH_SHORT).show();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        //调用定时器的定时任务   1具体的事务， 2延迟时间
                        isExit = false;
                    }
                }, 2 * 1000);
                return true;
            }
        }
       return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}