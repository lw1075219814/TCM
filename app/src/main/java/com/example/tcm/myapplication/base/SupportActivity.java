package com.example.tcm.myapplication.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.tcm.myapplication.App;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/2/1 17:41
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/2/1 17:41
 * @see
 */
public abstract class SupportActivity extends AppCompatActivity {

    //private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        //unbinder = ButterKnife.bind(this);
        onViewCreated();
        initView();
        App.getInstance().addActivity(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void setToolBar(Toolbar toolBar, String title) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolBar.setTitle(title);
            setSupportActionBar(toolBar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            toolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    protected void onViewCreated() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unbinder.unbind();
        App.getInstance().removeActivity(this);
    }

    protected abstract int setLayoutId();

    protected abstract void initView();

}
