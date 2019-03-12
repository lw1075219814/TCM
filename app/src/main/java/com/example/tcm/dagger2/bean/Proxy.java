package com.example.tcm.dagger2.bean;

import com.example.tcm.myapplication.impl.IBehavior;

import javax.inject.Inject;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/8 13:27
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/8 13:27
 * @see
 */
public class Proxy {

    private final IBehavior mMan;
    private final IBehavior mWoman;

    @Inject
    public Proxy(Man man, Woman woman) {
        this.mMan = man;
        this.mWoman = woman;
    }

    public void speak() {
        mMan.speak();
        mWoman.speak();
    }

    public void eat() {
        mMan.eat();
        mWoman.eat();
    }

}
