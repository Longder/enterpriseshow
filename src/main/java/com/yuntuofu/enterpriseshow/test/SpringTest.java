package com.yuntuofu.enterpriseshow.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试Spring容器
 * Created by Longder on 2016/7/18.
 */
public class SpringTest {
    private static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    @Test
    public void testContext(){
        System.out.println(ac);
    }

}
