package com.mongo.smart_study.mapper;

import javax.servlet.http.HttpServletRequest;

import com.mongo.smart_study.exception.CustomException;
import com.mongo.smart_study.pojo.CMSUser;
import com.mongo.smart_study.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private CMSUserMapper userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, passwordEncoder.encode(password)));
            System.out.println(1);
            return jwtTokenProvider.createToken(username, userRepository.findCMSUserByName(username).getRoles());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void signup(CMSUser user) {
        if (userRepository.findCMSUserByName(user.getUsername()) == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.addCMSUser(user);
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void delete(int id) {
        userRepository.deleteCMSUser(id);
    }

    public CMSUser search(String username) {
        CMSUser user = userRepository.findCMSUserByName(username);
        if (user == null) {
            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return user;
    }

    public CMSUser whoami(HttpServletRequest req) {
        return userRepository.findCMSUserByName(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findCMSUserByName(username).getRoles());
    }

}
