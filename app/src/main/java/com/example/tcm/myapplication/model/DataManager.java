package com.example.tcm.myapplication.model;

import com.example.tcm.myapplication.bean.GoldItemBean;
import com.example.tcm.myapplication.bean.LatestDailyDetailBean;
import com.example.tcm.myapplication.bean.LatestDailyListBean;
import com.example.tcm.myapplication.bean.WeChatBean;
import com.example.tcm.myapplication.model.db.DBHelper;
import com.example.tcm.myapplication.model.http.HttpHelper;
import com.example.tcm.myapplication.model.http.response.WXResponse;
import com.example.tcm.myapplication.model.prefs.PrefsHelper;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/11 11:04
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/11 11:04
 * @see
 */
public class DataManager implements HttpHelper, DBHelper, PrefsHelper {

    private final HttpHelper httpHelper;
    private final DBHelper dbHelper;
    private final PrefsHelper prefsHelper;

    public DataManager(HttpHelper httpHelper, DBHelper dbHelper, PrefsHelper prefsHelper) {
        this.httpHelper = httpHelper;
        this.dbHelper = dbHelper;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public Flowable<LatestDailyListBean> fetchLatestDaily() {
        return httpHelper.fetchLatestDaily();
    }

    @Override
    public Flowable<LatestDailyDetailBean> fetchLatestDailyDetail() {
        return httpHelper.fetchLatestDailyDetail();
    }

    @Override
    public Flowable<WXResponse<List<WeChatBean>>> getWeChatData(int num, int page) {
        return httpHelper.getWeChatData(num, page);
    }

    @Override
    public boolean getNightModeState() {
        return prefsHelper.getNightModeState();
    }

    @Override
    public void setNightModeState(boolean state) {
        prefsHelper.setNightModeState(state);
    }

    @Override
    public void setCurrentItem(int item) {
        prefsHelper.setCurrentItem(item);
    }

    @Override
    public int getCurrentItem() {
        return prefsHelper.getCurrentItem();
    }

    @Override
    public void setNoPicState(boolean state) {
        prefsHelper.setNoPicState(state);
    }

    @Override
    public boolean getNoPicState() {
        return prefsHelper.getNoPicState();
    }

    @Override
    public void updateGoldItems(List<GoldItemBean> items) {
        dbHelper.updateGoldItems(items);
    }

    @Override
    public Flowable<List<GoldItemBean>> getGoldTtems() {
        return dbHelper.getGoldTtems();
    }
}
