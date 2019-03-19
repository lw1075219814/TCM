package com.example.tcm.myapplication.ui.module;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.adapter.LatestDailyAdapter;
import com.example.tcm.myapplication.base.BaseActivity;
import com.example.tcm.myapplication.entity.LatestDailyListBean;
import com.example.tcm.myapplication.impl.BaseAdapterListener;
import com.example.tcm.myapplication.util.IntentUtil;
import com.example.tcm.myapplication.util.ToastUtil;
import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.List;

/**
 * @author liuwen
 * @Module.Name 最新消息列表
 * @Create.Date 2018/11/1 14:58
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/11/1 14:58
 * @see
 */
public class LatestDailyListActivity extends BaseActivity<LatestDailyPresenter>
        implements LatestDailyContract.View,
        SwipeRefreshLayout.OnRefreshListener {

    private EasyRecyclerView recyclerView;
    private LatestDailyAdapter adapter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_latest_daily;
    }

    @Override
    protected void initView() {
        //setToolBar("今日最新");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setRefreshListener(this);

        recyclerView.setRefreshing(true);
        mPresener.fetchLatestDaily();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void returnLatestDaily(List<LatestDailyListBean.TopStoriesBean> beans) {
        if (adapter == null) {
            adapter = new LatestDailyAdapter(LatestDailyListActivity.this, beans);
            recyclerView.setAdapter(adapter);
            adapter.setBaseAdapterListener(topStoriesListener);
        } else {
            adapter.notifyDataSetChanged();
        }
        recyclerView.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        recyclerView.setRefreshing(true);
        mPresener.fetchLatestDaily();
    }

    private BaseAdapterListener<LatestDailyListBean.TopStoriesBean> topStoriesListener = new BaseAdapterListener
            <LatestDailyListBean.TopStoriesBean>() {

        @Override
        public void onClick(LatestDailyListBean.TopStoriesBean bean) {
            IntentUtil.toLatestDailyDetail(LatestDailyListActivity.this, bean.getId());
        }

        @Override
        public void onLongClick(LatestDailyListBean.TopStoriesBean bean) {

        }
    };

}
