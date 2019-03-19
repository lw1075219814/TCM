package com.example.tcm.myapplication.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/2/1 17:08
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/2/1 17:08
 * @see
 */
public class BaseRxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected CompositeDisposable compositeDisposable;
    protected T mView;

    protected void unSubscribe() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }

    protected void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }

        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.add(disposable);
        }
    }

    @Override
    public void attchView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
        unSubscribe();
    }
}
