package com.example.tcm.myapplication.mvp.main2.wechat;

import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.base.BaseActivity;
import com.example.tcm.myapplication.base.Constants;
import com.example.tcm.myapplication.model.prefs.PreferencesHelper;
import com.example.tcm.myapplication.mvp.main.SplashPresenter;
import com.example.tcm.myapplication.util.SystemUtil;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/4/26 11:16
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/4/26 11:16
 * @see
 */
public class WeChatDetailaActivity extends BaseActivity<SplashPresenter> {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void initInject() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_wechat_detail;
    }

    @Override
    protected void initView() {
        PreferencesHelper preferencesHelper = App.getInstance()
                .getAppComponent().getPreferencesHelper();

        String url = getIntent().getStringExtra(Constants.WECHAT_URL);
        String title = getIntent().getStringExtra(Constants.WECHAT_TITLE);

        setToolBar(toolbar, title);

        WebSettings settings = webView.getSettings();
        if (preferencesHelper.getNoPicState()) {
            settings.setBlockNetworkImage(true);
        }
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        if (SystemUtil.isNetworkConnected()) {
            settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        } else {
            settings.setCacheMode(WebSettings.LOAD_CACHE_ONLY);
        }
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setSupportZoom(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                webView.loadUrl(s);
                return true;
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView webView, String s) {
                super.onReceivedTitle(webView, s);
                setTitle(s);
            }
        });

        webView.loadUrl(url);
    }

    @Override
    protected void navigationOnClick(View view) {
        super.navigationOnClick(view);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
