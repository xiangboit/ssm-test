/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mingjiang.test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mingjiang.test.bean.Gag;
import com.mingjiang.test.service.GagService;
import com.mingjiang.test.service.JedisClient;
import com.mingjiang.test.until.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ${符柱成} on 2017/4/2.
 */
@RestController
@RequestMapping("/gag")
public class GagController {
    @Autowired
    private GagService gagService;
    @Autowired
    private JedisClient jedisClient;

    @RequestMapping(value = "/gagList",produces="text/html;charset=UTF-8", method = {RequestMethod.POST,RequestMethod.GET})
    public String testRedis(Long id){
        List<Gag> gagList= null;
        try {
            String resulthget = jedisClient.hget("禁言表", id + "");
            if (resulthget !=null && !resulthget.equals("null") && !resulthget.equals("")) {
                //字符串转为list
                System.out.println("有缓存啦啦啦！！！");
                JSONArray array = JSONArray.parseArray(resulthget);
                gagList = (List) array;
                System.out.println(gagList);
            } else {
                System.out.println("禁言表没查过");
                gagList= gagService.findByUserId(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String cacheString = JsonUtils.objectToJson(gagList);
            jedisClient.hset("禁言表", id + "", cacheString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(gagList);
    }
}
