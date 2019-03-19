package com.example.tcm.myapplication.ui.module;

import com.example.tcm.myapplication.base.BaseView;
import com.example.tcm.myapplication.entity.LatestDailyListBean;

import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/12 17:28
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/12 17:28
 * @see
 */
public class LatestDailyContract {

    interface View extends BaseView {
        void returnLatestDaily(List<LatestDailyListBean.TopStoriesBean> bean);
    }

    interface Presenter{
        void fetchLatestDaily();
    }
}
