package com.example.tcm.myapplication.injection.module;

import android.content.Context;

import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.impl.IDB;
import com.example.tcm.myapplication.impl.IHttp;
import com.example.tcm.myapplication.model.DataManager;
import com.example.tcm.myapplication.model.db.GreenDaoHelper;
import com.example.tcm.myapplication.model.http.RetrofitHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/1/31 17:16
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/1/31 17:16
 * @see
 */
@Module
public class AppModule {

    private App mApp;

    @Inject
    public AppModule(App app) {
        this.mApp = app;
    }

    @Provides
    App provideApp() {
        return mApp;
    }

    @Provides
    DataManager provideDataManager(RetrofitHelper retrofitHelper, GreenDaoHelper greenDaoHelper) {
        return new DataManager(retrofitHelper, greenDaoHelper);
    }

    @Provides
    IHttp provideRetrofitHelper(IHttp iHttp) {
        return iHttp;
    }

    @Provides
    IDB provideGreenDaoHelper(IDB idb) {
        return idb;
    }

}
