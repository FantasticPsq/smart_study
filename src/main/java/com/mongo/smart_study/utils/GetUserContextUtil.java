package com.mongo.smart_study.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class GetUserContextUtil {
    /**
     * 说明：该类提供获取当前登录用户上下文的工具类，可以识别出每个验证用户的登录信息
     * */

    /**获取当前登录用户的用户名*/
    public String getCurrentUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        if (principal instanceof Principal) {
            return ((Principal) principal).getName();
        }
        return String.valueOf(principal);
    }



}
