package com.mongo.smart_study.utils;

import com.mongo.smart_study.pojo.Role;

import java.util.ArrayList;
import java.util.List;

public class StringToRoleUtil {
    public static List<Role> stringToRoleUtil(String s) {
        String[] roles = s.split(",");
        List<Role> roleList = new ArrayList<>();
        for (String role : roles) {
            if (role.equals("CommonUser") || role.equals("common_user")) {
                roleList.add(Role.CommonUser);
            }
            if (role.equals("Admin") || role.equals("admin")) {
                roleList.add(Role.Admin);
            }
        }
        return roleList;
    }
}
