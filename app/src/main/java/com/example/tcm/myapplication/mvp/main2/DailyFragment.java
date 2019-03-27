package com.example.tcm.myapplication.mvp.main2;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.adapter.LatestDailyAdapter;
import com.example.tcm.myapplication.base.BaseFragment;
import com.example.tcm.myapplication.entity.LatestDailyListBean;
import com.example.tcm.myapplication.impl.BaseAdapterListener;
import com.example.tcm.myapplication.util.IntentUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/21 15:59
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/21 15:59
 * @see
 */
public class DailyFragment extends BaseFragment<LatestDailyPresenter> implements LatestDailyContract.View {

    private SwipeRefreshLayout refreshLayout;

    private List<LatestDailyListBean.TopStoriesBean> beans = new ArrayList<>();
    private LatestDailyAdapter dailyAdapter;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily;
    }

    @Override
    protected void initView(View view) {
        refreshLayout = view.findViewById(R.id.refreshLayout);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        FloatingActionButton flbSubmit = view.findViewById(R.id.flbSubmit);

        dailyAdapter = new LatestDailyAdapter(getActivity(), beans);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(dailyAdapter);

        mPresenter.fetchLatestDaily();
    }

    @Override
    protected void initListener() {
        super.initListener();
        refreshLayout.setOnRefreshListener(onRefreshListener);
        dailyAdapter.setBaseAdapterListener(topStoriesListener);
    }

    @Override
    public void returnLatestDaily(List<LatestDailyListBean.TopStoriesBean> bean) {
        dailyAdapter.setData(bean);
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onError(Throwable throwable) {
        refreshLayout.setRefreshing(false);
    }

    private SwipeRefreshLayout.OnRefreshListener onRefreshListener =
            new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    mPresenter.fetchLatestDaily();
                }
            };

    private BaseAdapterListener<LatestDailyListBean.TopStoriesBean> topStoriesListener = new BaseAdapterListener
            <LatestDailyListBean.TopStoriesBean>() {

        @Override
        public void onClick(LatestDailyListBean.TopStoriesBean bean) {
            IntentUtil.toLatestDailyDetail(getActivity(), bean.getId());
        }


        @Override
        public void onLongClick(LatestDailyListBean.TopStoriesBean bean) {

        }
    };
}
