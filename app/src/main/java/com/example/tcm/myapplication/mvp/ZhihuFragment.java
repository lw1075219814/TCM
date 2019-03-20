package com.example.tcm.myapplication.mvp;

import android.support.design.widget.TabLayout;
import android.view.View;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.base.SimpleFragment;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/20 11:35
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/20 11:35
 * @see
 */
public class ZhihuFragment extends SimpleFragment {

    private final String[] tabTitle = new String[]{"日报", "主题", "专栏", "热门"};

    public static ZhihuFragment getInstance() {
        return new ZhihuFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu;
    }

    @Override
    protected void initView(View view) {
        TabLayout tabLyout = view.findViewById(R.id.tabLyout);

        for (int i = 0; i < tabTitle.length; i++) {
            tabLyout.addTab(tabLyout.newTab().setText(tabTitle[i]));
        }
    }

    @Override
    protected void initListener() {
        super.initListener();

    }
}
