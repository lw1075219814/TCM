package com.example.tcm.myapplication.mvp.main;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.adapter.IndexAdapter;
import com.example.tcm.myapplication.base.Constants;
import com.example.tcm.myapplication.base.SimpleActivity;
import com.example.tcm.myapplication.util.IntentUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends SimpleActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    private IndexAdapter adapter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new IndexAdapter(this, Constants.DATA_TITLES, Constants.DATA_CONTENTS);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setIndexClickListener(onIndexClickListener);
    }

    @OnClick({R.id.fab})
    void OnClick(View view) {
        Snackbar.make(view, "The appointment booking function is under development, " +
                "please wait patiently", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    private IndexAdapter.OnIndexClickListener onIndexClickListener = new IndexAdapter.OnIndexClickListener() {
        @Override
        public void setGroupClick(int groupPosition) {
            IntentUtil.toList(MainActivity.this, groupPosition);
        }

        @Override
        public void setChildClick(int groupPosition, int childPosition) {
            String text = adapter.getContents().get(groupPosition).get(childPosition).getText();
            IntentUtil.toDetail(MainActivity.this, groupPosition, childPosition, text);
        }
    };


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
