package com.example.tcm.myapplication.base;

import android.text.TextUtils;

import com.example.tcm.myapplication.model.http.exception.ApiException;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/13 09:55
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/13 09:55
 * @see
 */
public abstract class BaseResSubscriber<T> extends ResourceSubscriber<T> {

    private final BaseView mView;
    private String mErrorMsg;

    public BaseResSubscriber(BaseView baseView) {
        mView = baseView;
    }

    public BaseResSubscriber(BaseView baseView, String errorMsg) {
        mView = baseView;
        mErrorMsg = errorMsg;
    }

    @Override
    public void onError(Throwable t) {
        if (mView == null) {
            return;
        }

        if (!TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (t instanceof ApiException) {
            mView.showErrorMsg(t.getMessage());
        } else if (t instanceof HttpException) {
            mView.showErrorMsg("数据加载失败");
        } else {
            mView.showErrorMsg("未知错误");
        }
    }

    @Override
    public void onComplete() {

    }

}
