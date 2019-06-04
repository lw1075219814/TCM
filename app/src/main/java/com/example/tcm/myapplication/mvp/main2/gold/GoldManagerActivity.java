package com.example.tcm.myapplication.mvp.main2.gold;

import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.tcm.myapplication.R;
import com.example.tcm.myapplication.RxBus;
import com.example.tcm.myapplication.base.BaseActivity;
import com.example.tcm.myapplication.base.Constants;
import com.example.tcm.myapplication.base.SimpleActivity;
import com.example.tcm.myapplication.bean.GoldBean;
import com.example.tcm.myapplication.bean.GoldItemBean;
import com.example.tcm.myapplication.model.event.GoldItemEvent;
import com.example.tcm.myapplication.util.ToastUtil;
import com.example.tcm.myapplication.widget.DefaultItemTouchHelpCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/4/28 11:08
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/4/28 11:08
 * @see
 */
public class GoldManagerActivity extends SimpleActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private TableManagerAdapter adapter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_table_manager;
    }

    @Override
    protected void initView() {
        setToolBar(toolbar, getString(R.string.table_select));

        String[] goldTitles = getIntent().getStringArrayExtra(Constants.GOLD_TITLES);
        ArrayList<GoldItemBean> datas = getIntent().getParcelableArrayListExtra(Constants.GOLD_POSITION);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TableManagerAdapter(R.layout.item_gold_manager, datas, goldTitles);
        recyclerView.setAdapter(adapter);

        //条目拖动
        DefaultItemTouchHelpCallback callback = new DefaultItemTouchHelpCallback(new DefaultItemTouchHelpCallback.OnItemTouchCallbackListener() {
            @Override
            public void onSwiped(int adapterPosition) {

            }

            @Override
            public boolean onMove(int srcPosition, int targetPosition) {
                Collections.swap(datas, srcPosition, targetPosition);
                adapter.notifyItemMoved(srcPosition, targetPosition);
                return false;
            }
        });
        callback.setDragEnable(true);
        callback.setSwipeEnable(false);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
    }

    @Override
    protected void navigationOnClick(View view) {
        super.navigationOnClick(view);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //RxBus.get().post(new GoldItemEvent(new GoldBean(adapter.getData())));
    }
}
