package com.mongo.smart_study.controller;

import com.mongo.smart_study.mapper.CMSRoleMapper;
import com.mongo.smart_study.pojo.CMSRole;
import com.mongo.smart_study.pojo.Permission;
import com.mongo.smart_study.utils.RespCode;
import com.mongo.smart_study.utils.RespEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class CMSRoleController {
    @Resource
    CMSRoleMapper cmsRoleMapper;

//    @PostMapping("/add_role")
//    public RedirectView addRole() {
//        RedirectView redirectView = new RedirectView();
//        redirectView.setContextRelative(true);
//        redirectView.setUrl("get_roles");
//        return redirectView;
//    }
    @GetMapping("/get_roles")
    public List<CMSRole> getRole(){
        return  cmsRoleMapper.getCMSRoles();
    }

}
