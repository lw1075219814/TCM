package com.example.tcm.myapplication.mvp.main;

import com.example.tcm.myapplication.base.BasePresenter;
import com.example.tcm.myapplication.base.BaseView;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/2/2 13:58
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/2/2 13:58
 * @see
 */
public interface SplashContract {

    interface View extends BaseView{
        void toMain();
    }

    interface Presenter extends BasePresenter<View>{
        void startTimer();
    }

}
