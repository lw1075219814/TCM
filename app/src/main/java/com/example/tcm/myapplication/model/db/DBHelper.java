package com.example.tcm.myapplication.model.db;

import com.example.tcm.myapplication.bean.GoldItemBean;

import java.util.List;

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
public interface DBHelper {

    void updateGoldItems(List<GoldItemBean> items);

    Flowable<List<GoldItemBean>> getGoldTtems();

}
