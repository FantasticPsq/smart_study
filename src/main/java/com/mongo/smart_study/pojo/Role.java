package com.mongo.smart_study.pojo;

import org.springframework.security.core.GrantedAuthority;

public enum  Role implements GrantedAuthority {
    CommonUser,Admin;
    @Override
    public String getAuthority() {
        return name();
    }
}
