package com.example.tcm.myapplication.mvp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2018/12/7 17:08
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2018/12/7 17:08
 * @see
 */
public class TaskPresenter implements TaskContract.Presenter{

    private final List list = new ArrayList();

    private final TaskContract.View view;

    public TaskPresenter(TaskContract.View view){
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        view.showProgress();
    }

    @Override
    public void addData() {
        String data = view.getData();
        list.add(data);
    }

    @Override
    public void setResult() {
        view.showResult(list);
        view.hideProgress();
    }

}
