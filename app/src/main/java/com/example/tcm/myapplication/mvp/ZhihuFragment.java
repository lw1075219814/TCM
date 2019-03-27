package com.example.tcm.myapplication.mvp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.adapter.ZhihuAdapter;
import com.example.tcm.myapplication.base.SimpleFragment;
import com.example.tcm.myapplication.mvp.main2.DailyFragment;
import com.example.tcm.myapplication.mvp.main2.HotFragment;
import com.example.tcm.myapplication.mvp.main2.SectionFragment;
import com.example.tcm.myapplication.mvp.main2.ThemeFragment;

import java.util.Arrays;
import java.util.List;

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

    private final List<Fragment> fragments = Arrays.asList(
            new DailyFragment(),
            new ThemeFragment(),
            new SectionFragment(),
            new HotFragment()
    );

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
        ViewPager viewPager = view.findViewById(R.id.viewpager);

        for (int i = 0; i < tabTitle.length; i++) {
            tabLyout.addTab(tabLyout.newTab().setText(tabTitle[i]));
        }

        ZhihuAdapter zhihuAdapter = new ZhihuAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(zhihuAdapter);
        tabLyout.setupWithViewPager(viewPager);

        //需重新设置tabText
        for (int i = 0; i < tabTitle.length; i++) {
            tabLyout.getTabAt(i).setText(tabTitle[i]);
        }
    }

}
