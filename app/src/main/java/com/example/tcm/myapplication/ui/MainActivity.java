package com.example.tcm.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.tcm.myapplication.ui.module.TestActivity;
import com.example.tcm.myapplication.view.CustomGridView;
import com.example.tcm.myapplication.adapter.GridAdapter;
import com.example.tcm.myapplication.R;

public class MainActivity extends AppCompatActivity {

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
                Snackbar.make(view, "The appointment booking function is under development, please wait patiently", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RelativeLayout rl_therapy = findViewById(R.id.rl_therapy);
        RelativeLayout rl_hospital = findViewById(R.id.rl_hospital);
        CustomGridView gridVIew1 = findViewById(R.id.grid_view1);
        CustomGridView gridVIew2 = findViewById(R.id.grid_view2);

        final GridAdapter gridAdapter1 = new GridAdapter(MainActivity.this,1);
        final GridAdapter gridAdapter2 = new GridAdapter(MainActivity.this,2);
        gridVIew1.setAdapter(gridAdapter1);
        gridVIew2.setAdapter(gridAdapter2);

        rl_hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int viewType = 2;
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("viewType",viewType);
                startActivity(intent);
            }
        });

        rl_therapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int viewType = 1;
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("viewType",viewType);
                startActivity(intent);
            }
        });

        gridVIew1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("tab_index",1);
                intent.putExtra("position",position);
                intent.putExtra("title",gridAdapter1.getDatas().get(position).getText());
                startActivity(intent);
            }
        });

        gridVIew2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("tab_index",2);
                intent.putExtra("position",position);
                intent.putExtra("title",gridAdapter2.getDatas().get(position).getText());
                startActivity(intent);
            }
        });
    }

    private void initData(final int index){
//        final ListAdapter adapter = new ListAdapter(index);
//        listView.setAdapter(adapter);
//
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
