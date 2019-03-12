package com.example.tcm.myapplication.model;

import android.util.Log;

import com.example.tcm.myapplication.impl.IDB;
import com.example.tcm.myapplication.impl.IHttp;
import com.example.tcm.myapplication.model.db.GreenDaoHelper;
import com.example.tcm.myapplication.model.http.RetrofitHelper;

import javax.inject.Inject;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/11 11:04
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/11 11:04
 * @see
 */
public class DataManager implements IHttp, IDB {

    private final IHttp mHttp;
    private final IDB mIdb;

    public DataManager(IHttp http, IDB idb) {
        mHttp = http;
        mIdb = idb;
    }

    @Override
    public String login() {
        return mHttp.login();
    }

    @Override
    public String getUserInfo() {
        return mIdb.getUserInfo();
    }
}
