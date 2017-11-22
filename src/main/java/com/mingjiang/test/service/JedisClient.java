/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mingjiang.test.service;

import com.mingjiang.test.bean.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/22.
 */
public interface JedisClient {

    public String get(String key);
    public String set(String key, String value);
    public String hget(String hkey, String key);
    public long hset(String hkey, String key, String value);
    public long incr(String key);
    public long expire(String key, int second);
    public long ttl(String key);
    public long del(String key);
    public long hdel(String hkey, String key);
    public long zadd(String key, double score, User user);
    public Set<String> zgetAll(String key, long start, long end);
    //拿整个榜单
    public long zaddList(String key, List<User> userList);
    //拿去榜单最后一名，比如前50名，这里就拿到第50名的User。积分变化时就拿这个值去判断，大于就丢user进redis，小于则不管
    public Set<String> getTopLast(String key, long start, long end);
}
