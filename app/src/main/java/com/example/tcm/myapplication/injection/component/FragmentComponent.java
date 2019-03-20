package com.example.tcm.myapplication.injection.component;

import android.app.Activity;

import com.example.tcm.myapplication.injection.module.FragmentModule;
import com.example.tcm.myapplication.mvp.ZhihuFragment;

import dagger.Component;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/20 11:28
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/20 11:28
 * @see
 */
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(ZhihuFragment zhihuFragment);
}
