package com.example.tcm.myapplication.mvp.main2.zhihu;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.adapter.LatestDailyAdapter;
import com.example.tcm.myapplication.base.BaseFragment;
import com.example.tcm.myapplication.bean.LatestDailyListBean;
import com.example.tcm.myapplication.impl.BaseAdapterListener;
import com.example.tcm.myapplication.util.IntentUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

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

    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.flbSubmit)
    FloatingActionButton flbSubmit;

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
        DiffUtil.DiffResult result = DiffUtil
                .calculateDiff(new BaseDiffCallback<>(dailyAdapter.getData(), bean));
        dailyAdapter.setData(bean);
        result.dispatchUpdatesTo(dailyAdapter);
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
