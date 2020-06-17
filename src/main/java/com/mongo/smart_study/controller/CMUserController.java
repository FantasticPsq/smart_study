package com.mongo.smart_study.controller;

import com.mongo.smart_study.mapper.CMSUserMapper;
import com.mongo.smart_study.pojo.CMSUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/first")
public class CMUserController {

    @Resource
    private CMSUserMapper cmsUserMapper;

    @RequestMapping("/")
    public List<CMSUser> getUserList() {
        System.out.println(1);
        return cmsUserMapper.getCMSUser();
//        return "success";
    }
}
