package com.example.tcm.myapplication.mvp;

import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.RxBus;
import com.example.tcm.myapplication.base.SimpleFragment;
import com.example.tcm.myapplication.model.event.NightModeEvent;
import com.example.tcm.myapplication.model.event.NoPicEvent;
import com.example.tcm.myapplication.model.prefs.PreferencesHelper;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

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

    @BindView(R.id.ll_auto_cache)
    LinearLayout llAutoCache;
    @BindView(R.id.cb_auto_cache)
    AppCompatCheckBox cbAutoCache;
    @BindView(R.id.ll_night_mode)
    LinearLayout llNightMode;
    @BindView(R.id.cb_night_mode)
    AppCompatCheckBox cbNightMode;
    @BindView(R.id.ll_no_pic)
    LinearLayout llNoPic;
    @BindView(R.id.cb_no_pic)
    AppCompatCheckBox cbNoPic;

    public static SettingFragment getInstance() {
        return new SettingFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initView(View view) {
        PreferencesHelper preferencesHelper = App.
                getInstance().getAppComponent().getPreferencesHelper();
        cbNoPic.setChecked(preferencesHelper.getNoPicState());
        cbNightMode.setChecked(preferencesHelper.getNightModeState());
    }

    @OnClick({R.id.ll_auto_cache, R.id.ll_night_mode})
    void OnClick(View view) {
        switch (view.getId()) {
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

    @OnCheckedChanged({R.id.cb_auto_cache, R.id.cb_no_pic, R.id.cb_night_mode})
    void OnCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()) {
            case R.id.cb_auto_cache:

                break;
            case R.id.cb_no_pic:
                setNoPic(isChecked);
                break;
            case R.id.cb_night_mode:
                setNightMode(isChecked);
                break;
            default:
                break;
        }
    }

    private void setNoPic(boolean isChecked) {
        NoPicEvent noPicEvent = new NoPicEvent(isChecked);
        RxBus.get().post(noPicEvent);
    }

    private void setNightMode(boolean isChecked) {
        NightModeEvent nightModeEvent = new NightModeEvent(isChecked);
        RxBus.get().post(nightModeEvent);
    }
}
