package com.mongo.smart_study.pojo;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.util.Date;

@Table(name = "collect_class")
public class UserCollectedClass {

    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true, isAutoIncrement = true)
    private long id;
    @Column(name = "class_id",type = MySqlTypeConstant.BIGINT)
    private long classId;
    @Column(name = "user_id",type = MySqlTypeConstant.BIGINT)
    private long userId;
    @Column(name = "username",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String userName;
    @Column(name = "join_time", type = MySqlTypeConstant.DATETIME)
    private Date joinTime;

    public Date getJoinTime() {
        return joinTime;
    }

    public UserCollectedClass() {

    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public UserCollectedClass(long classId, long userId) {
        this.classId = classId;
        this.userId = userId;
        this.joinTime=new Date();
    }

    public UserCollectedClass(long classId, long userId, String userName) {
        this.classId = classId;
        this.userId = userId;
        this.userName = userName;
        this.joinTime=new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
