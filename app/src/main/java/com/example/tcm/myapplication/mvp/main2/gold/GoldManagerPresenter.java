package com.example.tcm.myapplication.mvp.main2.gold;

import com.example.tcm.myapplication.RxBus;
import com.example.tcm.myapplication.base.BaseResSubscriber;
import com.example.tcm.myapplication.base.BaseRxPresenter;
import com.example.tcm.myapplication.bean.GoldBean;
import com.example.tcm.myapplication.bean.GoldItemBean;
import com.example.tcm.myapplication.model.DataManager;
import com.example.tcm.myapplication.util.RxUtil;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import rx.Observable;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/4/29 10:00
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/4/29 10:00
 * @see
 */
public class GoldManagerPresenter extends BaseRxPresenter<GoldContract.View> implements GoldContract.Presenter {

    private final DataManager dataManager;

    @Inject
    public GoldManagerPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attchView(GoldContract.View view) {
        super.attchView(view);
        registerEvent();
    }

    private void registerEvent() {
        addSubscribe(RxBus.get().toFlowable(GoldBean.class)
                .compose(RxUtil.rxSchedulers())
                .subscribeWith(new BaseResSubscriber<GoldBean>(mView) {
                    @Override
                    public void onNext(GoldBean bean) {
                        dataManager.updateGoldItems(bean.getBeans());
                        mView.returnData(bean.getBeans());
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        mView.onError(t.getMessage());
                    }
                }));
    }

    @Override
    public void getGoldItems() {
        addSubscribe(dataManager.getGoldTtems()
                .filter(new Predicate<List<GoldItemBean>>() {
                    @Override
                    public boolean test(List<GoldItemBean> itemBeans) throws Exception {
                        return itemBeans.size() > 0;
                    }
                }).defaultIfEmpty(defaultGoldItems())
                .compose(RxUtil.rxSchedulers())
                .subscribeWith(new BaseResSubscriber<List<GoldItemBean>>(mView) {

                    @Override
                    public void onNext(List<GoldItemBean> itemBeans) {
                        mView.returnData(itemBeans);
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                    }
                }));
    }

    @Override
    public void updateGoldItems(List<GoldItemBean> items) {
        dataManager.updateGoldItems(items);
    }

    private List<GoldItemBean> defaultGoldItems() {
        return Arrays.asList(
                new GoldItemBean(0, true),
                new GoldItemBean(1, true),
                new GoldItemBean(2, true),
                new GoldItemBean(3, true),
                new GoldItemBean(4, true),
                new GoldItemBean(5, true),
                new GoldItemBean(6, true),
                new GoldItemBean(7, true));
    }
}
