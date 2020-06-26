package com.mongo.smart_study.pojo;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

@Table(name = "class")
public class Class {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true, isAutoIncrement = true)
    private int id;
    @Column(name = "name", type = MySqlTypeConstant.VARCHAR,length = 50)
    private String name;
    @Column(name = "rate",type = MySqlTypeConstant.INT)
    private int rate;
    @Column(name = "class_type",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String type;
    @Column(name = "origin",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String origin;
    @Column(name = "description",type = MySqlTypeConstant.VARCHAR,length = 250)
    private String description;
    @Column(name = "video_url",type = MySqlTypeConstant.VARCHAR,length = 250)
    private String video_Url;
    @Column(name = "post_url",type = MySqlTypeConstant.VARCHAR,length = 250)
    private String post_Url;
    @Column(name = "likes",type = MySqlTypeConstant.BIGINT)
    private int likes_num;
    @Column(name = "comments_num",type = MySqlTypeConstant.BIGINT)
    private int comments_num;
    @Column(name = "watch_num",type = MySqlTypeConstant.BIGINT)
    private int watch_num;

    public Class() {
    }

    public Class(String name, String origin, String description, String video_Url, String post_Url) {
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.video_Url = video_Url;
        this.post_Url = post_Url;
    }

    public Class(String name, String video_Url, String post_Url) {
        this.name = name;
        this.video_Url = video_Url;
        this.post_Url = post_Url;
    }

    public Class(String name, String video_Url) {
        this.name = name;
        this.video_Url = video_Url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideo_Url() {
        return video_Url;
    }

    public void setVideo_Url(String video_Url) {
        this.video_Url = video_Url;
    }

    public String getPost_Url() {
        return post_Url;
    }

    public void setPost_Url(String post_Url) {
        this.post_Url = post_Url;
    }

    public int getLikes_num() {
        return likes_num;
    }

    public void setLikes_num(int likes_num) {
        this.likes_num = likes_num;
    }

    public int getComments_num() {
        return comments_num;
    }

    public void setComments_num(int comments_num) {
        this.comments_num = comments_num;
    }

    public int getWatch_num() {
        return watch_num;
    }

    public void setWatch_num(int watch_num) {
        this.watch_num = watch_num;
    }
}
