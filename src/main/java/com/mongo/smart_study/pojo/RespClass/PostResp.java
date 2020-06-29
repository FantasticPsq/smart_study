package com.mongo.smart_study.pojo.RespClass;

import com.mongo.smart_study.pojo.Post;
import com.mongo.smart_study.pojo.PostImages;

import java.util.List;

public class PostResp {
    private String masterNickName;
    private Post postData;
    private List<PostImages> postImages;

    public PostResp(String masterNickName, Post postData, List<PostImages> postImages) {
        this.masterNickName = masterNickName;
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
