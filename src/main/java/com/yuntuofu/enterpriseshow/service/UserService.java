package com.yuntuofu.enterpriseshow.service;

import com.yuntuofu.enterpriseshow.entity.BusinessResult;
import com.yuntuofu.enterpriseshow.entity.User;

/**
 * Created by Longder on 2016/7/18.
 */
public interface UserService {
    /**
     * 登录验证
     *
     * @param userInfo
     * @return
     */
    BusinessResult<User> login(String userInfo);
}
