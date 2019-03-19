package com.example.tcm.myapplication.base;

import android.os.Environment;

import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.entity.Data;

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

    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath()
            + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator + "codeest" + File.separator + "GeekNews";

    public static final String FILE_PROVIDER_AUTHORITY = "com.shanghai.tcm.fileprovider";

    /**
     * 日志标识
     */
    public static final String LOG_TAG = "log";

    /**
     * bugly app id
     */
    public static final String BUGLY_APP_ID = "e63eb81dd6";

    /**
     * 首页分栏标题
     */
    public static final List<String> TITLES = Arrays.asList(
            "Traditional Chinese Medicine Therapies",
            "Hospital Information");

    /**
     * 首页分栏内容
     */
    public static final List<List<Data>> CONTENTS = Arrays.asList(
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
    public static final int GROUP_TYPE_THERAPY = 0;

    /**
     * 首页医院类型
     */
    public static final int GROUP_TYPE_HOSPITAL = 1;

    /**
     * 首页标题子布局下标
     */
    public static final String GROUPPOSITION = "groupPosition";

    /**
     * 首页recylerView子布局下标
     */
    public static final String CHILDPOSITION = "childPosition";

    /**
     * 首页recylerView子布局内容
     */
    public static final String TITLE = "title";

    /**
     * 每天最新item Id
     */
    public static final String LATESTDAILYID = "LatestDailyId";
}
