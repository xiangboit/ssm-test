/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mingjiang.test.serviceimpl;

import com.mingjiang.test.bean.Gag;
import com.mingjiang.test.dao.GagDao;
import com.mingjiang.test.service.GagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ${符柱成} on 2017/4/1.
 */
@Service
public class GagServiceImpl implements GagService {
    @Autowired
    private GagDao gagDao;

    public int insertGag(Gag gag) {
        int t = gagDao.insertGag(gag);
        return t;
    }

    public List<Gag> findByUserId(Long id) {
        List<Gag> gagList=gagDao.findByUserId(id);
        return gagList;
    }
}
