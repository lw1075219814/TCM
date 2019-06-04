package com.example.tcm.myapplication;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019-06-04 11:41
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019-06-04 11:41
 * @see
 */
public class DebugApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        System.out.println("this is a debug mode");
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }
}
