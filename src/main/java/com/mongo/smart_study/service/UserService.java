package com.mongo.smart_study.service;

import javax.servlet.http.HttpServletRequest;

import com.mongo.smart_study.exception.CustomException;
import com.mongo.smart_study.mapper.UserMapper;

import com.mongo.smart_study.pojo.MyUser;
import com.mongo.smart_study.security.JwtTokenProvider;
import com.mongo.smart_study.utils.StringToRoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    /**用户身份服务层，主要用于登录，登录验证，注册，签发token*/

    @Autowired
    private UserMapper userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String signin(String username, String password,String roles,String nickName) {
        if (userRepository.findUserByName(username)==null)
        {
            //说明从来没有进行过登录，第一次登录需要注册，并且登录
            MyUser newUser=new MyUser(username,password,roles,nickName);
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            userRepository.addUser(newUser);
        }
        //注册之后仍需验证，签发token，避免前端多次点击
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return jwtTokenProvider.createToken(username, StringToRoleUtil.stringToRoleUtil(userRepository.findUserByName(username).getRoles()));

    }


    /**暂时无用*/
    public void signup(MyUser myUser) {
        if (userRepository.findUserByName(myUser.getUsername()) == null) {
            myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
            System.out.println(myUser.getRoles());
            userRepository.addUser(myUser);
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void delete(int id) {
        userRepository.deleteUserById(id);
    }
    public MyUser search(String username) {
        MyUser user = userRepository.findUserByName(username);
        if (user == null) {
            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return user;
    }

    public MyUser whoami(HttpServletRequest req) {
//        return userRepository.findCMSUserByName(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
        return null;
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, StringToRoleUtil.stringToRoleUtil(userRepository.findUserByName(username).getRoles()));
    }

}
