package com.yuntuofu.enterpriseshow.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 通用工具类
 * Created by Longder on 2016/7/18.
 */
public class CommonUtil {

    /**
     * 把json字符串转换为Map，其中对日期字符串进行处理，转换为Timestamp
     *
     * @param keys       指定哪些key需要进行日期转换
     * @param rex        日期正则表达式
     * @param jsonString
     * @return
     */
    public static Map<String, Object> parstJsonToMap(String[] keys, String rex, String jsonString) {
        SimpleDateFormat format = new SimpleDateFormat(rex);
        Map<String, Object> map = JSON.parseObject(jsonString, new TypeReference<Map<String, Object>>() {
        });
        //处理日期字符串
        for (String key : keys) {
            if (map.get(key) != null) {
                try {
                    map.put(key, new Timestamp(format.parse(map.get(key).toString()).getTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                    map.put(key, null);
                }
            }
        }
        return map;
    }

    /**
     * 计算总页数
     *
     * @param totalNumber 总条数
     * @param pageSize    页容量
     * @return 总页数
     */
    public static int getTotalPages(int totalNumber, int pageSize) {
        if (pageSize == 0) {
            return 0;
        }
        int totalPages;
        if (totalNumber % pageSize == 0) {
            totalPages = totalNumber / pageSize;
        } else {
            totalPages = totalNumber / pageSize + 1;
        }
        return totalPages;
    }
}
