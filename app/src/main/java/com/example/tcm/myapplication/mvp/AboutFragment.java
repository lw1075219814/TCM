package com.example.tcm.myapplication.mvp;

import android.view.View;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.base.SimpleFragment;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/21 11:05
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/21 11:05
 * @see
 */
public class AboutFragment extends SimpleFragment {

    public static AboutFragment getInstance() {
        return new AboutFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override
    protected void initView(View view) {

    }
}
