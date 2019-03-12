package com.example.tcm.myapplication.model.db;

import com.example.tcm.myapplication.impl.IDB;

import javax.inject.Inject;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/12 11:07
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/12 11:07
 * @see
 */
public class GreenDaoHelper implements IDB {

    @Inject
    public GreenDaoHelper() {

    }

    @Override
    public String getUserInfo() {
        return "hello wrold";
    }
}
