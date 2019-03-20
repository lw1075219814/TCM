package com.example.tcm.myapplication.mvp.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.adapter.IndexAdapter;
import com.example.tcm.myapplication.base.Constants;
import com.example.tcm.myapplication.util.IntentUtil;

public class MainActivity extends AppCompatActivity {

    private IndexAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "The appointment booking function is under development, " +
                        "please wait patiently", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new IndexAdapter(this, Constants.TITLES, Constants.CONTENTS);
        recyclerView.setAdapter(adapter);

        adapter.setIndexClickListener(new IndexAdapter.OnIndexClickListener() {
            @Override
            public void setGroupClick(int groupPosition) {
                IntentUtil.toList(MainActivity.this, groupPosition);
            }

            @Override
            public void setChildClick(int groupPosition, int childPosition) {
                String text = adapter.getContents().get(groupPosition).get(childPosition).getText();
                IntentUtil.toDetail(MainActivity.this, groupPosition, childPosition, text);
            }
        });

//        recyclerView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                ((RecyclerView) adapter.getChildViews().get(0)).addOnScrollListener(onScrollListener);
//                ((RecyclerView) adapter.getChildViews().get(1)).addOnScrollListener(onScrollListener);
//            }
//        }, 1500);
//
//        recyclerView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return false;
//            }
//        });
    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (isVisibleBottom(recyclerView)) {
//                if (adapter.getContents().size() == Constants.CONTENTS.get(0).size()) {
//                    toListPage(Constants.GROUP_TYPE_THERAPY);
//                } else {
//                    toListPage(Constants.GROUP_TYPE_HOSPITAL);
//                }
            }
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
    };

    private boolean isVisibleBottom(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        //屏幕中最后一个可见子项的position
        int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
        //当前屏幕可视的子项个数
        int visibleCount = layoutManager.getChildCount();
        //当前recyclerView的所有子项个数
        int totalCount = layoutManager.getItemCount();
        //recyclerView的滑动状态
        int scrollState = recyclerView.getScrollState();
        if (visibleCount > 0 && lastVisibleItemPosition == totalCount - 1
                && scrollState == recyclerView.SCROLL_STATE_IDLE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
