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
public class Man extends Base implements IBehavior {
    private String name;
    private int age;

    @Inject
    public Man() {
        name = "ailen";
        age = 20;
    }

    @Override
    public void speak() {
        Logger.d(TAG, "speak");
    }

    @Override
    public void eat() {
        Logger.d(TAG, "eat");
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

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
