package com.example.tcm.myapplication.model.http;

import com.example.tcm.myapplication.base.Constants;
import com.example.tcm.myapplication.bean.LatestDailyDetailBean;
import com.example.tcm.myapplication.bean.LatestDailyListBean;
import com.example.tcm.myapplication.bean.WeChatBean;
import com.example.tcm.myapplication.model.http.api.MyApis;
import com.example.tcm.myapplication.model.http.api.WeChatApis;
import com.example.tcm.myapplication.model.http.api.ZhiHuApis;
import com.example.tcm.myapplication.model.http.response.WXResponse;

import java.util.List;

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
    private final WeChatApis mWeChatApis;
    private final MyApis myApis;

    @Inject
    public RetrofitHelper(ZhiHuApis zhiHuApis, WeChatApis weChatApis, MyApis myApis) {
        this.mZhiHuApis = zhiHuApis;
        this.mWeChatApis = weChatApis;
        this.myApis = myApis;
    }

    @Override
    public Flowable<LatestDailyListBean> fetchLatestDaily() {
        return mZhiHuApis.getLatestDaily();
    }

    @Override
    public Flowable<LatestDailyDetailBean> fetchLatestDailyDetail() {
        return null;
    }

    @Override
    public Flowable<WXResponse<List<WeChatBean>>> getWeChatData(int num, int page) {
        return mWeChatApis.getWeChatData(Constants.KEY_API, num, page);
    }

}
