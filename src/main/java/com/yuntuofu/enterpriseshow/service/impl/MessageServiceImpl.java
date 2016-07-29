package com.yuntuofu.enterpriseshow.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.yuntuofu.enterpriseshow.entity.BusinessResult;
import com.yuntuofu.enterpriseshow.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 留言板管理业务层
 * Created by Longder on 2016/7/28.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private BusinessResult businessResult;

    /**
     * 根据页数和条件加载留言板信息
     *
     * @param page
     * @param condition
     * @return
     */
    public BusinessResult loadMessageList(String page, String condition) {
        Map<String, Object> map = JSON.parseObject(condition, new TypeReference<Map<String, Object>>() {
        });
        System.out.println();
        return null;
    }
}
