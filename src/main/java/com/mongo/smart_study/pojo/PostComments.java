package com.mongo.smart_study.pojo;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.util.Date;

@Table(name = "post_comments")
public class PostComments {


    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true, isAutoIncrement = true)
    private int id;
    @Column(name = "post_id",type = MySqlTypeConstant.BIGINT)
    private long postId;
    @Column(name = "user_id",type = MySqlTypeConstant.BIGINT)
    private long userId;
    @Column(name="content",type = MySqlTypeConstant.TEXT)
    private String content;
    @Column(name = "join_time", type = MySqlTypeConstant.DATETIME)
    private Date joinTime;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public PostComments() {

    }
    public PostComments(long postId, long userId, String content) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.joinTime = new Date();
    }
    public long getPostId() {
        return postId;
    }


    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
}
