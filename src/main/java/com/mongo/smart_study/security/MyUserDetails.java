package com.mongo.smart_study.security;

import com.mongo.smart_study.mapper.CMSUserMapper;
import com.mongo.smart_study.pojo.CMSUser;
import com.mongo.smart_study.utils.StringToRoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    private CMSUserMapper userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CMSUser user = userRepository.findCMSUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }
        System.out.println(StringToRoleUtil.stringToRoleUtil(user.getRoles()));
        System.out.println(user.getJoinTime());
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getPassword())
                .authorities(StringToRoleUtil.stringToRoleUtil(user.getRoles()))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

}
