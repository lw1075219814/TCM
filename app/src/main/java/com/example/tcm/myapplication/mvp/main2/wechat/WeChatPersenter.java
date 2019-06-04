package com.example.tcm.myapplication.mvp.main2.wechat;

import com.example.tcm.myapplication.base.BaseResSubscriber;
import com.example.tcm.myapplication.base.BaseRxPresenter;
import com.example.tcm.myapplication.bean.WeChatBean;
import com.example.tcm.myapplication.model.DataManager;
import com.example.tcm.myapplication.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/4/23 10:43
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/4/23 10:43
 * @see
 */
public class WeChatPersenter extends BaseRxPresenter<WeChatContract.View> implements WeChatContract.Presenter {

    /**
     * 新闻加载条数
     */
    private static final int MAX_COUNT = 1;

    /**
     * 当前新闻页数
     */
    private int currentPage = 1;

    private DataManager dataManager;

    @Inject
    public WeChatPersenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getWeChatData() {
        mView.setRefreshing(true);
        currentPage = 1;
        addSubscribe(dataManager.getWeChatData(MAX_COUNT, currentPage)
                .compose(RxUtil.rxSchedulers())
                .compose(RxUtil.handWXResponse())
                .subscribeWith(new BaseResSubscriber<List<WeChatBean>>(mView) {
                    @Override
                    public void onNext(List<WeChatBean> list) {
                        mView.returnData(list);
                        mView.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        mView.onError(t.getMessage());
                        mView.setRefreshing(false);
                    }
                }));
    }

    public void getWeChatMoreData() {
        mView.setRefreshing(true);
        currentPage++;
        addSubscribe(dataManager.getWeChatData(MAX_COUNT, currentPage)
                .compose(RxUtil.rxSchedulers())
                .compose(RxUtil.handWXResponse())
                .subscribeWith(new BaseResSubscriber<List<WeChatBean>>(mView) {
                    @Override
                    public void onNext(List<WeChatBean> list) {
                        mView.returnMoreData(list);
                        mView.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        mView.onMoreError(t.getMessage());
                        mView.setRefreshing(false);
                    }
                }));
    }

}
