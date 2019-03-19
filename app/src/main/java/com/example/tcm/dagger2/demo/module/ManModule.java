package com.example.tcm.dagger2.demo.module;

import com.example.tcm.dagger2.demo.bean.Base;
import com.example.tcm.dagger2.demo.bean.Boy;
import com.example.tcm.dagger2.demo.bean.Girl;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/8 14:28
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/8 14:28
 * @see
 */
@Module
public class ManModule {

    @Inject
    public ManModule() {
    }

    @Provides
    public Base provideBoy(Base boy) {
        return boy;
    }

    @Provides
    public Base provideGirl(Base girl) {
        return girl;
    }

}
