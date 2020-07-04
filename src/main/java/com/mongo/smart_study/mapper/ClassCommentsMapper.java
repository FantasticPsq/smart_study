package com.mongo.smart_study.mapper;

import com.mongo.smart_study.pojo.ClassComments;

import java.util.List;

public interface ClassCommentsMapper {

    /**通过课程id寻找该课程下所有的评论*/
    List<ClassComments> getClassCommentsById(long id);
    /**通过评论id获取评论实体*/
    ClassComments getCommentById(int id);
    /***进行评论*/
    int doCommentsByParam(long userId,long classId,String contents);
    /**进行评论*/
    int doComments(ClassComments classComments);
}
