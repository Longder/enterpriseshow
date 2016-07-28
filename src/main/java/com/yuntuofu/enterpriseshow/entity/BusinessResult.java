package com.yuntuofu.enterpriseshow.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 服务器返回的结果
 * Created by Longder on 2016/7/19.
 */
@Component
public class BusinessResult implements Serializable {
    private int status;
    private String message;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
