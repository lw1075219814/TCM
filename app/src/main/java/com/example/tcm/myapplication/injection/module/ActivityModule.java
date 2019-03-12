package com.example.tcm.myapplication.injection.module;

import android.app.Activity;
import android.content.Context;

import com.example.tcm.dagger2.bean.Man;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/1/31 17:48
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/1/31 17:48
 * @see
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    @Inject
    public ActivityModule(Activity activity){
        this.mActivity = activity;
    }

    @Provides
    Activity provideActivity(){
        return mActivity;
    }

}
