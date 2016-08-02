package com.yuntuofu.enterpriseshow.controller;

import com.yuntuofu.enterpriseshow.entity.BusinessResult;
import com.yuntuofu.enterpriseshow.service.MessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 留言板管理功能控制器
 * Created by Longder on 2016/7/28.
 */
@RestController
@RequestMapping(value = "/admin/message")
public class MessageController {
    @Resource
    private MessageService messageService;

    /**
     * 加载留言列表
     *
     * @param page
     * @param condition
     * @return
     */
    @RequestMapping(value = "/loadMessages", method = RequestMethod.POST)
    public BusinessResult loadMessageList(@RequestParam(value = "page", defaultValue = "1") String page,
                                          @RequestParam(value = "condition") String condition) {
        return messageService.loadMessageList(page, condition);
    }

    /**
     * 阅读一条留言
     *
     * @param id 留言ID
     * @return
     */
    @RequestMapping(value = "/readMessage", method = RequestMethod.POST)
    public BusinessResult readMessage(@RequestParam(value = "id") String id) {
        return messageService.readMessage(id);
    }

    @RequestMapping(value = "/loadNumbersNotRead", method = RequestMethod.POST)
    public BusinessResult loadMessageNumbersNotRead() {
        System.out.println();
        return null;
    }
}
