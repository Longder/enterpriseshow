package com.yuntuofu.enterpriseshow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理主制器，主要负责页面跳转
 * Created by Longder on 2016/7/18.
 */
@Controller
@RequestMapping(value = "/admin")
public class MainController {
    /**
     * 去后台登陆页
     */
    @RequestMapping(value = "")
    public String toLogin(){
        return "Login";
    }

    /**
     * 去主页面

     */
    @RequestMapping(value = "/main")
    public String toMain(){
        return "AdminMain";
    }
}
