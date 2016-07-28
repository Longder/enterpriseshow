package com.yuntuofu.enterpriseshow.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuntuofu.enterpriseshow.dao.UserDao;
import com.yuntuofu.enterpriseshow.entity.BusinessResult;
import com.yuntuofu.enterpriseshow.entity.User;
import com.yuntuofu.enterpriseshow.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * 与用户相关的业务层
 * Created by Longder on 2016/7/19.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private BusinessResult businessResult;

    /**
     * 登录验证
     *
     * @param userInfo
     * @return
     */
    public BusinessResult login(String userInfo) {
        //把json字符串转成对象
        User loginUser = JSON.parseObject(userInfo, User.class);
        User dbUser = userDao.findByLoginName(loginUser.getLoginName());
        if (dbUser == null) {
            businessResult.setStatus(1);
            businessResult.setMessage("用户名不存在");
        } else if (!loginUser.getLoginPassword().equals(dbUser.getLoginPassword())) {
            businessResult.setStatus(2);
            businessResult.setMessage("密码错误");
        } else {
            businessResult.setStatus(0);
            businessResult.setMessage("登陆成功");
            businessResult.setData(dbUser);
        }
        return businessResult;
    }
}
