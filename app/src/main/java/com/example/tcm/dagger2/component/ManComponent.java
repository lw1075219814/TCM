package com.example.tcm.dagger2.component;

import com.example.tcm.dagger2.bean.Boy;
import com.example.tcm.dagger2.bean.Girl;
import com.example.tcm.dagger2.bean.Man;
import com.example.tcm.dagger2.bean.Proxy;
import com.example.tcm.dagger2.bean.Woman;
import com.example.tcm.dagger2.module.ManModule;

import dagger.Component;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/8 13:33
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/8 13:33
 * @see
 */
@Component(modules = ManModule.class)
public interface ManComponent {

    Proxy getProxy();

    Man getMan();

    Woman getWoman();

    Boy getBoy();

    Girl getGirl();
}
