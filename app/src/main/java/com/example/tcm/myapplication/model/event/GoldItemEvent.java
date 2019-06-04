package com.example.tcm.myapplication.model.event;

import com.example.tcm.myapplication.bean.GoldBean;
import com.example.tcm.myapplication.bean.GoldItemBean;

import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/5/7 10:43
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/5/7 10:43
 * @see
 */
public class GoldItemEvent {

    private GoldBean goldBean;

    public GoldItemEvent(GoldBean goldBean) {
        this.goldBean = goldBean;
    }

    public GoldBean getGoldBean() {
        return goldBean;
    }
}
