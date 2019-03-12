package com.example.tcm.myapplication.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.adapter.Data2Adapter;
import com.example.tcm.myapplication.util.MapUtil;
import com.example.tcm.myapplication.R;

import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2018/8/27 17:29
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/8/27 17:29
 * @see
 */
public class DetailActivity extends AppCompatActivity {

    private static final int[] imgs1 = {R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img4, R.drawable.img5, R.drawable.img6};

    private static final int[] imgs2 = {R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10,
            R.drawable.img11};

    private int groupPosition;
    private int childPosition;
    private String title;
    private List<String> tab1Detail;
    private int[] imgs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getData();

        if (groupPosition == 0) {
            setContentView(R.layout.activity_detail);
            initView1();
        } else {
            setContentView(R.layout.activity_detail_list);
            initView2();
        }
    }

    private void getData() {
        Intent intent = getIntent();
        groupPosition = intent.getIntExtra("groupPosition", 0);
        childPosition = intent.getIntExtra("childPosition", 0);
        title = intent.getStringExtra("title");

        if (groupPosition == 0) {
            tab1Detail = MapUtil.getDetail1();
            imgs = imgs1;
        } else {
            imgs = imgs2;
        }
    }

    private void initView1() {
        setupView();
        TextView textView = findViewById(R.id.text);
        textView.setText(tab1Detail.get(childPosition));
    }

    private void initView2() {
        setupView();
        ListView listView = findViewById(R.id.listview);
        Data2Adapter data2Adapter = new Data2Adapter(title, this);
        setupHeader(listView);
        listView.setAdapter(data2Adapter);
    }

    private void setupHeader(ListView listView) {
        View headerView = LayoutInflater.from(this).inflate(R.layout.list_header, null);
        TextView header = headerView.findViewById(R.id.header);
        ImageView img = headerView.findViewById(R.id.img);
        Glide.with(getBaseContext()).load(imgs[childPosition]).into(img);
        header.setText(MapUtil.getHeaders().get(title).toString());
        listView.addHeaderView(headerView);
    }

    private void setupView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView titleView = findViewById(R.id.title);
        titleView.setText(title);

        if (groupPosition == 0) {
            ImageView img = findViewById(R.id.img);
            Glide.with(getBaseContext()).load(imgs[childPosition]).into(img);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }
}
