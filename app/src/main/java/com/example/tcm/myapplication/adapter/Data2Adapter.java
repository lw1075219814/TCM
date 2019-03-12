package com.example.tcm.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.entity.Data2;
import com.example.tcm.myapplication.util.MapUtil;
import com.example.tcm.myapplication.R;

import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2018/9/12 13:02
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/9/12 13:02
 * @see
 */
public class Data2Adapter extends BaseAdapter {

    private final List<Data2> mData;
    private final LayoutInflater inflater;

    public Data2Adapter(String key, Context context) {
        mData = (List<Data2>) MapUtil.getMap().get(key);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size() > 0 ? mData.size() : 0;
    }

    @Override
    public Data2 getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.detail_list_item, null);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        final TextView content = (TextView) convertView.findViewById(R.id.content);
        Data2 data = getItem(position);
        title.setText(data.getKey());
        content.setText(data.getValue());

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content.setVisibility(content.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });
        return convertView;
    }
}
