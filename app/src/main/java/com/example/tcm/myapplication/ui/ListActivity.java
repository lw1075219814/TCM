package com.example.tcm.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.tcm.myapplication.base.Constants;
import com.example.tcm.myapplication.bean.Data;
import com.example.tcm.myapplication.adapter.ListAdapter;
import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.util.IntentUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2018/9/4 20:06
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/9/4 20:06
 * @see
 */
public class ListActivity extends AppCompatActivity {

    private static final int[] imgs1 = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6};

    private static final int[] imgs2 = {R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10,
            R.drawable.img11};

    private int groupPosition;
    private List<Data> datas;
    ArrayList<Data> results = new ArrayList<>();
    private ListView listView;
    private ListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        groupPosition = intent.getIntExtra(Constants.IT_GROUPPOSITION, 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(groupPosition == 0 ? "Traditional Chinese Medicine Therapies" : "Hospital Information");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.listview);
        adapter = new ListAdapter(getData(), this);
        listView.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                List<Data> datas = query(query);
                adapter.setDatas(datas);
                adapter.notifyDataSetChanged();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Data> datas = query(newText);
                adapter.setDatas(datas);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                IntentUtil.toDetail(ListActivity.this, groupPosition, i,
                        ((Data) adapter.getItem(i)).getText());
            }
        });

        datas = getData();
    }

    private List<Data> query(String result) {
        results.clear();

        String trim = result.trim();
        if (TextUtils.isEmpty(trim)) {
            return results;
        }

        int size = datas.size();
        for (int i = 0; i < size; i++) {
            Data data = datas.get(i);
            if (data.getText().contains(result)) {
                results.add(data);
            }
        }
        return results;
    }

    private List<Data> getData() {
        ArrayList<Data> datas = new ArrayList<>();

        String[] texts = null;
        int[] imgs = null;
        if (groupPosition == 0) {
            texts = getResources().getStringArray(R.array.texts1);
            imgs = imgs1;
        } else {
            texts = getResources().getStringArray(R.array.texts2);
            imgs = imgs2;
        }

        for (int i = 0; i < texts.length; i++) {
            Data data = new Data();
            data.setId(i);
            data.setText(texts[i]);
            data.setImg(imgs[i]);
            datas.add(data);
        }
        return datas;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }

}
