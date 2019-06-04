package com.example.tcm.myapplication.mvp.main2.gold;

import com.example.tcm.myapplication.base.BaseView;
import com.example.tcm.myapplication.bean.GoldItemBean;

import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/4/29 10:07
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/4/29 10:07
 * @see
 */
public interface GoldContract {

    interface View extends BaseView {
        void returnData(List<GoldItemBean> itemBeans);

        void onError(String msg);
    }

    interface Presenter {
        void getGoldItems();

        void updateGoldItems(List<GoldItemBean> items);
    }
}
