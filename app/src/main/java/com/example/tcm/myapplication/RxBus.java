package com.example.tcm.myapplication;

import com.hwangjr.rxbus.Bus;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/1/25 13:41
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/1/25 13:41
 * @see
 */
public class RxBus {

    private static class Holder{
        private static final Bus INSTANCE = new Bus();
    }

    public static Bus get(){
        return Holder.INSTANCE;
    }

}
