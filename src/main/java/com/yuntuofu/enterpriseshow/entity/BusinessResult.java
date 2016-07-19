package com.yuntuofu.enterpriseshow.entity;

import java.io.Serializable;

/**
 * 服务器返回的结果
 * Created by Longder on 2016/7/19.
 */
public class BusinessResult<T> implements Serializable {
    private int status;
    private String message;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
