package com.example.tcm.myapplication.injection.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/4/22 15:31
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/4/22 15:31
 * @see
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface My {
}
