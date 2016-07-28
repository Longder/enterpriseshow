package com.yuntuofu.enterpriseshow.service.impl;

import com.yuntuofu.enterpriseshow.entity.BusinessResult;
import com.yuntuofu.enterpriseshow.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * 留言板管理业务层
 * Created by Longder on 2016/7/28.
 */
@Service
public class MessageServiceImpl implements MessageService{
    /**
     * 根据页数和条件加载留言板信息
     * @param page
     * @param condition
     * @return
     */
    public BusinessResult loadMessageList(String page, String condition) {
        return null;
    }
}
