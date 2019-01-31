package com.example.tcm.myapplication.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.entity.Data;
import com.example.tcm.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2018/9/4 20:00
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/9/4 20:00
 * @see
 */
public class GridAdapter extends BaseAdapter {

    private static final int[] imgs1 = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6};

    private static final int[] imgs2 = {R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,
            R.drawable.img11};

    private final Context mContext;
    private final int mViewType;
    private final Resources resources;
    private final List<Data> datas;
    private final LayoutInflater inflater;

    public List<Data> getDatas(){
        return datas;
    }

    public GridAdapter(Context context, int viewType) {
        mContext = context;
        mViewType = viewType;
        resources = context.getResources();
        inflater = LayoutInflater.from(context);

        datas = getData();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View contentView = inflater.inflate(R.layout.grid_item, null);
        ImageView image = (ImageView) contentView.findViewById(R.id.image);
        TextView text = (TextView) contentView.findViewById(R.id.text);
        Data data = datas.get(position);
        int img;
        if(mViewType == 1){
            img = imgs1[position];
        } else {
            img = imgs2[position];
        }
        Glide.with(mContext).load(img).into(image);
        text.setText(data.getText());
        return contentView;
    }

    private List<Data> getData(){
        ArrayList<Data> datas = new ArrayList<>();
        Resources mResources = App.getContext().getResources();
        String[] texts = null;

        if(mViewType == 1){
            texts = mResources.getStringArray(R.array.texts1);
        } else {
            texts = mResources.getStringArray(R.array.texts2);
        }

        int size = texts.length;
        for (int i = 0; i < size; i++) {
            Data data = new Data();
            data.setId(i);
            data.setText(texts[i]);
            datas.add(data);
        }
        return datas;
    }

}
