package com.example.tcm.myapplication.injection.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/4/22 15:36
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/4/22 15:36
 * @see
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScope {
}
