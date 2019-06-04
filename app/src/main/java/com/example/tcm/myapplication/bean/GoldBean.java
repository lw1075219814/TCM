package com.example.tcm.myapplication.bean;

import java.util.ArrayList;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/5/7 10:58
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/5/7 10:58
 * @see
 */
public class GoldBean {

    private ArrayList<GoldItemBean> beans;

    public GoldBean(ArrayList<GoldItemBean> data) {
        beans = data;
    }

    public ArrayList<GoldItemBean> getBeans() {
        return beans;
    }

    public void setBeans(ArrayList<GoldItemBean> beans) {
        this.beans = beans;
    }
}
