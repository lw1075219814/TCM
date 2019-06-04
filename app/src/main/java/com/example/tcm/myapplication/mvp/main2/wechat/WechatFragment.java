package com.example.tcm.myapplication.mvp.main2.wechat;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.adapter.WeChatAdapter;
import com.example.tcm.myapplication.base.BaseFragment;
import com.example.tcm.myapplication.bean.WeChatBean;
import com.example.tcm.myapplication.mvp.main2.zhihu.BaseDiffCallback;
import com.example.tcm.myapplication.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/4/22 11:47
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/4/22 11:47
 * @see
 */
public class WechatFragment extends BaseFragment<WeChatPersenter>
        implements WeChatContract.View {

    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private List<WeChatBean> all = new ArrayList<>();

    private WeChatAdapter adapter;

    /**
     * 是否刷新
     */
    private boolean isLoadingMore = false;

    public static WechatFragment getInstance() {
        return new WechatFragment();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected void initView(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new WeChatAdapter(R.layout.item_wechat, all);
        recyclerView.setAdapter(adapter);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getWeChatData();
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItemPosition = ((LinearLayoutManager)
                        recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                int itemCount = recyclerView.getLayoutManager().getItemCount();

                if (lastVisibleItemPosition >= itemCount - 1 && dy > 0) {
                    if (!isLoadingMore) {
                        isLoadingMore = true;
                        mPresenter.getWeChatMoreData();
                    }
                }
            }
        });

        mPresenter.getWeChatData();
    }

    @Override
    public void setRefreshing(boolean refreshing) {
        refreshLayout.setRefreshing(refreshing);
    }

    @Override
    public void returnData(List<WeChatBean> datas) {
        all.clear();
        //all = datas;
        datas.get(0).setTitle(String.valueOf(new Random().nextInt(100)));
        DiffUtil.DiffResult result = DiffUtil
                .calculateDiff(new BaseDiffCallback<>(adapter.getData(), all));
        all.addAll(datas);
        adapter.addData(all);
        result.dispatchUpdatesTo(adapter);
    }

    @Override
    public void returnMoreData(List<WeChatBean> moreDatas) {
        all.addAll(moreDatas);
        DiffUtil.DiffResult result = DiffUtil
                .calculateDiff(new BaseDiffCallback<>(adapter.getData(), all));
        adapter.addData(moreDatas);
        result.dispatchUpdatesTo(adapter);
        isLoadingMore = false;
    }

    @Override
    public void onError(String msg) {
        ToastUtil.shortShow(msg);
    }

    @Override
    public void onMoreError(String msg) {
        ToastUtil.shortShow(msg);
        isLoadingMore = false;
    }
}
