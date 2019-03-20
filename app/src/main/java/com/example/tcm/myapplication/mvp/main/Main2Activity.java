package com.example.tcm.myapplication.mvp.main;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.base.BaseActivity;
import com.example.tcm.myapplication.mvp.SettingFragment;
import com.example.tcm.myapplication.mvp.ZhihuFragment;

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

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ZhihuFragment zhihuFragment;
    private SettingFragment settingFragment;

    private ISupportFragment currentFragment = null;
    private MenuItem currentMenuItem = null;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation);
        MenuItem menuItem = navigationView.getMenu().findItem(R.id.zhihu);

        setToolBar(toolbar, "知乎");

        zhihuFragment = ZhihuFragment.getInstance();
        settingFragment = SettingFragment.getInstance();
        currentFragment = zhihuFragment;
        currentMenuItem = menuItem;
        loadMultipleRootFragment(R.id.fl_container, 0, currentFragment, settingFragment);
    }

    @Override
    protected void initListener() {
        toolbar.setNavigationOnClickListener(onClickListener);
        navigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (drawerLayout.isDrawerOpen(navigationView)) {
                drawerLayout.closeDrawers();
            } else {
                drawerLayout.openDrawer(navigationView);
            }
        }
    };

    private NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    currentMenuItem.setChecked(false);
                    switch (menuItem.getItemId()) {
                        case R.id.zhihu:
                            setCurrentFragment(zhihuFragment);
                            break;
                        case R.id.setting:
                            setCurrentFragment(settingFragment);
                            break;
                        case R.id.about:
                            break;
                        default:
                            break;
                    }
                    setToolBar(toolbar, menuItem.getTitle().toString());
                    setCurrentMenuItem(menuItem);
                    drawerLayout.closeDrawers();
                    return true;
                }
            };

    private void setCurrentFragment(ISupportFragment showFragemnt) {
        showHideFragment(showFragemnt, currentFragment);
        currentFragment = showFragemnt;
    }

    private void setCurrentMenuItem(MenuItem menuItem) {
        menuItem.setChecked(true);
        currentMenuItem = menuItem;
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
