package com.example.tcm.myapplication.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    private boolean isInited = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //bind
        initView(view);
        initListener();
    }

    protected void initListener() {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        isInited = true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbind
    }

    protected abstract int getLayoutId();

    protected abstract void initView(View view);
}
