package com.example.tcm.myapplication.injection.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.example.tcm.myapplication.injection.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/20 11:29
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/20 11:29
 * @see
 */
@Module
public class FragmentModule {

    private final Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        this.mFragment = fragment;
    }

    @Provides
    @FragmentScope
    Fragment provideFragment() {
        return mFragment;
    }

    @Provides
    Activity provideActivity() {
        return mFragment.getActivity();
    }

}
