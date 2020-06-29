package com.mongo.smart_study.controller.controllerInterface;

import com.mongo.smart_study.utils.RespEntity;

import java.io.IOException;

public interface PostReqControllerInterface {
    /***发帖子接口**/
    RespEntity post() throws IOException;
    /***获取所有的帖子的接口**/
    RespEntity getAllPost();
    /****/


}
