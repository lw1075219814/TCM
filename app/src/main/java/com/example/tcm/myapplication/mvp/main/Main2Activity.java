package com.example.tcm.myapplication.mvp.main;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.base.BaseActivity;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/19 15:36
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/19 15:36
 * @see
 */
public class Main2Activity extends BaseActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void initInject() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {
        //setToolBar(((Toolbar) findViewById(R.id.toolbar)), "知乎");
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (drawerLayout.isDrawerOpen(navigationView)) {
                drawerLayout.closeDrawers();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
