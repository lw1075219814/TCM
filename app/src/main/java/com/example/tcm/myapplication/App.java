package com.example.tcm.myapplication;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.example.tcm.myapplication.injection.component.AppComponent;
import com.example.tcm.myapplication.injection.component.DaggerAppComponent;
import com.example.tcm.myapplication.injection.module.AppModule;
import com.example.tcm.myapplication.injection.module.HttpModule;
import com.example.tcm.myapplication.service.InitService;

import java.util.HashSet;
import java.util.Set;

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

    private AppComponent applicationComponent;
    private static App instance;
    private Set<Activity> activities;

    public static int SCREEN_WIDTH = 0;
    public static int SCREEN_HEIGTH = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        getScreenSize();

        InitService.start(this);
    }

    public static synchronized App getInstance() {
        return instance;
    }

    public Context getContext() {
        return getApplicationContext();
    }

    public AppComponent getAppComponent() {
        if (applicationComponent == null) {
            applicationComponent = DaggerAppComponent
                    .builder()
                    .appModule(new AppModule(this))
                    .httpModule(new HttpModule())
                    .build();
        }
        return applicationComponent;
    }

    public void addActivity(Activity activity) {
        if (activities == null) {
            activities = new HashSet<>();
        }
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (activities != null) {
            activities.remove(activity);
        }
    }

    public void exitApp() {
        synchronized (this) {
            for (Activity ac : activities) {
                ac.finish();
            }
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        }
    }

    public void getScreenSize() {
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        SCREEN_WIDTH = metrics.widthPixels;
        SCREEN_HEIGTH = metrics.heightPixels;
    }
}
