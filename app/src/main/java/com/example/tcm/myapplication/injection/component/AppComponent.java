package com.example.tcm.myapplication.injection.component;


import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.injection.module.AppModule;
import com.example.tcm.myapplication.injection.module.HttpModule;
import com.example.tcm.myapplication.model.DataManager;
import com.example.tcm.myapplication.model.db.GreenDaoHelper;
import com.example.tcm.myapplication.model.http.RetrofitHelper;
import com.example.tcm.myapplication.model.prefs.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/1/31 17:15
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/1/31 17:15
 * @see
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getApp();

    DataManager getDataManager();

    RetrofitHelper getRetrofitHelper();

    GreenDaoHelper getGreenDaoHelper();

    PreferencesHelper getPreferencesHelper();

}
