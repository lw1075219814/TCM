package com.example.tcm.myapplication.mvp.main2;

import android.view.View;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.base.BaseFragment;
import com.example.tcm.myapplication.mvp.main.SplashPresenter;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/21 15:59
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/21 15:59
 * @see
 */
public class SectionFragment extends BaseFragment<SplashPresenter> {
    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_section;
    }

    @Override
    protected void initView(View view) {

    }
}
