package com.example.tcm.myapplication.model.http.response;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/19 11:03
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/19 11:03
 * @see
 */
public class GankResponse<T> {
    private boolean error;
    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
