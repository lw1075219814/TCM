package com.example.tcm.myapplication.mvp;

import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.RxBus;
import com.example.tcm.myapplication.base.SimpleFragment;
import com.example.tcm.myapplication.model.event.NightModeEvent;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/20 15:16
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/20 15:16
 * @see
 */
public class SettingFragment extends SimpleFragment {

    private LinearLayout llAutoCache;
    private AppCompatCheckBox cbAutoCache;
    private LinearLayout llNightMode;
    private AppCompatCheckBox cbNightMode;

    public static SettingFragment getInstance() {
        return new SettingFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initView(View view) {
        llAutoCache = view.findViewById(R.id.ll_auto_cache);
        cbAutoCache = view.findViewById(R.id.cb_auto_cache);
        llNightMode = view.findViewById(R.id.ll_night_mode);
        cbNightMode = view.findViewById(R.id.cb_night_mode);
    }

    @Override
    protected void initListener() {
        super.initListener();
        llAutoCache.setOnClickListener(onClickListener);
        cbAutoCache.setOnCheckedChangeListener(onCheckedChangeListener);
        llNightMode.setOnClickListener(onClickListener);
        cbNightMode.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_auto_cache:
                    cbAutoCache.setChecked(!cbAutoCache.isChecked());
                    break;
                case R.id.ll_night_mode:
                    cbNightMode.setChecked(!cbNightMode.isChecked());
                    break;
                default:
                    break;
            }
        }
    };

    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.cb_auto_cache:

                    break;
                case R.id.cb_night_mode:
                    setNightMode(isChecked);
                    break;
                default:
                    break;
            }
        }
    };

    private void setNightMode(boolean isChecked) {
        NightModeEvent nightModeEvent = new NightModeEvent();
        nightModeEvent.setNightMode(isChecked);
        RxBus.get().post(nightModeEvent);
    }
}
