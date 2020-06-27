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
    //课程数
    @Column(name = "class_num",type = MySqlTypeConstant.INT)
    private Integer classNum;
    //个性签名
    @Column(name = "signature", type = MySqlTypeConstant.VARCHAR, length = 250)
    private  String signature;
    //学习时长
    @Column(name = "study_time",type =MySqlTypeConstant.INT )
    private Integer studyTime;
    //余额
    @Column(name = "balance",type = MySqlTypeConstant.FLOAT)
    private float balance;

    @Column(name = "imageUrl", type = MySqlTypeConstant.VARCHAR,length = 250)
    private String imageUrl;
    /**积分*/
    @Column(name = "integral",type = MySqlTypeConstant.INT)
    private Integer integral;
    @Column(name = "school",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String school;
    @Column(name = "role_id",type = MySqlTypeConstant.INT)
    private int roleId;
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
    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public Integer getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(Integer studyTime) {
        this.studyTime = studyTime;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUnion_id() {
        return union_id;
    }

    public void setUnion_id(String union_id) {
        this.union_id = union_id;
    }

}
