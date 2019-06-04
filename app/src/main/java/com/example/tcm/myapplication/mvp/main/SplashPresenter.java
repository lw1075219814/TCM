package com.example.tcm.myapplication.mvp.main;

import com.example.tcm.myapplication.base.BaseRxPresenter;
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
public class SplashPresenter extends BaseRxPresenter<SplashContract.View> implements SplashContract.Presenter {

    private int maxCount = 4;

    @Inject
    public SplashPresenter() {

    }

    @Override
    public void startTimer() {
        addSubscribe(Flowable
                .intervalRange(0, maxCount, 1, 1, TimeUnit.SECONDS)
                .compose(RxUtil.<Long>rxSchedulers())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        long currentTime = maxCount - (aLong + 1);
                        mView.showCountDown(currentTime);
                        if (currentTime == 0) {
                            mView.toMain();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.toMain();
                    }
                }));
    }

    @Override
    public void cancelTimer() {
        mView.toMain();
        unSubscribe();
    }

}
