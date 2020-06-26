package com.mongo.smart_study.controller.controllerInterface;

import com.mongo.smart_study.utils.RespEntity;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ClassReqControllerInterface {
    /**获取视频相关信息的接口**/
    RespEntity getClassInfo() throws IOException;
    /**获取视频对应的评论接口*/
    RespEntity getClassComments() throws IOException;
    /**下载视频接口*/
    RespEntity DownloadVideo();
    /**视频播放接口*/
    public void getPlayResource(@PathVariable("resourceId") Long resourceId,
                                HttpServletRequest request,
                                HttpServletResponse response) throws Exception;
    /***请求推荐高中课程接口*/
    RespEntity getSeniorClasses();
    /***请求初中课程的接口**/
    RespEntity getJuniorClasses();
    /***获取推荐课程的接口*/
    RespEntity getRecommendClasses();
    /***对视频进行评论的接口*/
    RespEntity doComments() throws IOException;

}
