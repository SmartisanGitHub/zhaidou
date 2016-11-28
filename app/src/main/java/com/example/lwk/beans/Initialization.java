package com.example.lwk.beans;

import android.app.Application;

import com.rock.teachlibrary.ImageLoader;

/**
 * Created by LWK on 2016/11/28.
 */
public class Initialization extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.init(this);
    }
}
