package com.example.tcm.myapplication.mvp;

import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2018/12/7 17:04
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/12/7 17:04
 * @see
 */
public interface TaskContract {

    interface View extends BaseView<Presenter>{
        void showProgress();
        void hideProgress();
        String getData();
        void showResult(List list);
    }

    interface Presenter extends BasePresenter{
        void addData();
        void setResult();
    }

}
