package com.mongo.smart_study.pojo;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.util.Date;

@Table(name = "class")
public class Class {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true, isAutoIncrement = true)
    private int id;
    @Column(name = "name", type = MySqlTypeConstant.VARCHAR,length = 50)
    private String name;
    @Column(name = "rate",type = MySqlTypeConstant.INT)
    private int rate;
    @Column(name = "class_type",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String classType;
    @Column(name = "origin",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String origin;
    @Column(name = "description",type = MySqlTypeConstant.VARCHAR,length = 250)
    private String description;
    @Column(name = "video_url",type = MySqlTypeConstant.VARCHAR,length = 250)
    private String videoUrl;
    @Column(name = "post_url",type = MySqlTypeConstant.VARCHAR,length = 250)
    private String postUrl;
    @Column(name = "likes",type = MySqlTypeConstant.BIGINT)
    private int likesNum;
    @Column(name = "comments_num",type = MySqlTypeConstant.BIGINT)
    private int commentsNum;
    @Column(name = "watch_num",type = MySqlTypeConstant.BIGINT)
    private int watchNum;
    @Column(name = "join_time", type = MySqlTypeConstant.DATETIME)
    private Date joinTime;

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Class() {
    }

    public Class(String name, String origin, String description, String videoUrl, String postUrl) {
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.videoUrl = videoUrl;
        this.postUrl = postUrl;
        this.joinTime=new Date();
    }

    public Class(String name, String videoUrl, String postUrl) {
        this.name = name;
        this.videoUrl = videoUrl;
        this.postUrl = postUrl;
        this.joinTime=new Date();
    }

    public Class(String name, String videoUrl) {
        this.name = name;
        this.videoUrl = videoUrl;
        this.joinTime=new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public int getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(int likesNum) {
        this.likesNum = likesNum;
    }

    public int getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(int commentsNum) {
        this.commentsNum = commentsNum;
    }

    public int getWatchNum() {
        return watchNum;
    }

    public void setWatchNum(int watchNum) {
        this.watchNum = watchNum;
    }
    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}
