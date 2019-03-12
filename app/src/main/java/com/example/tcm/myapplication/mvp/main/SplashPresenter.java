package com.example.tcm.myapplication.mvp.main;

import com.example.tcm.myapplication.base.RxPresenter;
import com.example.tcm.myapplication.model.DataManager;
import com.example.tcm.myapplication.mvp.main.SplashContract;
import com.example.tcm.myapplication.util.RxUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/2/2 14:01
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/2/2 14:01
 * @see
 */
public class SplashPresenter extends RxPresenter<SplashContract.View> implements SplashContract.Presenter {

    /**
     * 延迟时间
     */
    private static final long DELAY_TIME = 2 * 1000;

    private final DataManager mDataManager;

    @Inject
    public SplashPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void startTimer() {
        addSubscribe(Flowable.timer(DELAY_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulers())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        mView.toMain();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.toMain();
                    }
                }));
    }

}
