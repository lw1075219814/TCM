package com.example.tcm.myapplication.base;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/2/1 15:38
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/2/1 15:38
 * @see
 */
public interface BaseView {
    void showLoading();
    void hideLoading();
    void setNightMode(boolean isNight);
    void showSuccess(String data);
    void showError(Throwable throwable);
}
