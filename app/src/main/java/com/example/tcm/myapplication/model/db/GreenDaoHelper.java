package com.example.tcm.myapplication.model.db;

import com.example.tcm.myapplication.App;
import com.example.tcm.myapplication.bean.GoldItemBean;

import org.greenrobot.greendao.database.Database;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/12 11:07
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/12 11:07
 * @see
 */
public class GreenDaoHelper implements DBHelper {

    private static final String DB_NAME = "tcm.db";

    private static final String DB_PWD = "tcm";

    private DaoSession daoSession;

    @Inject
    public GreenDaoHelper() {
        init();
    }

    private void init() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(App.getInstance().getContext(), DB_NAME);
        Database db = helper.getEncryptedReadableDb(DB_PWD);
        daoSession = new DaoMaster(db).newSession();
    }

    @Override
    public void updateGoldItems(List<GoldItemBean> items) {
        daoSession.getGoldItemBeanDao().insertOrReplaceInTx(items);
    }

    @Override
    public Flowable<List<GoldItemBean>> getGoldTtems() {
        return Flowable.create(new FlowableOnSubscribe<List<GoldItemBean>>() {
            @Override
            public void subscribe(FlowableEmitter<List<GoldItemBean>> emitter) throws Exception {
                try {
                    emitter.onNext(daoSession.getGoldItemBeanDao().loadAll());
                } catch (Exception e) {
                    emitter.onError(new Throwable("getGoldTtems error"));
                } finally {
                    emitter.onComplete();
                }
            }
        }, BackpressureStrategy.BUFFER);
    }
}
