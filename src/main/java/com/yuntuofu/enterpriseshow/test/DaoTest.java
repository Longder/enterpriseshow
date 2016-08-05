package com.yuntuofu.enterpriseshow.test;

import com.yuntuofu.enterpriseshow.dao.UserDao;
import com.yuntuofu.enterpriseshow.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Longder on 2016/7/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mvc.xml","classpath:spring/applicationContext.xml"})
public class DaoTest {
    @Resource
    private UserDao userDao;
    @Test
    public void testFindByLoginName(){
        User user = userDao.findByLoginName("longder");
        System.out.println(user.getLoginPassword());
/*        Assert.assertEquals("123456",user.getLoginPassword());
        Assert.assertEquals(1,user.getId().intValue());*/
    }
}
