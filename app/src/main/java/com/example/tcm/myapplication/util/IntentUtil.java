package com.example.tcm.myapplication.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

import com.example.tcm.myapplication.base.Constants;
import com.example.tcm.myapplication.bean.GoldItemBean;
import com.example.tcm.myapplication.mvp.main2.Main2Activity;
import com.example.tcm.myapplication.mvp.main2.gold.GoldManagerActivity;
import com.example.tcm.myapplication.mvp.main2.wechat.WeChatDetailaActivity;
import com.example.tcm.myapplication.ui.DetailActivity;
import com.example.tcm.myapplication.ui.ListActivity;
import com.example.tcm.myapplication.mvp.main2.zhihu.LatestDailyDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/15 17:03
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/15 17:03
 * @see
 */
public class IntentUtil {

    /**
     * 跳转到列表页面
     *
     * @param groupPosition
     */
    public static void toList(Context context, int groupPosition) {
        Intent groupIntent = new Intent(context, ListActivity.class);
        groupIntent.putExtra(Constants.IT_GROUPPOSITION, groupPosition);
        context.startActivity(groupIntent);
    }

    /**
     * 跳转到详情页面
     *
     * @param groupPosition
     * @param childPosition
     */
    public static void toDetail(Context context, int groupPosition, int childPosition, String text) {
        Intent childIntent = new Intent(context, DetailActivity.class);
        childIntent.putExtra(Constants.IT_GROUPPOSITION, groupPosition);
        childIntent.putExtra(Constants.IT_CHILDPOSITION, childPosition);
        childIntent.putExtra(Constants.IT_TITLE, text);
        context.startActivity(childIntent);
    }

    /**
     * 跳转到首页
     *
     * @param context
     */
    public static void toMain(Activity context) {
//        Intent intent = new Intent(context, MainActivity.class);
        Intent intent = new Intent(context, Main2Activity.class);
//        Intent intent = new Intent(context, LatestDailyListActivity.class);
        context.startActivity(intent);
        context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        context.finish();
    }

    /**
     * 跳转到知乎详情页
     *
     * @param context
     * @param id
     */
    public static void toLatestDailyDetail(Activity context, int id) {
        Intent intent = new Intent(context, LatestDailyDetailActivity.class);
        intent.putExtra(Constants.IT_LATESTDAILYID, id);
        context.startActivity(intent);
    }

    /**
     * 跳转到微信详情页
     */
    public static void toWeChatDetati(Context context, String title, String url) {
        Intent intent = new Intent(context, WeChatDetailaActivity.class);
        intent.putExtra(Constants.WECHAT_TITLE, title);
        intent.putExtra(Constants.WECHAT_URL, url);
        ((Activity) context).startActivity(intent);
    }

    /**
     * 跳转到掘金标签管理页
     */
    public static void toGoldManager(Context context, String[] titles, ArrayList<GoldItemBean> beans) {
        Intent intent = new Intent(context, GoldManagerActivity.class);
        intent.putExtra(Constants.GOLD_TITLES, titles);
        intent.putParcelableArrayListExtra(Constants.GOLD_POSITION, beans);
        ((Activity) context).startActivity(intent);
    }

}
