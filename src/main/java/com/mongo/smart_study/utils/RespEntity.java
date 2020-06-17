package com.mongo.smart_study.utils;

import java.io.Serializable;

public class RespEntity implements Serializable {
    private int code;
    private String msg;
    private Object data;
    public RespEntity(RespCode respCode){
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }
    public RespEntity(RespCode respCode,Object data){
        this(respCode);
        this.data = data;
    }

    //注意，要让Jackson能处理RespEntity，请确保有getter或者setter方法
    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
