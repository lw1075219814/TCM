package com.example.tcm.myapplication.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.tcm.myapplication.R;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/2/21 16:02
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/2/21 16:02
 * @see
 */
public class LoadingDialog extends Dialog {

    public LoadingDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_loading);
    }

}
