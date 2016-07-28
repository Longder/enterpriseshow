package com.yuntuofu.enterpriseshow.controller;


import com.yuntuofu.enterpriseshow.entity.BusinessResult;
import com.yuntuofu.enterpriseshow.entity.User;
import com.yuntuofu.enterpriseshow.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 用户操作相关的控制器
 * Created by Longder on 2016/7/14.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 登录
     *
     * @param userInfo 前台传递的json字符串
     * @param session spring传递的session对象，用于绑定
     * @return 统一返回BusinessResult，泛型为登录成功的User对象
     */
    @RequestMapping(value = "/login")
    public BusinessResult login(@RequestParam(value = "userInfo") String userInfo, HttpSession session) {
        BusinessResult result = userService.login(userInfo);
        //session绑定，service中已经处理了登录结果的封装，如果登录失败，result中的data将是null，相当于没绑定
        session.setAttribute("user", result.getData());
        return result;
    }
}
