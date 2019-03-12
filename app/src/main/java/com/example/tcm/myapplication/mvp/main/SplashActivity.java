package com.example.tcm.myapplication.mvp.main;

import android.content.Intent;
import android.view.KeyEvent;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.base.BaseActivity;
import com.example.tcm.myapplication.model.DataManager;
import com.example.tcm.myapplication.ui.module.TestActivity;

import javax.inject.Inject;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2018/10/20 18:20
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/10/20 18:20
 * @see
 */
public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        mPresener.startTimer();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void toMain() {
//        Intent intent = new Intent(this, MainActivity.class);
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    private void toTest() {
        startActivity(new Intent(this, TestActivity.class));
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //toMain();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
