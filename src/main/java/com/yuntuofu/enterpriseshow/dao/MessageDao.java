package com.yuntuofu.enterpriseshow.dao;

import com.yuntuofu.enterpriseshow.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 留言表DAO
 * Created by Longder on 2016/7/29.
 */
@Repository
public interface MessageDao {
    /**
     * 多条件分页查询留言信息
     *
     * @param conditionAndPage 条件Map
     * @return
     */
    List<Message> findByConditionAndPage(Map<String, Object> conditionAndPage);

    /**
     * 查询总条数（也需要带条件）
     */
    int findTotalNumber(Map<String, Object> conditionAndPage);

    /**
     * 设置阅读状态（标识为已读）
     *
     * @param id
     */
    void setHasRead(int id);

    /**
     * 查询未读的留言总数
     *
     * @return
     */
    int findNumbersNotRead();
}
