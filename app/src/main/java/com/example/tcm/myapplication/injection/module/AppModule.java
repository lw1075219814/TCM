package com.example.tcm.myapplication.injection.module;

import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.model.DataManager;
import com.example.tcm.myapplication.model.db.GreenDaoHelper;
import com.example.tcm.myapplication.model.http.RetrofitHelper;
import com.example.tcm.myapplication.model.prefs.PreferencesHelper;

import javax.inject.Inject;

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
    DataManager provideDataManager(RetrofitHelper retrofitHelper, GreenDaoHelper greenDaoHelper, PreferencesHelper preferencesHelper) {
        return new DataManager(retrofitHelper, greenDaoHelper, preferencesHelper);
    }

}
