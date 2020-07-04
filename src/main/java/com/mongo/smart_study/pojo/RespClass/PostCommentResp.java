package com.mongo.smart_study.pojo.RespClass;

import com.mongo.smart_study.pojo.PostComments;

public class PostCommentResp {
    private String nickName;
    private PostComments postComment;

    public PostCommentResp(String nickName, PostComments postComment) {
        this.nickName = nickName;
        this.postComment = postComment;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public PostComments getPostComment() {
        return postComment;
    }

    public void setPostComment(PostComments postComment) {
        this.postComment = postComment;
    }
}
