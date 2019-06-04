package com.example.tcm.myapplication.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/20 11:16
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/20 11:16
 * @see
 */
public abstract class SimpleFragment extends SupportFragment {

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //bind
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        initListener();
    }

    protected void initListener() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbind
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    protected abstract int getLayoutId();

    protected abstract void initView(View view);
}
