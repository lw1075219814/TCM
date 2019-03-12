package com.example.tcm.myapplication.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2018/10/20 19:23
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/10/20 19:23
 * @see
 */
public class CustomGridView extends GridView{

    public CustomGridView(Context context) {
        super(context);
    }
    public CustomGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public CustomGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
