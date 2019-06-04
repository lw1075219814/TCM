package com.example.tcm.myapplication.model.http.api;

import com.example.tcm.myapplication.bean.WeChatBean;
import com.example.tcm.myapplication.model.http.response.WXResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/4/22 14:25
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/4/22 14:25
 * @see
 */
public interface WeChatApis {

    String URL = "http://api.tianapi.com/";

    /**
     * 微信列表
     */
    @GET("wxnew")
    Flowable<WXResponse<List<WeChatBean>>> getWeChatData(
            @Query("key") String key, @Query("num") int num, @Query("page") int page);
}
