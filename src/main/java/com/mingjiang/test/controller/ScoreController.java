/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mingjiang.test.controller;

import com.alibaba.fastjson.JSON;
import com.mingjiang.test.bean.Score;
import com.mingjiang.test.service.ScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/21.
 */
@RestController
@RequestMapping("/score")
@SuppressWarnings("unchecked")
public class ScoreController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/insert",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/html;charset=UTF-8")
    public String insert(){
        Score score1=new Score();
        score1.setScore(10);
        score1.setChangeType("玩游戏");
        int num=scoreService.insertScore(score1);
        System.out.println(""+num);
        return JSON.toJSONString(score1);
    }
}
