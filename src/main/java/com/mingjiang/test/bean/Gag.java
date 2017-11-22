/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mingjiang.test.bean;

import java.util.Date;

/**
 * Created by ${符柱成} on 2017/3/31.
 */
public class Gag {
    private Long id;
    //创建的时间
    private Date createTime;
    //禁言到某个时间
    private Date gagTime;
    //被禁言者
    private User user;

    public Gag() {
    }

    public Gag(Long id, Date createTime, Date gagTime, User user) {
        this.id = id;
        this.createTime = createTime;
        this.gagTime = gagTime;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getGagTime() {
        return gagTime;
    }

    public void setGagTime(Date gagTime) {
        this.gagTime = gagTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
