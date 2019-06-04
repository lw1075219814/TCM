package com.example.tcm.myapplication.mvp.main2.gold;

import android.support.design.widget.TabLayout;
import android.view.View;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.base.BaseFragment;
import com.example.tcm.myapplication.bean.GoldItemBean;
import com.example.tcm.myapplication.util.IntentUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/4/28 10:50
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/4/28 10:50
 * @see
 */
public class GoldFragment extends BaseFragment<GoldManagerPresenter> implements GoldContract.View {

    private static final String[] TABLE_TITLE = {
            "android", "ios", "前端", "后端", "设计", "产品", "阅读", "工具"
    };

    private static final String[] TABLE_TYPE = {
            "android", "ios", "frontend", "backend", "design", "product", "article", "freebie"
    };

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private List<GoldItemBean> beans;
    //    @BindView(R.id.viewpager)
//    ViewPager viewPager;

    @OnClick(R.id.iv_more)
    void onClick(View view) {
        IntentUtil.toGoldManager(getActivity(), TABLE_TITLE, (ArrayList<GoldItemBean>) beans);
    }

    public static GoldFragment getInstance() {
        return new GoldFragment();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold;
    }

    @Override
    protected void initView(View view) {
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mPresenter.getGoldItems();
    }

    @Override
    public void returnData(List<GoldItemBean> itemBeans) {
        beans = itemBeans;
        tabLayout.removeAllTabs();
        for (GoldItemBean item : itemBeans) {
            if (item.isSelect()) {
                tabLayout.addTab(tabLayout.newTab().setText(TABLE_TITLE[item.getPosition()]));
            }
        }
    }

    @Override
    public void onError(String msg) {

    }
}
