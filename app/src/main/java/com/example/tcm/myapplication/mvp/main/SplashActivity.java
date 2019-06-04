package com.example.tcm.myapplication.mvp.main;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.base.BaseActivity;
import com.example.tcm.myapplication.util.IntentUtil;

import butterknife.BindView;
import butterknife.OnClick;

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

    @BindView(R.id.tv_time)
    TextView tvTime;

    @OnClick(R.id.rl_time)
    void onClick(View view) {
        mPresener.cancelTimer();
    }

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
        IntentUtil.toMain(SplashActivity.this);
    }

    @Override
    public void showCountDown(Long count) {
        tvTime.setText(String.valueOf(count));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
