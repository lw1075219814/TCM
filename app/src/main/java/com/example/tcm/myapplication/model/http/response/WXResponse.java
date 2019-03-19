package com.example.tcm.myapplication.model.http.response;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/19 10:52
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/19 10:52
 * @see
 */
public class WXResponse<T> {
    private int code;
    private String msg;
    private T newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getNewslist() {
        return newslist;
    }

    public void setNewslist(T newslist) {
        this.newslist = newslist;
    }
}
