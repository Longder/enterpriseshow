package com.yuntuofu.enterpriseshow.controller;

import com.yuntuofu.enterpriseshow.entity.BusinessResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 留言板管理功能控制器
 * Created by Longder on 2016/7/28.
 */
@RestController
@RequestMapping(value = "/admin/message")
public class MessageController {
    /**
     * 加载留言列表
     *
     * @param page
     * @param condition
     * @return
     */
    @RequestMapping(value = "/loadMessages", method = RequestMethod.POST)
    public BusinessResult loadMessageList(@RequestParam(value = "page") String page,
                                          @RequestParam(value = "condition") String condition) {
        System.out.println();
        return null;
    }
}
