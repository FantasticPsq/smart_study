package com.mongo.smart_study.mapper;

import com.mongo.smart_study.pojo.PostImages;

import java.util.List;

public interface PostImageMapper {
    /**添加一个postImage*/
    int addPostImage(PostImages postImages);
    /***获得指定帖子的全部图片**/
    List<PostImages> getAllImagesById(long id);
    /***通过imageID获取图片*/
    PostImages getImageById(long id);
}
