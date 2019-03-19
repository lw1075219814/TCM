package com.example.tcm.myapplication.base;

import android.app.ProgressDialog;
import android.os.Looper;
import android.support.v7.app.AppCompatDelegate;
import android.widget.Toast;

import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.injection.component.ActivityComponent;
import com.example.tcm.myapplication.injection.component.DaggerActivityComponent;
import com.example.tcm.myapplication.injection.module.ActivityModule;
import com.example.tcm.myapplication.util.ToastUtil;

import javax.inject.Inject;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/2/1 17:40
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/2/1 17:40
 * @see
 */
public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView {

    @Inject
    protected T mPresener;

    private ProgressDialog progressDialog;

    private ActivityComponent activityComponent;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent
                    .builder()
                    .appComponent(App.getInstance().getAppComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresener != null) {
            mPresener.attchView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresener != null) {
            mPresener.detachView();
        }
    }

    @Override
    public void showLoading() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("加载中......");
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    @Override
    public void dismissLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void setNightMode(boolean isNight) {
        AppCompatDelegate.setDefaultNightMode(
                isNight ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
        recreate();
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
