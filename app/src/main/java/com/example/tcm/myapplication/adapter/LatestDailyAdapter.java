package com.example.tcm.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.base.ImageLoader;
import com.example.tcm.myapplication.bean.LatestDailyListBean;
import com.example.tcm.myapplication.impl.BaseAdapterListener;

import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/15 14:34
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/15 14:34
 * @see
 */
public class LatestDailyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context mContext;
    private List<LatestDailyListBean.TopStoriesBean> mBeans;
    private final LayoutInflater inflater;
    private BaseAdapterListener mListener;

    public void setData(List<LatestDailyListBean.TopStoriesBean> beans) {
        this.mBeans = beans;
    }

    public List<LatestDailyListBean.TopStoriesBean> getData() {
        return mBeans;
    }

    public LatestDailyAdapter(Context context, List<LatestDailyListBean.TopStoriesBean> beans) {
        mContext = context;
        this.mBeans = beans;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(inflater.inflate(R.layout.grid_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder childViewHolder = (ViewHolder) viewHolder;
        LatestDailyListBean.TopStoriesBean bean = mBeans.get(i);
        ImageLoader.load(mContext, bean.getImage(), childViewHolder.image);
        childViewHolder.text.setText(bean.getTitle());

        childViewHolder.childItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClick(bean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBeans.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView text;
        private final View childItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            childItem = itemView;
            image = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }

    public void setBaseAdapterListener(BaseAdapterListener listener) {
        mListener = listener;
    }
}
