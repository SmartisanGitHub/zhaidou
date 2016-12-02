package com.example.lwk.beans;

import android.app.Application;

import com.rock.teachlibrary.ImageLoader;
import com.umeng.analytics.MobclickAgent;

import org.xutils.x;

/**
 * Created by LWK on 2016/11/28.
 */
public class Initialization extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.init(this);
        x.Ext.init(this);

        String YouMengAppKey="5840d8e0717c19710c001063";
        String ChannelID="Study";
        MobclickAgent.UMAnalyticsConfig config = new MobclickAgent.UMAnalyticsConfig(this,YouMengAppKey,ChannelID, MobclickAgent.EScenarioType.E_UM_NORMAL,true);

        MobclickAgent.startWithConfigure(config);

    }
}
