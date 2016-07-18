package com.yuntuofu.enterpriseshow.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户操作相关的控制器
 * Created by Longder on 2016/7/14.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "userInfo") String userInfo){
        System.out.println("开始登录");
        
        return null;
    }
}
