package com.example.tcm.myapplication.model.prefs;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.base.Constants;

import javax.inject.Inject;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/27 13:59
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/27 13:59
 * @see
 */
public class PreferencesHelper implements PrefsHelper {

    private final SharedPreferences mSP;

    @Inject
    public PreferencesHelper() {
        mSP = App.getInstance().getSharedPreferences(Constants.SP_NAME, Activity.MODE_PRIVATE);
    }

    @Override
    public boolean getNightModeState() {
        return mSP.getBoolean(Constants.SP_NIGHT_MODE, false);
    }

    @Override
    public void setNightModeState(boolean state) {
        mSP.edit().putBoolean(Constants.SP_NIGHT_MODE, state).apply();
    }

    @Override
    public void setCurrentItem(int item) {
        mSP.edit().putInt(Constants.SP_CURRENT_ITEM, item).apply();
    }

    @Override
    public int getCurrentItem() {
        return mSP.getInt(Constants.SP_CURRENT_ITEM, Constants.TYPE_ZHIHU);
    }

    @Override
    public void setNoPicState(boolean state) {
        mSP.edit().putBoolean(Constants.SP_NO_PIC_MODE, state).apply();
    }

    @Override
    public boolean getNoPicState() {
        return mSP.getBoolean(Constants.SP_NO_PIC_MODE, false);
    }
}
