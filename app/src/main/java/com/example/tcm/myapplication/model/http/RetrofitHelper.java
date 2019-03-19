package com.example.tcm.myapplication.model.http;

import com.example.tcm.myapplication.entity.LatestDailyDetailBean;
import com.example.tcm.myapplication.entity.LatestDailyListBean;
import com.example.tcm.myapplication.impl.HttpHelper;
import com.example.tcm.myapplication.model.http.api.ZhiHuApis;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/12 11:07
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/12 11:07
 * @see
 */
public class RetrofitHelper implements HttpHelper {

    private final ZhiHuApis mZhiHuApis;

    @Inject
    public RetrofitHelper(ZhiHuApis zhiHuApis) {
        mZhiHuApis = zhiHuApis;
    }

    @Override
    public Flowable<LatestDailyListBean> fetchLatestDaily() {
        return mZhiHuApis.getLatestDaily();
    }

    @Override
    public Flowable<LatestDailyDetailBean> fetchLatestDailyDetail() {
        return null;
    }
}
