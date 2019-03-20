package com.example.tcm.myapplication.ui.module;

import com.example.tcm.myapplication.base.BaseResSubscriber;
import com.example.tcm.myapplication.base.BaseRxPresenter;
import com.example.tcm.myapplication.entity.LatestDailyListBean;
import com.example.tcm.myapplication.model.DataManager;
import com.example.tcm.myapplication.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/12 17:29
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/12 17:29
 * @see
 */
public class LatestDailyPresenter extends BaseRxPresenter<LatestDailyContract.View> implements LatestDailyContract.Presenter {

    private final DataManager mDataManager;

    @Inject
    public LatestDailyPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void fetchLatestDaily() {
        mView.showLoading();
        addSubscribe(mDataManager.fetchLatestDaily()
                .compose(RxUtil.<LatestDailyListBean>rxSchedulers())
                .map(new Function<LatestDailyListBean, List<LatestDailyListBean.TopStoriesBean>>() {
                    @Override
                    public List<LatestDailyListBean.TopStoriesBean> apply(LatestDailyListBean bean) throws Exception {
                        return bean.getTop_stories();
                    }
                })
                .filter(new Predicate<List<LatestDailyListBean.TopStoriesBean>>() {
                    @Override
                    public boolean test(List<LatestDailyListBean.TopStoriesBean> topStoriesBeans) throws Exception {
                        return topStoriesBeans.size() > 0;
                    }
                })
                .subscribeWith(new BaseResSubscriber<List<LatestDailyListBean.TopStoriesBean>>(mView) {
                    @Override
                    public void onNext(List<LatestDailyListBean.TopStoriesBean> topStoriesBeanList) {
                        mView.returnLatestDaily(topStoriesBeanList);
                        mView.dismissLoading();
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        mView.dismissLoading();
                    }
                })
        );
    }
}
