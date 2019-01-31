package com.example.tcm.myapplication.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.ui.MainActivity;

import java.text.SimpleDateFormat;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2018/10/20 18:20
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/10/20 18:20
 * @see
 */
public class SplashActivity extends AppCompatActivity {

    private static final long SLEEP_TIME = 3 * 1000;

    private ValueAnimator animator;
    private TextView tvTime;
    private LinearLayout timerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //Debug.startMethodTracing("log_"+format);
        initView();
    }

    private void initView() {
        tvTime = findViewById(R.id.tv_time);
        timerView = findViewById(R.id.timer_view);

        timerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toMain();
            }
        });

        startTimer();
        //toMain();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void toMain(){
        startActivity(new Intent(this,MainActivity.class));
        cancelTimer();
        finish();

        //Debug.stopMethodTracing();
    }

    private void startTimer(){
        animator = ValueAnimator.ofInt(3, 1);
        animator.setDuration(SLEEP_TIME);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                tvTime.setText(value+"s");
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                toMain();
            }
        });
        animator.start();
    }

    private void cancelTimer(){
        if(animator != null){
            animator.cancel();
            animator = null;
        }
    }
}
