package com.example.tcm.myapplication.model.http;

import android.util.Log;

import com.example.tcm.myapplication.impl.IHttp;

import javax.inject.Inject;

import static android.support.constraint.Constraints.TAG;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/12 11:07
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/12 11:07
 * @see
 */
public class RetrofitHelper implements IHttp {

    @Inject
    public RetrofitHelper(){

    }

    @Override
    public String login() {
        return "login success";
    }
}
