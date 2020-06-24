package com.mongo.smart_study.controller.controllerInterface;

import com.mongo.smart_study.utils.RespEntity;

import java.io.IOException;

public interface UserInfoControllerInterface {
    RespEntity login() throws IOException;
    RespEntity register() throws IOException;
    RespEntity changeUserID() throws IOException;
    RespEntity changeUserMotto() throws IOException;
    RespEntity changeSchool();
    RespEntity changePhone();
}
