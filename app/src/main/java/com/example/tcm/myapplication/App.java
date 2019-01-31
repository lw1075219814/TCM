package com.example.tcm.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2018/8/27 11:52
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/8/27 11:52
 * @see
 */
public class App extends Application {

    private static App app;

    public static Context getContext(){
        return app.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
    }
}
