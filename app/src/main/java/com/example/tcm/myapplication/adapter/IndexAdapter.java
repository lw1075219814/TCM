package com.example.tcm.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.bean.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/2/21 14:46
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/2/21 14:46
 * @see
 */
public class IndexAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private final LayoutInflater inflater;

    private static OnIndexClickListener indexClickListener;
    private final List<String> titles;
    private final List<List<Data>> contents;
    private Map<Integer, RecyclerView> childViews = new HashMap();

    public Map getChildViews() {
        return childViews;
    }

    public List<String> getTitles() {
        return titles;
    }

    public List<List<Data>> getContents() {
        return contents;
    }

    public IndexAdapter(Context context, List<String> titles, List<List<Data>> contents) {
        this.context = context;
        this.titles = titles;
        this.contents = contents;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        return titles.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new GroupViewHolder(inflater.inflate(R.layout.index_recylerview_title, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        GroupViewHolder groupViewHolder = (GroupViewHolder) viewHolder;
        groupViewHolder.title.setText(String.valueOf(titles.get(i)));
        groupViewHolder.recylerView.setLayoutManager(new LinearLayoutManager(context, LinearLayout.HORIZONTAL, false));
        groupViewHolder.recylerView.setAdapter(new ContentAdapter(i, contents.get(i)));

        groupViewHolder.groupItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexClickListener != null) {
                    indexClickListener.setGroupClick(i);
                }
            }
        });

        //childViews.put(i, groupViewHolder.recylerView);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    private class ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /**
         * 显示个数
         */
        private static final int SHOW_COUNT = 4;

        private final List<Data> data;
        private final int groupPosition;

        public ContentAdapter(int groupPosition, List<Data> data) {
            this.groupPosition = groupPosition;
            this.data = data;
        }

        @Override
        public int getItemViewType(int position) {
            return 2;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ChildViewHolder(inflater.inflate(R.layout.grid_item, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            ChildViewHolder childViewHolder = (ChildViewHolder) viewHolder;
            Data item = this.data.get(i);
            Glide.with(context).load(item.getImg()).into(childViewHolder.image);
            childViewHolder.text.setText(item.getText());

            childViewHolder.childItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (indexClickListener != null) {
                        indexClickListener.setChildClick(groupPosition, i);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            int size = data.size();
            return size < SHOW_COUNT ? size : SHOW_COUNT;
        }

    }

    private static class GroupViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final RecyclerView recylerView;
        private final View groupItem;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            groupItem = itemView;
            title = itemView.findViewById(R.id.title);
            recylerView = itemView.findViewById(R.id.recyclerview);
        }
    }

    private class ChildViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView text;
        private final View childItem;

        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            childItem = itemView;
            image = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }

    public class ContentItemFooterViewHolder extends RecyclerView.ViewHolder {
        public ContentItemFooterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void setIndexClickListener(final OnIndexClickListener onIndexClickListener) {
        indexClickListener = onIndexClickListener;
    }

    public interface OnIndexClickListener {
        void setGroupClick(int groupPosition);

        void setChildClick(int groupPosition, int childPosition);
    }

}
