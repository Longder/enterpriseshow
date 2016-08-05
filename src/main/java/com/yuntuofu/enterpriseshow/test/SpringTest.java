package com.yuntuofu.enterpriseshow.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;

/**
 * 测试Spring容器
 * Created by Longder on 2016/7/18.
 */
public class SpringTest {
    private static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-mvc.xml");
    @Test
    public void testContext(){
        System.out.println(ac);
    }
    @Test
    public void testTimpstamp(){
        System.out.println(Timestamp.valueOf("2016-08-03 10:50:45"));
    }
}
