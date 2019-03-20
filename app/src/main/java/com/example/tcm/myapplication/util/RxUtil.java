package com.example.tcm.myapplication.util;


import com.example.tcm.myapplication.model.http.exception.ApiException;
import com.example.tcm.myapplication.model.http.response.GankResponse;
import com.example.tcm.myapplication.model.http.response.GoldResponse;
import com.example.tcm.myapplication.model.http.response.MyResponse;
import com.example.tcm.myapplication.model.http.response.WXResponse;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
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

    private static final String ERRORMSG = "服务器返回error";

    /**
     * 线程切换处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulers() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 返回结果处理
     */
    public static <T> FlowableTransformer<MyResponse<T>, T> handleMyResponse() {
        return new FlowableTransformer<MyResponse<T>, T>() {
            @Override
            public Publisher<T> apply(Flowable<MyResponse<T>> upstream) {
                return upstream.flatMap(new Function<MyResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(MyResponse<T> tMyResponse) throws Exception {
                        if (tMyResponse.getCode() == 200) {
                            return sendData(tMyResponse.getData());
                        }
                        return throwException(tMyResponse.getCode(), ERRORMSG);
                    }
                });
            }
        };
    }

    /**
     * 返回结果处理
     */
    public static <T> FlowableTransformer<GankResponse<T>, T> handleGankResponse() {
        return new FlowableTransformer<GankResponse<T>, T>() {
            @Override
            public Publisher<T> apply(Flowable<GankResponse<T>> upstream) {
                return upstream.flatMap(new Function<GankResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(GankResponse<T> tGankResponse) throws Exception {
                        if (!tGankResponse.isError()) {
                            return sendData(tGankResponse.getResults());
                        }
                        return throwException(ERRORMSG);
                    }
                });
            }
        };
    }

    /**
     * 返回结果处理
     */
    public static <T> FlowableTransformer<GoldResponse<T>, T> handleGoldResponse() {
        return new FlowableTransformer<GoldResponse<T>, T>() {
            @Override
            public Publisher<T> apply(Flowable<GoldResponse<T>> upstream) {
                return upstream.flatMap(new Function<GoldResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(GoldResponse<T> tGoldResponse) throws Exception {
                        if (tGoldResponse.getResults() != null) {
                            return sendData(tGoldResponse.getResults());
                        }
                        return throwException(ERRORMSG);
                    }
                });
            }
        };
    }

    /**
     * 返回结果处理
     */
    public static <T> FlowableTransformer<WXResponse<T>, T> handWXResponse() {
        return new FlowableTransformer<WXResponse<T>, T>() {
            @Override
            public Publisher<T> apply(Flowable<WXResponse<T>> upstream) {
                return upstream.flatMap(new Function<WXResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(WXResponse<T> twxResponse) throws Exception {
                        if (twxResponse.getCode() == 200) {
                            return sendData(twxResponse.getNewslist());
                        }
                        return throwException(twxResponse.getCode(), twxResponse.getMsg());
                    }
                });
            }
        };
    }

    /**
     * 发送Flowable数据
     */
    private static <T> Flowable<T> sendData(final T data) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(data);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }

    private static <T> Flowable<T> throwException(final String errorMsg) {
        return throwException(-1, errorMsg);
    }

    private static <T> Flowable<T> throwException(final int code, final String errorMsg) {
        return Flowable.error(new ApiException(code, errorMsg));
    }

}
