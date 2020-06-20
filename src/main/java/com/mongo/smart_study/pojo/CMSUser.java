package com.mongo.smart_study.pojo;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.mongo.smart_study.mapper.CMSRoleMapper;

import java.util.Date;
import java.util.List;

@Table(name = "cms_user")
public class CMSUser extends BaseModel {
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
    private List<Role> roles;
    //必须要有无参构造，否则无法getCMSUserList
    public CMSUser(){}

    public CMSUser(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.joinTime = new Date();
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
