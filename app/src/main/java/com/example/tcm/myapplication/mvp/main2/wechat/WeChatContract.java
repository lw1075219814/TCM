package com.example.tcm.myapplication.mvp.main2.wechat;

import com.example.tcm.myapplication.base.BaseView;
import com.example.tcm.myapplication.bean.WeChatBean;

import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/4/23 10:39
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/4/23 10:39
 * @see
 */
public interface WeChatContract {

    interface View extends BaseView {

        void setRefreshing(boolean refreshing);

        void returnData(List<WeChatBean> datas);

        void returnMoreData(List<WeChatBean> moreDatas);

        void onError(String msg);

        void onMoreError(String msg);
    }

    interface Presenter {

        void getWeChatData();

        void getWeChatMoreData();
    }
}
