package com.example.tcm.myapplication.base;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.tcm.myapplication.App;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/27 17:22
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/27 17:22
 * @see
 */
public class ImageLoader {

    public static void load(Context context, String url, ImageView imageView) {
        if (!App.getInstance().getAppComponent().getPreferencesHelper().getNoPicState()) {
            Glide.with(context).load(url).into(imageView);
        }
    }

    public static void load(Activity context, String url, ImageView imageView) {
        if (!context.isDestroyed() &&
                !App.getInstance().getAppComponent().getPreferencesHelper().getNoPicState()) {
            Glide.with(context).load(url).into(imageView);
        }
    }

}
