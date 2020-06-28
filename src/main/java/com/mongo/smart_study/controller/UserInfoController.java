package com.mongo.smart_study.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongo.smart_study.controller.controllerInterface.UserInfoControllerInterface;
import com.mongo.smart_study.pojo.Class;
import com.mongo.smart_study.pojo.MyUser;
import com.mongo.smart_study.pojo.UserCollectedClass;
import com.mongo.smart_study.service.UserService;
import com.mongo.smart_study.service.InfoService;
import com.mongo.smart_study.utils.RequestJsonUtil;
import com.mongo.smart_study.utils.RespCode;
import com.mongo.smart_study.utils.RespEntity;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mongo.smart_study.utils.GetUserContextUtil;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
/****为用户基本信息提供服务的Controller*****/
public class UserInfoController implements UserInfoControllerInterface {

    @Resource
    private UserService userService;
    @Resource
    private InfoService infoService;
    @Resource
    private HttpServletRequest httpServletRequest;

    @Resource
    private GetUserContextUtil getUserContextUtil;

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
            String roles = jsonObj.getString("roles");
            MyUser newUser = new MyUser(username, password, roles);
            userService.signup(newUser);
            return new RespEntity(RespCode.Success);
        } else {
            return new RespEntity(RespCode.NotFound);
        }
    }

    @Override
    @PostMapping("/changeNickName")
    public RespEntity changeUserID() throws IOException {
      /**
      更改用户的网名昵称
       获取username和新更改的nickName
      **/
      String username=getUserContextUtil.getCurrentUsername();
      String body=StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
      if (StringUtils.hasText(body))
      {
          JSONObject jsonObject=JSON.parseObject(body);
          infoService.changeNickname(username,jsonObject.getString("nickName"));
          return new RespEntity(RespCode.Success);
      }
      else
          return new RespEntity(RespCode.NotFound);
    }

    @Override
    @RequestMapping("/changeMotto")
    public RespEntity changeUserMotto() throws IOException {
        String username=getUserContextUtil.getCurrentUsername();
        String body=StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        if (StringUtils.hasText(body))
        {
            JSONObject jsonObject=JSON.parseObject(body);
            infoService.changeMotto(username,jsonObject.getString("motto"));
            return new RespEntity(RespCode.Success);
        }
        else {
            return new RespEntity(RespCode.NotFound);
        }

    }

    @Override
    @RequestMapping("/changeSchool")
    public RespEntity changeSchool() throws IOException {
        String username=getUserContextUtil.getCurrentUsername();
        String body=StreamUtils.copyToString(httpServletRequest.getInputStream(),StandardCharsets.UTF_8);
        if (StringUtils.hasText(body))
        {
            JSONObject jsonObject=JSON.parseObject(body);
            infoService.changeSchool(username,jsonObject.getString("school"));
            return new RespEntity(RespCode.Success);
        }
        else
           return new RespEntity(RespCode.NotFound);
    }

    @Override
    @RequestMapping("/changePhone")
    public RespEntity changePhone() throws IOException {
        String username=getUserContextUtil.getCurrentUsername();
        String body=StreamUtils.copyToString(httpServletRequest.getInputStream(),StandardCharsets.UTF_8);
        if (StringUtils.hasText(body))
        {
            JSONObject jsonObject=JSON.parseObject(body);
            infoService.changePhone(username,jsonObject.getString("phone"));
            return  new RespEntity(RespCode.Success);
        }
        else
            return new RespEntity(RespCode.NotFound);
    }

    @Override
    @RequestMapping("/changeEmail")
    public RespEntity changeEmail() throws IOException {
        String username=getUserContextUtil.getCurrentUsername();
        String body=StreamUtils.copyToString(httpServletRequest.getInputStream(),StandardCharsets.UTF_8);
        if (StringUtils.hasText(body))
        {
            JSONObject jsonObject=JSON.parseObject(body);
            infoService.changeEmail(username,jsonObject.getString("email"));
            return  new RespEntity(RespCode.Success);

        }
        else
            return new RespEntity(RespCode.NotFound);
    }

    @Override
    @RequestMapping("/getUserAllInfo")
    public RespEntity getUserAllInfo() {
        String username=getUserContextUtil.getCurrentUsername();
        MyUser myUser= infoService.getUserAllInfo(username);
        if (myUser!=null)
        {
            return new RespEntity(RespCode.Success,myUser);
        }else
        {
        return new RespEntity(RespCode.NotFound);
        }
    }

    @Override
    @RequestMapping("/getUserCollectedClasses")
    public RespEntity getUserCollectedClasses() {
        String username=getUserContextUtil.getCurrentUsername();
        List<Class> collectedClassList=infoService.getAllUserCollectedClasses(username);
        return new RespEntity(RespCode.Success,collectedClassList);
    }
}
