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
public class MyResponse<T> {
    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
