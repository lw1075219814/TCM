package com.example.tcm.myapplication.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.tcm.myapplication.BuildConfig;
import com.example.tcm.myapplication.base.Constants;
import com.example.tcm.myapplication.util.SystemUtil;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.Logger;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/13 17:18
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/13 17:18
 * @see
 */
public class InitService extends IntentService {

    public static final String ACTION = "init";

    public static void start(Context context) {
        Intent intent = new Intent(context, InitService.class);
        intent.setAction(ACTION);
        context.startService(intent);
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public InitService() {
        super("InitService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (ACTION.equals(action)) {
                init();
            }
        }
    }

    private void init() {
        //初始化打印日志
        initLogger();
        //初始化bugly
        initBugly();
    }

    private void initLogger() {
        CsvFormatStrategy formatStrategy = CsvFormatStrategy
                .newBuilder()
                .tag(Constants.LOG_TAG)
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    private void initBugly() {
        Context context = getApplicationContext();
// 获取当前包名
        String packageName = context.getPackageName();
// 获取当前进程名
        String processName = SystemUtil.getProcessName(android.os.Process.myPid());
// 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        //strategy.setAppChannel()//设置渠道
        //strategy.setAppVersion("1.0.1");//App的版本
        //strategy.setAppPackageName("com.tencent.xx");  //App的包名
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
// 初始化Bugly
        CrashReport.initCrashReport(context, Constants.BUGLY_APP_ID, BuildConfig.DEBUG, strategy);
// 如果通过“AndroidManifest.xml”来配置APP信息，初始化方法如下
// CrashReport.initCrashReport(context, strategy);
    }
}
