package com.yuntuofu.enterpriseshow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理主制器，主要负责页面跳转、返回静态页面。
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
     * 主页面（主要包含导航和菜单）
     */
    @RequestMapping(value = "/main")
    public String toMain(){
        return "AdminMain";
    }

    /**
     * 返回Dashboard页
     */
    @RequestMapping(value = "/dashboard")
    public String toDashboard(){
        return "Dashboard";
    }

    /**
     * 返回留言板管理页
     */
    @RequestMapping(value = "/messageManage")
    public String toMessageManage(){
        return "MessageManage";
    }

}
