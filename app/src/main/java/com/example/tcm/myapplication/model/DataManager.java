package com.example.tcm.myapplication.model;

import com.example.tcm.myapplication.entity.LatestDailyDetailBean;
import com.example.tcm.myapplication.entity.LatestDailyListBean;
import com.example.tcm.myapplication.impl.DBHelper;
import com.example.tcm.myapplication.impl.HttpHelper;

import io.reactivex.Flowable;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/11 11:04
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/11 11:04
 * @see
 */
public class DataManager implements HttpHelper, DBHelper {

    private final HttpHelper httpHelper;
    private final DBHelper dbHelper;

    public DataManager(HttpHelper httpHelper, DBHelper dbHelper) {
        this.httpHelper = httpHelper;
        this.dbHelper = dbHelper;
    }

    @Override
    public Flowable<LatestDailyListBean> fetchLatestDaily() {
        return httpHelper.fetchLatestDaily();
    }

    @Override
    public Flowable<LatestDailyDetailBean> fetchLatestDailyDetail() {
        return httpHelper.fetchLatestDailyDetail();
    }

}
