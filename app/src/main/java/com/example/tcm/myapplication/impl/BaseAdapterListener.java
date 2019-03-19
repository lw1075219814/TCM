package com.example.tcm.myapplication.impl;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/15 15:12
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/15 15:12
 * @see
 */
public interface BaseAdapterListener<T> {

    void onClick(T bean);

    void onLongClick(T bean);
}
