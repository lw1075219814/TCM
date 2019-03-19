package com.example.tcm.dagger2.demo.bean;

import com.example.tcm.myapplication.impl.IBehavior;
import com.orhanobut.logger.Logger;

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
        Logger.d(TAG, "speak");
    }

    @Override
    public void eat() {
        Logger.d(TAG, "speak");
    }
}
