package com.example.tcm.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tcm.myapplication.bean.Data;
import com.example.tcm.myapplication.R;

import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2018/8/27 12:51
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/8/27 12:51
 * @see
 */
public class ListAdapter extends BaseAdapter {

    private List<Data> mDatas;
    private final LayoutInflater inflater;
    private final Context mContext;

    public void setDatas(List<Data> datas){
        this.mDatas = datas;
    }

    public ListAdapter(List<Data> datas,Context context){
        this.mDatas = datas;
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View contentView = inflater.inflate(R.layout.list_item, null);
        ImageView image = (ImageView) contentView.findViewById(R.id.image);
        TextView text = (TextView) contentView.findViewById(R.id.text);
        Data data = mDatas.get(i);
        Glide.with(mContext).load(data.getImg()).into(image);
        text.setText(data.getText());
        return contentView;
    }

}
