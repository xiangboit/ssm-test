/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mingjiang.test.serviceimpl;

import com.alibaba.fastjson.JSONArray;
import com.mingjiang.test.bean.User;
import com.mingjiang.test.service.JedisClient;
import com.mingjiang.test.until.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by ${符柱成} on 2017/3/31.
 */
@Service
public class JedisClientSingle implements JedisClient {

    @Autowired
    private JedisPool jedisPool;
    private int expiredTime = 60*60*24*2;//设置过期时间为两天.


    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.get(key);
        //解开注释即可体验过期策略
//        jedis.expire(key,5);
        jedis.close();
        return string;
    }

    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.set(key, value);
        //解开注释即可体验过期策略
//        jedis.expire(key,5);
//        System.out.println("key :  "+key);
//        System.out.println("查看key的剩余生存时间："+jedis.ttl(key));
        jedis.close();
        return string;
    }

    public String hget(String hkey, String key) {
        System.out.println("jedisPool   " + jedisPool);
        Jedis jedis = jedisPool.getResource();
        System.out.println("jedis   " + jedis);
        String string = jedis.hget(hkey, key);
        jedis.close();
        return string;
    }

    public long hset(String hkey, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hset(hkey, key, value);
        //解开注释即可体验过期策略
//        jedis.expire(hkey,expiredTime);
//        System.out.println("key :  "+key);
//        System.out.println("查看key001的剩余生存时间："+jedis.ttl(hkey));
        jedis.close();
        return result;
    }

    public long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    public long expire(String key, int second) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.expire(key, second);
        jedis.close();
        return result;
    }

    public long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

    public long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(key);
        jedis.close();
        return result;
    }

    public long hdel(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hdel(hkey, key);
        jedis.close();
        return result;
    }
    public long zaddList(String key,List<User> userList){
        Jedis jedis = jedisPool.getResource();
        Long result = null;
        for (int i=0;i<userList.size();i++){
            result = jedis.zadd(key, userList.get(i).getScore(), JsonUtils.objectToJson(userList.get(i)));
        }
        jedis.close();
        return result;
    }

    public long zadd(String key,double score,User user){
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.zadd(key, score, JsonUtils.objectToJson(user));
        jedis.close();
        return result;
    }
    public Set<String> zgetAll(String key,long start,long end){
        Jedis jedis = jedisPool.getResource();
        Set<String> userSet =jedis.zrange(key, start, end);
        System.out.println("userSet    :"+userSet);
        jedis.close();
        return userSet;
    }
    //拿最后一名的，所以start跟end必须标记最后一名的位置索引
    public Set<String> getTopLast(String key,long start,long end) {
        Jedis jedis = jedisPool.getResource();
        Set<String> userSet = jedis.zrange(key,start,end);
        System.out.println("userSet    :"+userSet);
        jedis.close();
        return userSet;
    }

}