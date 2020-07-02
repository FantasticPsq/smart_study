package com.mongo.smart_study.service;

import com.mongo.smart_study.mapper.ClassCommentsMapper;
import com.mongo.smart_study.mapper.ClassMapper;
import com.mongo.smart_study.mapper.CollectClassMapper;
import com.mongo.smart_study.mapper.UserMapper;
import com.mongo.smart_study.pojo.*;
import com.mongo.smart_study.pojo.Class;
import com.mongo.smart_study.pojo.RespClass.CommentsResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ClassService {

    @Autowired
    private ClassMapper classRepo;
    @Autowired
    private ClassCommentsMapper commentsRepo;
    @Autowired
    private UserMapper userRepo;
    @Autowired
    private CollectClassMapper collectClassRepo;
    @Value("${fileNotFoundPath}")
    private String fileNotFoundPath;

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
        return classRepo.findAllClassesByType(ClassType.senior.toString());
    }
    public List<Class> findAllJuniorClasses()
    {
        return classRepo.findAllClassesByType(ClassType.junior.toString());
    }

    /***作评论服务层**/
    public void doComments(String username,long classId,String content)
    {
        MyUser myUser=userRepo.findUserByName(username);
        if (myUser!=null)
        {
            ClassComments classComments=new ClassComments(classId,myUser.getId(),content);
            commentsRepo.doComments(classComments);
            classRepo.updateCommentNumById(classId);
        }
        else {
            //do nothing
        }
    }
    public List<CommentsResp> getAllCommentsByClassId(long id)
    {
        List<CommentsResp> commentsResp=new ArrayList<>();
        List<ClassComments> commentsList=commentsRepo.getClassCommentsById(id);
        String nickName=null;
        try {
            for (int i = 0; i < commentsList.size(); i++) {
                nickName=userRepo.getUserById(commentsList.get(i).getUserId()).getNickname();
                commentsResp.add(new CommentsResp(nickName,commentsList.get(i)));
            }
            return commentsResp;
        }catch (NullPointerException e)
        {
            return null;
        }
    }
    public String getClassPostSrc(long classID)
    {
        String postSrc=classRepo.getClassPostSrcById(classID);
        if (postSrc==null)
        {
            return fileNotFoundPath;
        }else
            return postSrc;
    }

    /***用户收藏课程得服务层，需要判断用户是否已经收藏了*/
    public void  collectClassService(String username,long classId)
    {
        MyUser myUser=userRepo.findUserByName(username);
        if (myUser==null)
        {
            return;
        }else {
            UserCollectedClass collectedClass=new UserCollectedClass(classId,myUser.getId(),username);
            if (collectClassRepo.check(collectedClass)==null)
            {
                collectClassRepo.addCollectClass(collectedClass);
                //并且需要同时跟新用户的课程数(收藏的课程的数量)
                userRepo.updateClassNumById(myUser.getId());
            }
        }
    }
    /***取消课程的收藏*/
    public void cancelCollectedClass(String username,long classId)
    {
        MyUser myUser=userRepo.findUserByName(username);
        if (myUser==null)
        {
            return;
        }else {
            UserCollectedClass collectedClass=new UserCollectedClass(classId,myUser.getId(),username);
            if (collectClassRepo.check(collectedClass)!=null)
            {
                collectClassRepo.deleteCollectClass(collectedClass);
                //并且需要同时跟新用户的课程数(收藏的课程的数量)
                userRepo.deleteClassNumById(myUser.getId());
            }
        }
    }
    public int addClass(String username,String name ,String classType,String description)
    {
        MyUser myUser=userRepo.findUserByName(username);
        Class myClass=new Class(name,classType,myUser.getUsername(),description);
        classRepo.addClass(myClass);
        return myClass.getId();
    }
    public void saveVideo(long classId,String videoPath)
    {
        classRepo.updateVideoSrcById(classId,videoPath);
    }
    public List<Class> getSwiperClasses()
    {
        //返回三个课程能够放在海报上的课程
        List<Class> classList=classRepo.getClasses();
        List<Class> classListReturn=new ArrayList<>();
        Random random=new Random();
        for (int i = 0; i < 3; i++) {
            classListReturn.add(classList.get(random.nextInt(classList.size())));
        }
        return classListReturn;
    }

    public List<Class> searchClass(String className)
    {
        List<Class> classList=classRepo.searchClass(className);
        return classList;
    }
}
