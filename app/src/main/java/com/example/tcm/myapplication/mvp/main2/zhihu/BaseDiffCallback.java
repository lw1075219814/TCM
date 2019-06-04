package com.example.tcm.myapplication.mvp.main2.zhihu;

import android.support.v7.util.DiffUtil;
import android.util.Pair;

import com.example.tcm.myapplication.bean.LatestDailyListBean;
import com.example.tcm.myapplication.bean.WeChatBean;

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
public class BaseDiffCallback<T> extends DiffUtil.Callback {

    private final List<T> mOldDatas;
    private final List<T> mNewDatas;

    public BaseDiffCallback(List<T> oldDatas, List<T> newDatas) {
        mOldDatas = oldDatas;
        mNewDatas = newDatas;
    }

    @Override
    public int getOldListSize() {
        return mOldDatas != null ? mOldDatas.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return mNewDatas != null ? mNewDatas.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int i, int i1) {
        T oldData = mOldDatas.get(i);
        T newData = mNewDatas.get(i1);
        if (checkClassType(oldData, newData, LatestDailyListBean.TopStoriesBean.class)) {//知乎
            return ((LatestDailyListBean.TopStoriesBean) oldData).getId() == ((LatestDailyListBean.TopStoriesBean) newData).getId();
        } else if (checkClassType(oldData, newData, WeChatBean.class)) {//微信
            return ((WeChatBean) oldData).getTitle().equals(((WeChatBean) newData).getTitle());
        }
        return true;
    }

    @Override
    public boolean areContentsTheSame(int i, int i1) {
        T oldData = mOldDatas.get(i);
        T newData = mNewDatas.get(i1);
        if (checkClassType(oldData, newData, LatestDailyListBean.TopStoriesBean.class)) {
            LatestDailyListBean.TopStoriesBean oldData1 = (LatestDailyListBean.TopStoriesBean) oldData;
            LatestDailyListBean.TopStoriesBean newData1 = (LatestDailyListBean.TopStoriesBean) newData;
            if (oldData1.getTitle().equals(newData1.getTitle())) {
                return true;
            }
            if (oldData1.getImage().equals(newData1.getImage())) {
                return true;
            }
        } else if (checkClassType(oldData, newData, WeChatBean.class)) {
            WeChatBean oldData1 = (WeChatBean) oldData;
            WeChatBean newData1 = (WeChatBean) newData;
            if (oldData1.getCtime().equals(((WeChatBean) newData).getCtime())) {
                return true;
            }
            if (oldData1.getTitle().equals(newData1.getTitle())) {
                return false;
            } else if (oldData1.getUrl().equals(newData1.getUrl())) {
                return true;
            }
        }
        return false;
    }

    private Pair<T, T> getObject(int i, int i1) {
        return Pair.create(mOldDatas.get(i), mNewDatas.get(i1));
    }

    private boolean checkClassType(T oldData, T newData, Class cls) {
        return oldData.getClass().equals(cls) && newData.getClass().equals(cls);
    }

}
