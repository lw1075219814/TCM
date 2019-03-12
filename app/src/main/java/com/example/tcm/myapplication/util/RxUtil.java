package com.example.tcm.myapplication.util;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/2/2 14:34
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/2/2 14:34
 * @see
 */
public class RxUtil {

    public static <T> FlowableTransformer<T, T> rxSchedulers() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.observeOn(Schedulers.io())
                        .subscribeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
