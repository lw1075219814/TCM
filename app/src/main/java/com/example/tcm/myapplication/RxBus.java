package com.example.tcm.myapplication;

import com.example.tcm.myapplication.util.RxUtil;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/1/25 13:41
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/1/25 13:41
 * @see
 */
public class RxBus {

    private final FlowableProcessor<Object> bus;

    private RxBus() {
        // PublishSubject只会把在订阅发生的时间点之后来自原始Flowable的数据发射给观察者
        bus = PublishProcessor.create().toSerialized();
    }

    private static class Holder {
        private static final RxBus INSTANCE = new RxBus();
    }

    public static RxBus get() {
        return Holder.INSTANCE;
    }

    /**
     * 提供一个新的事件
     *
     * @param obj
     */
    public void post(Object obj) {
        bus.onNext(obj);
    }

    /**
     * 根据传递的类型返回一个被观察者
     */
    public <T> Flowable<T> toFlowable(Class<T> eventType) {
        return bus.ofType(eventType);
    }

    /**
     * 默认封装
     */
    public <T> Disposable toDefaultFlowable(Class<T> eventType, Consumer<T> consumer) {
        return bus.ofType(eventType).compose(RxUtil.<T>rxSchedulers()).subscribe(consumer);
    }
}
