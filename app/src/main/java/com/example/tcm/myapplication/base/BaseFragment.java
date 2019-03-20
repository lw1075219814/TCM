package com.example.tcm.myapplication.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.injection.component.DaggerFragmentComponent;
import com.example.tcm.myapplication.injection.component.FragmentComponent;
import com.example.tcm.myapplication.injection.module.FragmentModule;
import com.example.tcm.myapplication.util.ToastUtil;

import javax.inject.Inject;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/20 11:11
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/20 11:11
 * @see
 */
public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment implements BaseView {

    @Inject
    protected T mPresenter;
    private FragmentComponent fragmentComponent;

    public FragmentComponent getFragmentComponent() {
        if (fragmentComponent == null) {
            fragmentComponent = DaggerFragmentComponent
                    .builder()
                    .appComponent(App.getInstance().getAppComponent())
                    .fragmentModule(new FragmentModule(this))
                    .build();
        }
        return fragmentComponent;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInject();
        mPresenter.attchView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void setNightMode(boolean isNight) {

    }

    @Override
    public void showSuccess(String data) {

    }

    @Override
    public void showErrorMsg(String msg) {
        ToastUtil.shortShow(msg);
    }

    protected abstract void initInject();
}
