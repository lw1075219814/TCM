package com.example.tcm.myapplication.base;

import android.os.Environment;

import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.bean.Data;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/2/22 14:19
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/2/22 14:19
 * @see
 */
public class Constants {

    /**
     * 需要APIKEY请去 http://www.tianapi.com/#wxnew 申请,复用会减少访问可用次
     */
    public static final String KEY_API = "52b7ec3471ac3bec6846577e79f20e4c";

    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath()
            + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator + "codeest" + File.separator + "GeekNews";

    public static final String FILE_PROVIDER = "com.shanghai.tcm.fileprovider";

    /**
     * 日志标识
     */
    public static final String LOG_TAG = "tcm_log";

    /**
     * 首页分栏标题
     */
    public static final List<String> DATA_TITLES = Arrays.asList(
            "Traditional Chinese Medicine Therapies",
            "Hospital Information");

    /**
     * 首页分栏内容
     */
    public static final List<List<Data>> DATA_CONTENTS = Arrays.asList(
            Arrays.asList(
                    new Data(0, R.drawable.img1, "Acupuncture"),
                    new Data(1, R.drawable.img2, "Moxibustion"),
                    new Data(2, R.drawable.img3, "Guasha"),
                    new Data(3, R.drawable.img4, "Chinese herbal medicine"),
                    new Data(4, R.drawable.img5, "Tuina"),
                    new Data(5, R.drawable.img6, "Cupping")),
            Arrays.asList(
                    new Data(0, R.drawable.img7, "Shuguang Hospital"),
                    new Data(0, R.drawable.img8, "Yueyang Hospital"),
                    new Data(0, R.drawable.img9, "Longhua Hospital"),
                    new Data(0, R.drawable.img10, "Shanghai Traditional Chinese Medicine(TCM) Hospital"),
                    new Data(0, R.drawable.img11, "Shanghai TCM-Integrated Hospital")
            ));


    /**
     * 首页治疗类型
     */
    public static final int TYPE_GROUP_THERAPY = 0;

    /**
     * 首页医院类型
     */
    public static final int TYPE_GROUP_HOSPITAL = 1;

    /**
     * 知乎
     */
    public static final int TYPE_ZHIHU = 1;

    /**
     * 收藏
     */
    public static final int TYPE_COLLECTION = 2;

    /**
     * 设置
     */
    public static final int TYPE_SETTING = 3;

    /**
     * 关于
     */
    public static final int TYPE_ABOUT = 4;

    /**
     * 微信
     */
    public static final int TYPE_WECHAT = 5;

    /**
     * 掘金
     */
    public static final int TYPE_GOLD = 6;

    /**
     * 首页标题子布局下标
     */
    public static final String IT_GROUPPOSITION = "groupPosition";

    /**
     * 首页recylerView子布局下标
     */
    public static final String IT_CHILDPOSITION = "childPosition";

    /**
     * 首页recylerView子布局内容
     */
    public static final String IT_TITLE = "title";

    /**
     * 每天最新item Id
     */
    public static final String IT_LATESTDAILYID = "LatestDailyId";

    /**
     * sp文件名称
     */
    public static final String SP_NAME = "TCM_SP";

    /**
     * 夜间模式状态
     */
    public static final String SP_NIGHT_MODE = "night_mode";

    /**
     * fragment下标
     */
    public static final String SP_CURRENT_ITEM = "current_item";

    /**
     * 无图模式状态
     */
    public static final String SP_NO_PIC_MODE = "no_pic_mode";

    /**
     * url
     */
    public static final String WECHAT_URL = "wechat_url";

    /**
     * title
     */
    public static final String WECHAT_TITLE="wechat_title";

    /**
     * gold titles
     */
    public static final String GOLD_TITLES="gold_titles";

    /**
     * gold position
     */
    public static final String GOLD_POSITION="gold_position";
}
