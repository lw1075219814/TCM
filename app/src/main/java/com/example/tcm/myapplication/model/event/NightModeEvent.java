package com.example.tcm.myapplication.model.event;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/20 16:35
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/20 16:35
 * @see
 */
public class NightModeEvent {
    private boolean isNightMode;

    public NightModeEvent() {
    }

    public NightModeEvent(boolean isNightMode) {
        this.isNightMode = isNightMode;
    }

    public boolean isNightMode() {
        return isNightMode;
    }

    public void setNightMode(boolean nightMode) {
        isNightMode = nightMode;
    }
}
