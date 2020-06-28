package com.mongo.smart_study.mapper;

import com.mongo.smart_study.pojo.Class;

import java.util.List;

public interface ClassMapper {
    List<Class> getClasses();
    Class getClassById(long id);
    int addClass(Class myClass);
    /***通过课程id来查找课程的在服务器中存放的地址*/
    String findVideoSrcById(int id);
    /***查找表中所有的高中课程*/
    List<Class> findAllSeniorClasses();
    /**查找表中所有的初中课程**/
    List<Class> findAllJuniorClasses();
    /**根据课程种类寻找*/
    List<Class> findAllClassesByType(String type);

    /**根据课程id寻找课程的海报的地址*/
    String getClassPostSrcById(long id);
    /**根据课程得id跟新课程对应得评论数*/
    int updateCommentNumById(long id);
    int updateLikeNumById(long id);

}
