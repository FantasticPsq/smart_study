package com.mongo.smart_study.pojo;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;


import java.util.Date;

@Table(name = "cms_role")
public class CMSRole extends BaseModel {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true, isAutoIncrement = true)
    private long id;
    @Column(name = "role_name", type = MySqlTypeConstant.VARCHAR, isNull = false)
    private String name;
    @Column(name = "description", type = MySqlTypeConstant.VARCHAR, isNull = true)
    private String description;
    @Column(name = "create_time", type = MySqlTypeConstant.DATETIME, isNull = true)
    private Date createTime;
    @Column(name = "permissions", type = MySqlTypeConstant.INT, isNull = false)
    private int permissions = 1;

    public CMSRole() {
    }

    public CMSRole(String name, String description, Date createTime, int permissions) {
        this.name = name;
        this.description = description;
        this.createTime = createTime;
        this.permissions = permissions;
    }

    public long getId() {
        return id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public int getPermissions() {
        return permissions;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

}
