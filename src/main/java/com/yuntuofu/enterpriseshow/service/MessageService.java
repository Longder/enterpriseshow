package com.yuntuofu.enterpriseshow.service;

import com.yuntuofu.enterpriseshow.entity.BusinessResult;

/**
 * 留言板管理业务层
 * Created by Longder on 2016/7/28.
 */
public interface MessageService {
    /**
     * 根据页数和条件加载留言板信息
     *
     * @param page
     * @param condition
     * @return
     */
    BusinessResult loadMessageList(String page, String condition);

    /**
     * 阅读一条留言（标识为已读状态）
     *
     * @param id 留言id
     * @return
     */
    BusinessResult readMessage(String id);
}
