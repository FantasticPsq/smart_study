package com.mongo.smart_study.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongo.smart_study.controller.controllerInterface.UserInfoControllerInterface;
import com.mongo.smart_study.pojo.CMSUser;
import com.mongo.smart_study.pojo.MyUser;
import com.mongo.smart_study.service.UserService;
import com.mongo.smart_study.utils.RequestJsonUtil;
import com.mongo.smart_study.utils.RespCode;
import com.mongo.smart_study.utils.RespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserInfoController implements UserInfoControllerInterface {

    @Resource
    private UserService userService;
    @Resource
    private HttpServletRequest httpServletRequest;

    @Override
    @PostMapping("/login")
    public RespEntity login() throws IOException {
        Map<String, String> hashMap = RequestJsonUtil.getRequestJson(httpServletRequest);
        String token = userService.signin(hashMap.get("username"), hashMap.get("password"),hashMap.get("roles"));
        HashMap<String, String> hashMap1 = new HashMap<>();
        hashMap1.put("token", token);
        return new RespEntity(RespCode.Success, hashMap1);
    }

    @Override
    @PostMapping("/register")
    public RespEntity register() throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        if (StringUtils.hasText(body)) {
            JSONObject jsonObj = JSON.parseObject(body);
            String username = jsonObj.getString("username");
            String password = jsonObj.getString("password");
//            String phoneNumber = jsonObj.getString("phone_number");
//            String email = jsonObj.getString("email");
            String roles = jsonObj.getString("roles");
            MyUser newUser = new MyUser(username, password, roles);
            userService.signup(newUser);
            return new RespEntity(RespCode.Success);
        } else {
            return new RespEntity(RespCode.NotFound);
        }
    }

    @Override
    @PostMapping("/changeUserID")
    public RespEntity changeUserID() {
        return null;
    }

    @Override
    public RespEntity changeUserMotto() {
        return null;
    }

    @Override
    public RespEntity changeSchool() {
        return null;
    }

    @Override
    public RespEntity changePhone() {
        return null;
    }
}
