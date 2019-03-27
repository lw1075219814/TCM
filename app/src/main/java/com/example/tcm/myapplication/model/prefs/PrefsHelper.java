package com.example.tcm.myapplication.model.prefs;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/27 13:57
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/27 13:57
 * @see
 */
public interface PrefsHelper {

    /**
     * 获取夜间模式状态
     *
     * @return
     */
    boolean getNightModeState();

    /**
     * 设置夜间模式
     *
     * @param state
     */
    void setNightModeState(boolean state);

    /**
     * 设置当前选中的fragment下标
     */
    void setCurrentItem(int item);

    /**
     * 获取缓存的fragment下标
     */
    int getCurrentItem();

    /**
     * 设置无图模式
     */
    void setNoPicState(boolean state);

    /**
     * 获取无图模式状态
     */
    boolean getNoPicState();
}
