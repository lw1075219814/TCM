package com.example.tcm.myapplication.model.http.api;

import com.example.tcm.myapplication.bean.LatestDailyListBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/11 14:48
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/11 14:48
 * @see
 */
public interface ZhiHuApis {

    String URL = "http://news-at.zhihu.com/api/4/";

    /**
     * 获取最新日报
     * @return
     */
    @GET("news/latest")
    Flowable<LatestDailyListBean> getLatestDaily();
}
