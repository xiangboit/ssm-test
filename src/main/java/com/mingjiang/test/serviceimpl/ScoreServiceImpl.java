/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mingjiang.test.serviceimpl;

import com.mingjiang.test.bean.Score;
import com.mingjiang.test.dao.ScoreDao;
import com.mingjiang.test.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/21.
 */
@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private ScoreDao scoreDao;
    public int insertScore(Score score) {

        int num=scoreDao.insertScore(score);
        return num;
    }
}
