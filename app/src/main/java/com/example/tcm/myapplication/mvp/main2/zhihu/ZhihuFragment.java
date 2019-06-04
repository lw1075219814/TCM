package com.example.tcm.myapplication.mvp.main2.zhihu;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.adapter.ZhihuAdapter;
import com.example.tcm.myapplication.base.SimpleFragment;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

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

    @BindView(R.id.tabLayout)
    TabLayout tabLyout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    public static ZhihuFragment getInstance() {
        return new ZhihuFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu;
    }

    @Override
    protected void initView(View view) {
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
