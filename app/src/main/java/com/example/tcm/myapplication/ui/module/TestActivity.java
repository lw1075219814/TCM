package com.example.tcm.myapplication.ui.module;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcm.dagger2.bean.Boy;
import com.example.tcm.dagger2.bean.Girl;
import com.example.tcm.dagger2.bean.Man;
import com.example.tcm.dagger2.bean.Proxy;
import com.example.tcm.dagger2.bean.Woman;
import com.example.tcm.dagger2.component.DaggerManComponent;
import com.example.tcm.dagger2.component.ManComponent;
import com.example.tcm.dagger2.module.ManModule;
import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.base.BaseActivity;
import com.example.tcm.myapplication.mvp.main.SplashPresenter;

import java.util.Random;

import javax.inject.Inject;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2018/11/1 14:58
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/11/1 14:58
 * @see
 */
public class TestActivity extends BaseActivity<SplashPresenter> {

    private static final String TAG = TestActivity.class.getSimpleName();

    private Random random = new Random();

    private TextView tvResult;

    @Inject
    Man man;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //tvResult = findViewById(R.id.tvResult);
        //Button btnAdd = findViewById(R.id.btnAdd);

//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //TestActivity.this.presenter.addData();
//                //TestActivity.this.presenter.setResult();
//            }
//        });

        ManComponent component = DaggerManComponent
                .builder()
                .manModule(new ManModule())
                .build();

        Proxy proxy = component.getProxy();
        proxy.eat();
        proxy.speak();

        Man man = component.getMan();
        Woman woman = component.getWoman();

        component.getBoy();
        component.getGirl();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_dagger;
    }

    @Override
    protected void initView() {
        Toast.makeText(this, man.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

}
