package com.mongo.smart_study.service;

import com.mongo.smart_study.mapper.ClassMapper;
import com.mongo.smart_study.mapper.CollectClassMapper;
import com.mongo.smart_study.mapper.UserMapper;
import com.mongo.smart_study.pojo.Class;
import com.mongo.smart_study.pojo.MyUser;
import com.mongo.smart_study.pojo.UserCollectedClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoService {
    /**用户信息服务层
     * 负责用户的信息修改跟新
     * **/
    @Autowired
    private UserMapper userRepository;
    @Autowired
    private CollectClassMapper collectClassRepo;
    @Autowired
    private ClassMapper classRepo;

    /**更改用户昵称服务层*/
    public void changeNickname(String username ,String nickName)
    {
        userRepository.updateNickNameByName(username,nickName);
    }


    public void changeMotto(String username,String motto)
    {
        userRepository.updateSignatureByName(username,motto);
    }

    public void changeSchool(String username,String school)
    {
        userRepository.updateSchoolByName(username,school);
    }

    public void changePhone(String username,String phone)
    {
        userRepository.updatePhoneByName(username,phone);
    }
    public void changeEmail(String username,String email)
    {
        userRepository.updateEmailByName(username,email);
    }

    public MyUser getUserAllInfo(String username)
    {
        //这里暂时没有考虑用户重名的情况
        return userRepository.findUserByName(username);
    }
    public List<Class> getAllUserCollectedClasses(String username)
    {
        MyUser myUser=userRepository.findUserByName(username);
        if (myUser==null)
            return null;
        else {
          List<UserCollectedClass> collectedClassList=collectClassRepo.getUserCollectedClassById(myUser.getId());
          List<Class> classList=new ArrayList<>();
          Class collectedClass=null;
          //根据收藏的课程的课程号找到每一个课程的课程实体
            for (int i = 0; i < collectedClassList.size(); i++) {
                collectedClass=classRepo.getClassById(collectedClassList.get(i).getClassId());
                classList.add(collectedClass);
            }
            return classList;
        }

    }
}
