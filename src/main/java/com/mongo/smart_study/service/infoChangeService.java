package com.mongo.smart_study.service;

import com.mongo.smart_study.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class infoChangeService {
    /**用户信息服务层
     * 负责用户的信息修改跟新
     * **/
    @Autowired
    private UserMapper userRepository;

    public void changeNickname(String username ,String nickName)
    {
        userRepository.updateNickNameByName(username,nickName);
    }
    public void changeMotto(String username,String motto)
    {
        userRepository.updateSignatureByName(username,motto);
    }


}
