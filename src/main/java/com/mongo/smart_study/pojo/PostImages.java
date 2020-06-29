package com.mongo.smart_study.pojo;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.util.Date;

@Table(name = "post_images")
public class PostImages {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true, isAutoIncrement = true)
    private int id;
    @Column(name = "post_id",type = MySqlTypeConstant.BIGINT)
    private long postId;
    @Column(name = "image_src",type = MySqlTypeConstant.VARCHAR,length = 250)
    private String imageSrc;
    @Column(name = "join_time", type = MySqlTypeConstant.DATETIME)
    private Date joinTime;

    public PostImages(long postId, String imageSrc) {
        this.postId = postId;
        this.imageSrc = imageSrc;
        this.joinTime = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
}
