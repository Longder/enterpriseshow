package com.yuntuofu.enterpriseshow.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.yuntuofu.enterpriseshow.dao.MessageDao;
import com.yuntuofu.enterpriseshow.entity.BusinessResult;
import com.yuntuofu.enterpriseshow.entity.Message;
import com.yuntuofu.enterpriseshow.service.MessageService;
import com.yuntuofu.enterpriseshow.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * 留言板管理业务层
 * Created by Longder on 2016/7/28.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private BusinessResult businessResult;
    @Resource
    private MessageDao messageDao;

    /**
     * 根据页数和条件加载留言板信息
     *
     * @param page
     * @param condition
     * @return
     */
    public BusinessResult loadMessageList(String page, String condition) {
        //指定哪些字段需要进行日期转换
        String[] keys = {"startTime", "endTime"};
        Map<String, Object> conditionMap = CommonUtil.parstJsonToMap(keys, "yyyy-MM-dd HH:mm", condition);
        //计算出mybatis的分页因子
        //把page也放入map中
        //conditionMap.put("page", page);
        List<Message> list = messageDao.findByConditionAndPage(conditionMap);
        return null;
    }

}
