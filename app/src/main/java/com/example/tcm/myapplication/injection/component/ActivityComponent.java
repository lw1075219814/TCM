package com.example.tcm.myapplication.injection.component;

import android.app.Activity;

import com.example.tcm.myapplication.injection.module.ActivityModule;
import com.example.tcm.myapplication.injection.scope.ActivityScope;
import com.example.tcm.myapplication.mvp.main.SplashActivity;
import com.example.tcm.myapplication.mvp.main2.Main2Activity;
import com.example.tcm.myapplication.mvp.main2.gold.GoldManagerActivity;
import com.example.tcm.myapplication.mvp.main2.zhihu.LatestDailyDetailActivity;

import dagger.Component;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/1/31 17:47
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/1/31 17:47
 * @see
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(SplashActivity splashActivity);

    void inject(Main2Activity main2Activity);

    void inject(LatestDailyDetailActivity latestDailyDetailActivity);

    void inject(GoldManagerActivity tableManagerActivity);
}
