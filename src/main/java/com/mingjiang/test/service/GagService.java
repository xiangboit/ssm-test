/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mingjiang.test.service;


import com.mingjiang.test.bean.Gag;

import java.util.List;

/**
 * Created by ${符柱成} on 2017/4/1.
 */
public interface GagService {
    public int insertGag(Gag gag);
    List<Gag> findByUserId(Long id);
}
