package com.mongo.smart_study.security;

import com.mongo.smart_study.mapper.UserMapper;
import com.mongo.smart_study.pojo.MyUser;
import com.mongo.smart_study.utils.StringToRoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    private UserMapper userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = userRepository.findUserByName(username);
        if (myUser == null) {
            throw new UsernameNotFoundException("MyUser '" + username + "' not found");
        }
        System.out.println(StringToRoleUtil.stringToRoleUtil(myUser.getRoles()));
        System.out.println(myUser.getJoinTime());
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(myUser.getPassword())
                .authorities(StringToRoleUtil.stringToRoleUtil(myUser.getRoles()))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

}
