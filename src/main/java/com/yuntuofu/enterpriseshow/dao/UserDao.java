package com.yuntuofu.enterpriseshow.dao;

import com.yuntuofu.enterpriseshow.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户表DAO
 * Created by Longder on 2016/7/18.
 */
@Repository
public interface UserDao {
    /**
     * 根据登录名查询用户
     *
     * @param loginName
     * @return
     */
    User findByLoginName(String loginName);
}
