package com.example.tcm.dagger2.bean;

import android.util.Log;

import com.example.tcm.myapplication.impl.IBehavior;

import javax.inject.Inject;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/8 13:24
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/8 13:24
 * @see
 */
public class Woman extends Base implements IBehavior {

    @Inject
    public Woman() {
    }

    @Override
    public void speak() {
        Log.d(TAG, "speak");
    }

    @Override
    public void eat() {
        Log.d(TAG, "speak");
    }
}
