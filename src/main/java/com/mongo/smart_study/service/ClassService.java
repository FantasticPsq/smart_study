package com.mongo.smart_study.service;

import com.mongo.smart_study.mapper.ClassCommentsMapper;
import com.mongo.smart_study.mapper.ClassMapper;
import com.mongo.smart_study.mapper.UserMapper;
import com.mongo.smart_study.pojo.Class;
import com.mongo.smart_study.pojo.ClassComments;
import com.mongo.smart_study.pojo.ClassType;
import com.mongo.smart_study.pojo.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassMapper classRepo;
    @Autowired
    private ClassCommentsMapper commentsRepo;
    @Autowired
    private UserMapper userRepo;


    /****提供视频文件映射的服务***/
    public String findVideoSrcById(int id)
    {
        if (classRepo.findVideoSrcById(id)==null)
        {
            //说明视频的地址存在问题
            return "";
        }
        else {
            return classRepo.findVideoSrcById(id);
        }
    }

    public Class getClassInfoById(int id)
    {
        if (classRepo.getClassById(id)!=null)
            return classRepo.getClassById(id);
        else
            return new Class();
    }
    public List<Class> findAllSeniorClass()
    {
        return classRepo.findAllClassesByType(ClassType.junior.toString());
    }
    public List<Class> findAllJuniorClasses()
    {
        return classRepo.findAllClassesByType(ClassType.senior.toString());
    }

    /***作评论服务层**/
    public void doComments(String username,long classId,String content)
    {
        MyUser myUser=userRepo.findUserByName(username);
        if (myUser!=null)
        {
            commentsRepo.doComments(myUser.getId(),classId,content);
        }
        else {
            //do nothing
        }
    }
    public List<ClassComments> getAllCommentsByClassId(long id)
    {
        return commentsRepo.getClassCommentsById(id);
    }



}
