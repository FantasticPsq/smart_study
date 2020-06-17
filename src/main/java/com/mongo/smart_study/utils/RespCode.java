package com.mongo.smart_study.utils;

import java.util.HashMap;

public enum RespCode {
    Success(200,"success"),
    NotFound(404,"not found");

    private final int code;
    private final String msg;

    RespCode(int code, String msg){
        this.msg = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
