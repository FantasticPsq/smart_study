package com.mongo.smart_study.pojo;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.util.Date;

@Table(name = "class_comments")
public class ClassComments {


    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true, isAutoIncrement = true)
    private int id;
    @Column(name = "class_id",type = MySqlTypeConstant.BIGINT)
    private long classId;
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

    public ClassComments() {

    }
    public ClassComments(long classId, long userId, String content) {
        this.classId = classId;
        this.userId = userId;
        this.content = content;
        this.joinTime=new Date();
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
