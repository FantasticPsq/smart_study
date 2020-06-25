package com.mongo.smart_study.pojo;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

@Table(name = "class_comments")
public class ClassComments {


    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true, isAutoIncrement = true)
    private int id;
    @Column(name = "class_id",type = MySqlTypeConstant.BIGINT)
    private int class_id;
    @Column(name = "user_id",type = MySqlTypeConstant.BIGINT)
    private int user_id;
    @Column(name="content",type = MySqlTypeConstant.TEXT)
    private String content;
}
