package com.mongo.smart_study.pojo.RespClass;

import com.mongo.smart_study.pojo.Post;
import com.mongo.smart_study.pojo.PostImages;
import org.springframework.util.StringUtils;

import java.util.List;

public class PostResp {
    private String masterNickName;
    private String masterSchool;

    public String getMasterSchool() {
        return masterSchool;
    }

    public void setMasterSchool(String masterSchool) {
        this.masterSchool = masterSchool;
    }

    private Post postData;
    private List<PostImages> postImages;

    public PostResp(String masterNickName, String masterSchool,Post postData, List<PostImages> postImages) {
        this.masterNickName = masterNickName;
        this.masterSchool=masterSchool;
        this.postData = postData;
        this.postImages = postImages;
    }

    public String getMasterNickName() {
        return masterNickName;
    }

    public void setMasterNickName(String masterNickName) {
        this.masterNickName = masterNickName;
    }

    public Post getPostData() {
        return postData;
    }

    public void setPostData(Post postData) {
        this.postData = postData;
    }

    public List<PostImages> getPostImages() {
        return postImages;
    }

    public void setPostImages(List<PostImages> postImages) {
        this.postImages = postImages;
    }
}
