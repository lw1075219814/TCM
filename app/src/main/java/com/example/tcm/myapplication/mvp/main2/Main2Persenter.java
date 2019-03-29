package com.example.tcm.myapplication.mvp.main2;

import com.example.tcm.myapplication.RxBus;
import com.example.tcm.myapplication.base.BaseResSubscriber;
import com.example.tcm.myapplication.base.BaseRxPresenter;
import com.example.tcm.myapplication.model.DataManager;
import com.example.tcm.myapplication.model.event.NightModeEvent;
import com.example.tcm.myapplication.model.event.NoPicEvent;
import com.example.tcm.myapplication.util.RxUtil;

import javax.inject.Inject;

import io.reactivex.functions.Function;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/20 16:40
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/20 16:40
 * @see
 */
public class Main2Persenter extends BaseRxPresenter<Main2Contract.View> implements Main2Contract.Presenter {

    private final DataManager mDataManager;

    @Inject
    public Main2Persenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attchView(Main2Contract.View view) {
        super.attchView(view);
        registerEvent();
    }

    private void registerEvent() {
        nightEvent();
        noPicEvent();
    }

    private void nightEvent() {
        addSubscribe(RxBus.get()
                .toFlowable(NightModeEvent.class)
                .compose(RxUtil.rxSchedulers())
                .map(new Function<NightModeEvent, Boolean>() {
                    @Override
                    public Boolean apply(NightModeEvent nightModeEvent) throws Exception {
                        return nightModeEvent.isNightMode();
                    }
                }).subscribeWith(new BaseResSubscriber<Boolean>(mView, "切换模式失败") {
                    @Override
                    public void onNext(Boolean aBoolean) {
                        mView.setNightMode(aBoolean);
                        mDataManager.setNightModeState(aBoolean);
                        //mView.dismissLoading();
                    }
                }));
    }

    private void noPicEvent() {
        addSubscribe(RxBus.get()
                .toFlowable(NoPicEvent.class)
                .compose(RxUtil.rxSchedulers())
                .map(new Function<NoPicEvent, Boolean>() {
                    @Override
                    public Boolean apply(NoPicEvent noPicEvent) throws Exception {
                        return noPicEvent.isNoPic();
                    }
                }).subscribeWith(new BaseResSubscriber<Boolean>(mView) {
                    @Override
                    public void onNext(Boolean aBoolean) {
                        mDataManager.setNoPicState(aBoolean);
                    }
                }));
    }

    @Override
    public void setNightModeState(boolean state) {
        mDataManager.setNightModeState(state);
    }

    @Override
    public void setCurrentItem(int index) {
        mDataManager.setCurrentItem(index);
    }

    @Override
    public int getCurrentItem() {
        return mDataManager.getCurrentItem();
    }

}
