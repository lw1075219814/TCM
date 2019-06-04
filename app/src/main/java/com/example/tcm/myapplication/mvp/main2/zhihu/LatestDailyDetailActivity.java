package com.example.tcm.myapplication.mvp.main2.zhihu;

import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.Test;
import com.example.tcm.myapplication.base.BaseActivity;
import com.example.tcm.myapplication.base.Constants;
import com.example.tcm.myapplication.mvp.main.SplashPresenter;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;

import butterknife.BindView;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/15 17:35
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/15 17:35
 * @see
 */
public class LatestDailyDetailActivity extends BaseActivity<SplashPresenter> {

    private static final String URL = "http://news-at.zhihu.com/api/4/news/";

    @BindView(R.id.webView)
    com.tencent.smtt.sdk.WebView webView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private int id;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.latest_daily_detail;
    }

    @Override
    protected void initView() {
        setToolBar(toolbar, "日报详情");

        id = getIntent().getIntExtra(Constants.IT_LATESTDAILYID, 0);

        initSetting();
        //webView.loadUrl(URL + id);
        webView.loadUrl("https://baidu.com");

        webView.setWebViewClient(webViewClient);
        webView.setWebChromeClient(webChromeClient);
        webView.setDownloadListener(downloadListener);

        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
                //subscriber.onCompleted();
                subscriber.onNext(2);
                //subscriber.onCompleted();
                subscriber.onNext(3);
                subscriber.onCompleted();
            }
        }).filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                Log.d("test filter", "ok");
                return integer > 1;
            }
        }).doOnCompleted(new Action0() {
            @Override
            public void call() {
                Log.d("test doOnCompleted", "ok");
            }
        }).doOnError(new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d("test doOnError", "ok");
            }
        }).doOnNext(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d("test doOnNext1", integer + "");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.d("test onCompleted", "ok");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("test onError", "ok");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d("test onNext", integer + "");
                    }
                });

        List<String> strings = Arrays.asList("1", "2", "3");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            strings.stream().map(s -> s.toLowerCase());
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            strings.stream().map(String::toLowerCase);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            strings.forEach(s -> Log.d("forEach", s));
        }

        BiConsumer<Test, String> eat1 = Test::eat;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            eat1.accept(new Test(), "haha'");
        }

        Consumer<Test> consumer = Test::todo;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            consumer.accept(new Test());
        }

        Consumer<Test> consumer1 = Test::todo;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            consumer.accept(new Test());
        }

        BiConsumer<Test, String> consumer2 = Test::todo;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            consumer2.accept(new Test(), "1");
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            strings.forEach((String str) -> str.toLowerCase());
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            strings.forEach(str -> {
                str.toLowerCase();
                str.toLowerCase();
            });
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Collections.sort(strings, (String str1, String str2) -> str1.compareTo(str2));
        }
    }

    private void initSetting() {
        com.tencent.smtt.sdk.WebSettings webSetting = webView.getSettings();
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(false);
        // webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        // webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        webSetting.setAppCachePath(this.getDir("appcache", 0).getPath());
        webSetting.setDatabasePath(this.getDir("databases", 0).getPath());
        webSetting.setGeolocationDatabasePath(this.getDir("geolocation", 0)
                .getPath());
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        // webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        // webSetting.setPreFectch(true);

    }

    private com.tencent.smtt.sdk.WebViewClient webViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String s) {
            webView.loadUrl(s);
            return true;
        }
    };

    private com.tencent.smtt.sdk.WebChromeClient webChromeClient = new WebChromeClient() {
        @Override
        public boolean onJsAlert(WebView webView, String s, String s1, JsResult jsResult) {
            return super.onJsAlert(webView, s, s1, jsResult);
        }

        @Override
        public boolean onJsConfirm(WebView webView, String s, String s1, JsResult jsResult) {
            return super.onJsConfirm(webView, s, s1, jsResult);
        }

        @Override
        public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
        }

        @Override
        public void onHideCustomView() {
            super.onHideCustomView();
        }
    };

    private DownloadListener downloadListener = new DownloadListener() {
        @Override
        public void onDownloadStart(String s, String s1, String s2, String s3, long l) {

        }
    };
}
