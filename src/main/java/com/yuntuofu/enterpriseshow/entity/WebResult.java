package com.yuntuofu.enterpriseshow.entity;

/**
 * 服务器返回的结果对象
 * Created by Longder on 2016/7/18.
 */
public class WebResult {
    /**
     * 状态
     */
    private int status;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
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
