package com.mongo.smart_study.pojo;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.util.Date;

@Table(name = "post")
public class Post {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true, isAutoIncrement = true)
    private long id;
    @Column(name="master_id",type = MySqlTypeConstant.BIGINT)
    private long masterId;
    @Column(name = "content", type = MySqlTypeConstant.VARCHAR,length = 250)
    private String content;
    @Column(name = "comments_num",type = MySqlTypeConstant.BIGINT)
    private int commentsNum;
    @Column(name = "likes_num",type = MySqlTypeConstant.BIGINT)
    private int likesNum;
    @Column(name = "join_time", type = MySqlTypeConstant.DATETIME)
    private Date joinTime;

    public Post() {
    }
    public Post(long masterId, String content) {
        this.masterId = masterId;
        this.content = content;
        this.joinTime = new Date();
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMasterId() {
        return masterId;
    }

    public void setMasterId(long masterId) {
        this.masterId = masterId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(int commentsNum) {
        this.commentsNum = commentsNum;
    }

    public int getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(int likesNum) {
        this.likesNum = likesNum;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
}
