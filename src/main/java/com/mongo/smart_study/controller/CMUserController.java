package com.mongo.smart_study.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongo.smart_study.mapper.CMSUserMapper;
import com.mongo.smart_study.mapper.UserService;
import com.mongo.smart_study.pojo.CMSUser;
import com.mongo.smart_study.pojo.Role;
import com.mongo.smart_study.utils.RequestJsonUtil;
import com.mongo.smart_study.utils.RespCode;
import com.mongo.smart_study.utils.RespEntity;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping("/user")
public class CMUserController {

    @Resource
    private CMSUserMapper cmsUserMapper;
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private UserService userService;


    @RequestMapping("/user_list")
    public List<CMSUser> getUserList() {
        return cmsUserMapper.getCMSUser();
    }

    //    @PostMapping("/add_user")
//    public RespEntity addUser() {
//    }
    @PostMapping("/login")
    public RespEntity login() throws IOException {
        Map<String, String> hashMap = RequestJsonUtil.getRequestJson(httpServletRequest);
        String token = userService.signin(hashMap.get("username"), hashMap.get("password"));
        HashMap<String, String> hashMap1 = new HashMap<>();
        hashMap1.put("token", token);
        return new RespEntity(RespCode.Success, hashMap1);
    }

    @PostMapping("/register")
    public RespEntity register() throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        if (StringUtils.hasText(body)) {
            JSONObject jsonObj = JSON.parseObject(body);
            String username = jsonObj.getString("username");
            String password = jsonObj.getString("password");
            String phoneNumber = jsonObj.getString("phone_number");
            String email = jsonObj.getString("email");
            String roles = jsonObj.getString("roles");

            CMSUser cmsUser = new CMSUser(username, password, email, phoneNumber, roles);
            userService.signup(cmsUser);
            return new RespEntity(RespCode.Success);
        } else {
            return new RespEntity(RespCode.NotFound);
        }
    }
}
