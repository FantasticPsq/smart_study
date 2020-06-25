package com.mongo.smart_study.service;

import com.mongo.smart_study.mapper.UserMapper;
import com.mongo.smart_study.pojo.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class infoChangeService {
    /**用户信息服务层
     * 负责用户的信息修改跟新
     * **/
    @Autowired
    private UserMapper userRepository;

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

}
