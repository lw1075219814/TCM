package com.example.tcm.myapplication.model.http.exception;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/13 10:06
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/13 10:06
 * @see
 */
public class ApiException extends Exception {

    private int code;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
