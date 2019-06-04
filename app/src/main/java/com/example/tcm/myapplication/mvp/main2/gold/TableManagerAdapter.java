package com.example.tcm.myapplication.mvp.main2.gold;

import android.support.annotation.Nullable;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.bean.GoldItemBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/4/28 16:04
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/4/28 16:04
 * @see
 */
public class TableManagerAdapter extends BaseQuickAdapter<GoldItemBean, TableManagerAdapter.GoldViewHolder> {

    private String[] goldTitles;

    public TableManagerAdapter(int layoutResId, @Nullable List<GoldItemBean> data, String[] goldTitles) {
        super(layoutResId, data);
        this.goldTitles = goldTitles;
    }

    @Override
    protected void convert(GoldViewHolder helper, GoldItemBean item) {
        helper.goldType.setText(goldTitles[item.getPosition()]);
        helper.switchCompat.setChecked(item.isSelect());

        helper.switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                item.setIsSelet(isChecked);
            }
        });
    }

    public static class GoldViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_gold_manager_type)
        TextView goldType;
        @BindView(R.id.sc_gold_manager_switch)
        SwitchCompat switchCompat;

        public GoldViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
