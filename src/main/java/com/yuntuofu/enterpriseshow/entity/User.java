package com.yuntuofu.enterpriseshow.entity;

/**
 * 用户实体
 * Created by Longder on 2016/7/18.
 */
public class User {
    private Integer id;
    private String loginName;
    private String loginPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
