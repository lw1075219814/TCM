package com.example.tcm.myapplication.model.http;

import com.example.tcm.myapplication.bean.LatestDailyDetailBean;
import com.example.tcm.myapplication.bean.LatestDailyListBean;
import com.example.tcm.myapplication.bean.WeChatBean;
import com.example.tcm.myapplication.model.http.response.WXResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/11 11:03
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/11 11:03
 * @see
 */
public interface HttpHelper {

    Flowable<LatestDailyListBean> fetchLatestDaily();

    Flowable<LatestDailyDetailBean> fetchLatestDailyDetail();

    Flowable<WXResponse<List<WeChatBean>>> getWeChatData(int num, int page);

}
