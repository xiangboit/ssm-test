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
 * Created by Administrator on 2017/11/21.
 */
public class Score {
    private Long id;
    private String changeType;
    private Date createTime;
    private Integer score;
    private User user;

    public Score() {
    }

    public Score(Long id, String changeType, Date createTime, Integer score, User user) {
        this.id = id;
        this.changeType = changeType;
        this.createTime = createTime;
        this.score = score;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", changeType='" + changeType + '\'' +
                ", createTime=" + createTime +
                ", score=" + score +
                ", user=" + user +
                '}';
    }
}
