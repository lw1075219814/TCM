package com.example.tcm.myapplication.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.base.ImageLoader;
import com.example.tcm.myapplication.bean.WeChatBean;
import com.example.tcm.myapplication.util.IntentUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/4/23 10:59
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/4/23 10:59
 * @see
 */
public class WeChatAdapter extends BaseQuickAdapter<WeChatBean, WeChatAdapter.WeChatViewHolder> {

    public WeChatAdapter(int layoutResId, @Nullable List<WeChatBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(WeChatViewHolder holder, WeChatBean item) {
        ImageLoader.load(mContext, item.getPicUrl(), holder.ivImage);
        holder.tvTitle.setText(item.getTitle());
        holder.tvFrom.setText(item.getDescription());
        holder.tvTime.setText(item.getCtime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentUtil.toWeChatDetati(mContext,item.getTitle(), item.getUrl());
            }
        });
    }

    public static class WeChatViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_wechat_item_title)
        TextView tvTitle;
        @BindView(R.id.tv_wechat_item_time)
        TextView tvTime;
        @BindView(R.id.tv_wechat_item_from)
        TextView tvFrom;
        @BindView(R.id.iv_wechat_item_image)
        ImageView ivImage;

        public WeChatViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
