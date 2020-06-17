package com.mongo.smart_study.controller;

import com.mongo.smart_study.mapper.CMSUserMapper;
import com.mongo.smart_study.pojo.CMSUser;
import com.mongo.smart_study.utils.RespCode;
import com.mongo.smart_study.utils.RespEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cms")
public class CMUserController {

    @Resource
    private CMSUserMapper cmsUserMapper;

    @RequestMapping("/user_list")
    public List<CMSUser> getUserList() {
        return cmsUserMapper.getCMSUser();
    }

    @PostMapping("/add_user")
    public RespEntity addUser() {
        CMSUser cmsUser = new CMSUser("psq", "123456",  "123456@qq.com",  "15874732123", new Date());
        if(cmsUserMapper.addUser(cmsUser)==1){
            return new RespEntity(RespCode.Success);
        }
        return new RespEntity(RespCode.NotFound);
    }
}
