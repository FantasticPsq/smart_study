package com.mongo.smart_study.controller.controllerInterface;

import com.mongo.smart_study.utils.RespEntity;

import java.io.IOException;

public interface UserInfoControllerInterface {
    /**增改部分**/
    RespEntity login() throws IOException;
    RespEntity register() throws IOException;
    RespEntity changeUserID() throws IOException;
    RespEntity changeUserMotto() throws IOException;
    RespEntity changeSchool() throws IOException;
    RespEntity changePhone() throws IOException;
    RespEntity changeEmail() throws IOException;

    /**获取部分**/
    /**作为我的界面进入请求的获取用户所有相关信息*/
    RespEntity getUserAllInfo();
    RespEntity getUserCollectedClasses();


}
