package com.example.tcm.myapplication.mvp.main2;

import android.support.v7.util.DiffUtil;

import com.example.tcm.myapplication.entity.LatestDailyListBean;

import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/21 17:31
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/21 17:31
 * @see
 */
public class ZhihuDiffCallback extends DiffUtil.Callback {


    private final List<LatestDailyListBean.TopStoriesBean> mOldDatas;
    private final List<LatestDailyListBean.TopStoriesBean> mNewDatas;

    public ZhihuDiffCallback(List<LatestDailyListBean.TopStoriesBean> oldDatas, List<LatestDailyListBean.TopStoriesBean> newDatas) {
        mOldDatas = oldDatas;
        mNewDatas = newDatas;
    }

    @Override
    public int getOldListSize() {
        return mOldDatas.size();
    }

    @Override
    public int getNewListSize() {
        return mNewDatas.size();
    }

    @Override
    public boolean areItemsTheSame(int i, int i1) {
        return mOldDatas.get(i).getId() == mNewDatas.get(i1).getId();
    }

    @Override
    public boolean areContentsTheSame(int i, int i1) {
        LatestDailyListBean.TopStoriesBean oldData = mOldDatas.get(i);
        LatestDailyListBean.TopStoriesBean newData = mNewDatas.get(i1);
        if (!oldData.getTitle().equals(newData.getTitle())) {
            return false;
        }
        if (!oldData.getImage().equals(newData.getImage())){
            return false;
        }
        return true;
    }
}
