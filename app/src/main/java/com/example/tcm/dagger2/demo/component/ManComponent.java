package com.example.tcm.dagger2.demo.component;

import com.example.tcm.dagger2.demo.bean.Boy;
import com.example.tcm.dagger2.demo.bean.Girl;
import com.example.tcm.dagger2.demo.bean.Man;
import com.example.tcm.dagger2.demo.bean.Proxy;
import com.example.tcm.dagger2.demo.bean.Woman;
import com.example.tcm.dagger2.demo.module.ManModule;

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
