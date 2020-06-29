package com.mongo.smart_study.mapper;

import com.mongo.smart_study.pojo.PostComments;

import java.util.List;

public interface PostCommentsMapper {
    /**发评论*/
    int addPostComment(PostComments postComments);
    /***检索所有评论*/
    List<PostComments> findAllPostCommentsById(long id);

}
