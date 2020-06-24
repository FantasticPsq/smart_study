package com.mongo.smart_study.pojo;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.util.Date;

@Table(name = "user_info")
public class MyUser {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true, isAutoIncrement = true)
    private long id;
    @Column(name = "username", type = MySqlTypeConstant.VARCHAR, length = 50)
    private String username;
    @Column(name = "password", type = MySqlTypeConstant.VARCHAR, length = 250)
    private String password;
    @Column(name = "phone_number", type = MySqlTypeConstant.VARCHAR, length = 11)
    private String phoneNumber;
    @Column(name = "email", type = MySqlTypeConstant.VARCHAR, length = 50)
    private String email;
    @Column(name = "join_time", type = MySqlTypeConstant.DATETIME)
    private Date joinTime;
    @Column(name = "roles", type = MySqlTypeConstant.VARCHAR, length = 50)
    private String roles;

    @Column(name = "nick_name", type = MySqlTypeConstant.VARCHAR, length = 50)
    private String nickname;

    //个性签名
    @Column(name = "signature", type = MySqlTypeConstant.VARCHAR, length = 250)
    private  String signature;
    //学习时长
    @Column(name = "study_time",type =MySqlTypeConstant.INT )
    private int study_time;
    //余额
    @Column(name = "balance",type = MySqlTypeConstant.FLOAT)
    private float balance;
    //积分
    @Column(name = "integral",type = MySqlTypeConstant.INT)
    private int integral;
    @Column(name = "school",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String school;
    @Column(name = "role_id",type = MySqlTypeConstant.INT)
    private int role_id;
    @Column(name = "union_id",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String union_id;
    public MyUser(){
    }
    public MyUser(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.joinTime = new Date();
        this.roles = roles;
    }

    public MyUser(String username, String password, String phoneNumber, String email, String roles) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.joinTime = new Date();
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getStudy_time() {
        return study_time;
    }

    public void setStudy_time(int study_time) {
        this.study_time = study_time;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getUnion_id() {
        return union_id;
    }

    public void setUnion_id(String union_id) {
        this.union_id = union_id;
    }

}
