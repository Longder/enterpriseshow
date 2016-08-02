package com.yuntuofu.enterpriseshow.service.impl;

import com.yuntuofu.enterpriseshow.dao.MessageDao;
import com.yuntuofu.enterpriseshow.entity.BusinessResult;
import com.yuntuofu.enterpriseshow.entity.Message;
import com.yuntuofu.enterpriseshow.service.MessageService;
import com.yuntuofu.enterpriseshow.util.CommonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
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

    @Value("#{config.pageSize}")
    private int pageSize;

    /**
     * 根据页数和条件加载留言板信息
     *
     * @param page      当前页
     * @param condition 条件json
     * @return
     */
    public BusinessResult loadMessageList(String page, String condition) {
        //根据每页显示条数和当前页计算mybatis分页因子
        int start = pageSize * Integer.parseInt(page) - pageSize;
        int limit = pageSize;
        //指定哪些字段需要进行日期转换
        String[] keys = {"startTime", "endTime"};
        Map<String, Object> conditionMap = CommonUtil.parstJsonToMap(keys, "yyyy-MM-dd HH:mm", condition);
        //加入分页因子
        conditionMap.put("start", start);
        conditionMap.put("limit", limit);
        List<Message> list = messageDao.findByConditionAndPage(conditionMap);
        //总页数
        int totalNumbers = messageDao.findTotalNumber(conditionMap);
        int totalPages = CommonUtil.getTotalPages(totalNumbers, pageSize);
        //构建返回对象
        businessResult.setStatus(0);
        businessResult.setMessage("查询成功");
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("list", list);
        data.put("totalPages", totalPages);
        data.put("currentPage", page);
        businessResult.setData(data);
        return businessResult;
    }

    /**
     * 阅读一条留言（标识为已读状态）
     *
     * @param id 留言id
     * @return
     */
    @Transactional
    public BusinessResult readMessage(String id) {
        try {
            messageDao.setHasRead(Integer.parseInt(id));
            businessResult.setStatus(0);
            businessResult.setMessage("设置成功");
        } catch (Exception e) {
            e.printStackTrace();
            businessResult.setStatus(1);
            businessResult.setMessage("出现异常，设置失败");
        }
        return businessResult;
    }

}
