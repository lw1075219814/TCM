package com.example.tcm.myapplication.mvp.main2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.base.BaseActivity;
import com.example.tcm.myapplication.base.Constants;
import com.example.tcm.myapplication.model.prefs.PreferencesHelper;
import com.example.tcm.myapplication.mvp.AboutFragment;
import com.example.tcm.myapplication.mvp.SettingFragment;
import com.example.tcm.myapplication.mvp.ZhihuFragment;

import javax.inject.Inject;

import butterknife.BindView;
import me.yokeyword.fragmentation.ISupportFragment;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/19 15:36
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/19 15:36
 * @see
 */
public class Main2Activity extends BaseActivity<Main2Persenter> implements Main2Contract.View {

    @Inject
    PreferencesHelper preferencesHelper;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigation)
    NavigationView navigationView;

    private ActionBarDrawerToggle drawerToggle;
    private ZhihuFragment zhihuFragment;
    private SettingFragment settingFragment;
    private AboutFragment aboutFragment;
    private MenuItem currentMenuItem;
    private int currentItem;
    private int hideItem;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main2;
    }

    /**
     * recreate，需处理夜间模式
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            mPresener.setNightModeState(false);
        } else {
            currentItem = mPresener.getCurrentItem();
            hideItem = Constants.TYPE_ZHIHU;
            showHideFragment(getFragment(currentItem), getFragment(hideItem));
            navigationView.getMenu().findItem(getItem(currentItem)).setChecked(true);
            toolbar.setTitle(navigationView.getMenu().findItem(getItem(currentItem)).getTitle());
            hideItem = currentItem;
        }
    }

    @Override
    protected void initView() {
        MenuItem menuItem = navigationView.getMenu().findItem(R.id.zhihu);

        setToolBar(toolbar, "知乎");
        drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.open, R.string.close);
        drawerToggle.syncState();

        zhihuFragment = ZhihuFragment.getInstance();
        settingFragment = SettingFragment.getInstance();
        aboutFragment = AboutFragment.getInstance();
        currentItem = Constants.TYPE_ZHIHU;
        hideItem = Constants.TYPE_ZHIHU;
        currentMenuItem = menuItem;

        ISupportFragment[] fragments = {zhihuFragment, settingFragment, aboutFragment};
        loadMultipleRootFragment(R.id.fl_container, 0, fragments);

        boolean isNightModeState = preferencesHelper.getNightModeState();
        //setNightMode(isNightModeState);
    }

    @Override
    protected void initListener() {
        navigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);
        drawerLayout.addDrawerListener(drawerToggle);
    }

    private NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    currentMenuItem.setChecked(false);
                    switch (menuItem.getItemId()) {
                        case R.id.zhihu:
                            currentItem = Constants.TYPE_ZHIHU;
                            break;
                        case R.id.collection:
                            currentItem = Constants.TYPE_COLLECTION;
                            break;
                        case R.id.setting:
                            currentItem = Constants.TYPE_SETTING;
                            break;
                        case R.id.about:
                            currentItem = Constants.TYPE_ABOUT;
                            break;
                        default:
                            break;
                    }
                    setToolBar(toolbar, menuItem.getTitle().toString());
                    showHideFragment(getFragment(currentItem), getFragment(hideItem));
                    setCurrentMenuItem(menuItem);
                    hideItem = currentItem;
                    mPresener.setCurrentItem(currentItem);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    return true;
                }
            };

    private void setCurrentMenuItem(MenuItem menuItem) {
        menuItem.setChecked(true);
        currentMenuItem = menuItem;
    }

    private ISupportFragment getFragment(int currentItem) {
        if (currentItem == Constants.TYPE_ZHIHU) {
            return zhihuFragment;
        } else if (currentItem == Constants.TYPE_COLLECTION) {
            return zhihuFragment;
        } else if (currentItem == Constants.TYPE_SETTING) {
            return settingFragment;
        } else if (currentItem == Constants.TYPE_ABOUT) {
            return aboutFragment;
        } else {
            return zhihuFragment;
        }
    }

    private int getItem(int currentItem) {
        if (currentItem == Constants.TYPE_ZHIHU) {
            return R.id.zhihu;
        } else if (currentItem == Constants.TYPE_COLLECTION) {
            return R.id.collection;
        } else if (currentItem == Constants.TYPE_SETTING) {
            return R.id.setting;
        } else if (currentItem == Constants.TYPE_ABOUT) {
            return R.id.about;
        } else {
            return R.id.zhihu;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (drawerLayout.isDrawerOpen(navigationView)) {
                drawerLayout.closeDrawers();
            } else {
                showExitDialog();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void showExitDialog() {
        new AlertDialog
                .Builder(this)
                .setTitle("提示")
                .setMessage("确定退出TCM吗?")
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        App.getInstance().exitApp();
                    }
                }).show();
    }

}
