/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mingjiang.test.test;

import com.mingjiang.test.bean.Score;
import com.mingjiang.test.dao.ScoreDao;
import com.mingjiang.test.service.ScoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/11/21.
 */
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration("/spring-*.xml")
    public class MyBatisTest {
        @Autowired
        private ScoreService scoreDao;

        @Test
        public void testAddScore() {
            Score score = new Score();
            score.setChangeType("充钱钱");
            score.setScore(10);
            int insert = scoreDao.insertScore(score);
            System.out.print("insert :"+insert);
        }
    }
