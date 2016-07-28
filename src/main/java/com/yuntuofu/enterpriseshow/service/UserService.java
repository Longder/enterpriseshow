package com.yuntuofu.enterpriseshow.service;

import com.yuntuofu.enterpriseshow.entity.BusinessResult;
import com.yuntuofu.enterpriseshow.entity.User;

/**
 * 与用户相关的业务层
 * Created by Longder on 2016/7/18.
 */
public interface UserService {
    /**
     * 登录验证
     *
     * @param userInfo
     * @return
     */
    BusinessResult login(String userInfo);
}
