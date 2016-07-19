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
 * Created by Longder on 2016/7/19.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 登录验证
     *
     * @param userInfo
     * @return
     */
    public BusinessResult<User> login(String userInfo) {
        User loginUser = JSON.parseObject(userInfo, User.class);
        User dbUser = userDao.findByLoginName(loginUser.getLoginName());
        BusinessResult<User> result = new BusinessResult<User>();
        if (dbUser == null) {
            result.setStatus(1);
            result.setMessage("用户名不存在");
        } else if (!loginUser.getLoginPassword().equals(dbUser.getLoginPassword())) {
            result.setStatus(2);
            result.setMessage("密码错误");
        }else{
            result.setStatus(0);
            result.setMessage("登陆成功");
            result.setData(dbUser);
        }
        return result;
    }
}
