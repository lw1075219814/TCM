package com.example.tcm.myapplication.ui.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.entity.User;
import com.example.tcm.myapplication.mvp.TaskContract;
import com.example.tcm.myapplication.mvp.TaskPresenter;

import java.util.List;
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
public class TestActivity extends AppCompatActivity implements TaskContract.View{

    private static final String TAG = TestActivity.class.getSimpleName();

    private Random random = new Random();

    @Inject
    User user;
    private TaskContract.Presenter presenter;
    private TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        tvResult = findViewById(R.id.tvResult);
        Button btnAdd = findViewById(R.id.btnAdd);

        presenter = new TaskPresenter(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestActivity.this.presenter.addData();
                TestActivity.this.presenter.setResult();
            }
        });

        for (int i = 0; i < 10; i++) {
            i ++;
        }
    }

    @Override
    public void showProgress() {
        Log.e(TAG,"showProgress");
    }

    @Override
    public void hideProgress() {
        Log.e(TAG,"hideProgress");
    }

    private int count;

    @Override
    public String getData() {
        return String.valueOf(random.nextBoolean());
    }

    @Override
    public void showResult(List list) {
        tvResult.setText(list.toString());
    }

    @Override
    public void setPresenter(TaskContract.Presenter persenter) {
        presenter = persenter;
    }
}
