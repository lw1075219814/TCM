package com.example.tcm.myapplication.model.http.response;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/19 11:04
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/19 11:04
 * @see
 */
public class GoldResponse<T> {
    private T results;

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
