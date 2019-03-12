package com.example.tcm.myapplication.base;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/2/1 15:39
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/2/1 15:39
 * @see
 */
public interface BasePresenter<T extends BaseView> {
    void attchView(T view);
    void detachView();
}
