package com.mongo.smart_study.pojo;

public enum Permission {
    visitor(1), user(2), manager(3), adminManager(4), superManager(5);
    private final int permission;

    Permission(int permission) {
        this.permission = permission;
    }

    public int getPermission() {
        return permission;
    }
}
