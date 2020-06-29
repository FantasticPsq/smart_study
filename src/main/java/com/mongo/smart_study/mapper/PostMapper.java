package com.mongo.smart_study.mapper;

import com.mongo.smart_study.pojo.Post;

import java.util.List;

public interface PostMapper {

    /**增加post*/
    int addPost(Post post);
    /**查找post*/
    Post findPostById(long id);
    /***/
    List<Post> findAllPost();
}
