package com.example.tcm.myapplication.entity;

import android.util.Log;

import javax.inject.Inject;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2018/11/1 14:59
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/11/1 14:59
 * @see
 */
public class User {
    private static final String TAG = User.class.getSimpleName();

    private String name;
    private int age;

    //构造方法添加注解
    @Inject
    public User(){
        Log.e(TAG,"init");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
