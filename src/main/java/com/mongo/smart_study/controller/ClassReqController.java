package com.mongo.smart_study.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongo.smart_study.controller.controllerInterface.ClassReqControllerInterface;
import com.mongo.smart_study.pojo.Class;
import com.mongo.smart_study.pojo.RespClass.CommentsResp;
import com.mongo.smart_study.service.ClassService;
import com.mongo.smart_study.utils.GetUserContextUtil;
import com.mongo.smart_study.utils.NonStaticResourceHttpRequestHandler;
import com.mongo.smart_study.utils.RespCode;
import com.mongo.smart_study.utils.RespEntity;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@RequestMapping("/class")
@RestController
public class ClassReqController implements ClassReqControllerInterface {
    @Resource
    private NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;

    @Resource
    private ClassService classService;
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private GetUserContextUtil getUserContextUtil;

    @Override
    @RequestMapping("/getClassInfo")
    public RespEntity getClassInfo() throws IOException {
        //传入需要获取的课程的id
        String body=StreamUtils.copyToString(httpServletRequest.getInputStream(),StandardCharsets.UTF_8);
        if (StringUtils.hasText(body))
        {
            JSONObject jsonObject= JSON.parseObject(body);
            Class targetClass=classService.getClassInfoById(Integer.parseInt(jsonObject.getString("classID")));
            return new RespEntity(RespCode.Success,targetClass);
        }
        else
        {
        return new RespEntity(RespCode.NotFound);
        }
    }

    @Override
    @RequestMapping("/getClassComments")
    public RespEntity getClassComments() throws IOException {
        String body=StreamUtils.copyToString(httpServletRequest.getInputStream(),StandardCharsets.UTF_8);
        if (StringUtils.hasText(body))
        {
            JSONObject jsonObject=JSON.parseObject(body);
            try {
                long classId=Integer.parseInt(jsonObject.getString("classID"));
                List<CommentsResp> commentsList=classService.getAllCommentsByClassId(classId);
                return new RespEntity(RespCode.Success,commentsList);
            }
            catch ( NumberFormatException e)
            {
                return new RespEntity(RespCode.NotFound);
            }
        }
        else
            return new RespEntity(RespCode.NotFound);
    }


    @Override
    public RespEntity DownloadVideo() {
        //提供下载服务
        return null;
    }

    @GetMapping("/getPlayResource/{resourceId}")
    /****视频播放请求接口，video组件的请求地址*/
    public void getPlayResource(@PathVariable("resourceId") Long resourceId,
                                HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        try {
            int id=Integer.parseInt(request.getRequestURL().substring(request.getRequestURL().lastIndexOf("/")+1));
            String videoSrc=classService.findVideoSrcById(id);
            if (videoSrc!= null) {
                Path path = Paths.get(videoSrc);
                if (Files.exists(path)) {
                    String mimeType = Files.probeContentType(path);
                    if (!StringUtils.isEmpty(mimeType)) {
                        response.setContentType(mimeType);
                    }
                    request.setAttribute(NonStaticResourceHttpRequestHandler.ATTR_FILE, path);
                    nonStaticResourceHttpRequestHandler.handleRequest(request, response);
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
                }
            }
        }catch (NumberFormatException e)
        {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }
    @Override
    @RequestMapping("/getSeniorClasses")
    public RespEntity getSeniorClasses() {
        List<Class> classes=classService.findAllSeniorClass();
        if (classes==null||classes.size()==0)
            return new RespEntity(RespCode.NotFound);
        else
          return new RespEntity(RespCode.Success,classes);
    }
    @Override
    @RequestMapping("/getJuniorClasses")
    public RespEntity getJuniorClasses() {
        List<Class> classes=classService.findAllJuniorClasses();
        if (classes==null||classes.size()==0)
            return new RespEntity(RespCode.NotFound);
        else
            return new RespEntity(RespCode.Success,classes);
    }

    @Override
    @RequestMapping("/getRecommendClasses")
    public RespEntity getRecommendClasses() {
        return null;
    }

    @Override
    @RequestMapping("/doComments")
    /**评论请求接口，将评论存放到数据库中**/
    public RespEntity doComments() throws IOException {
        //需要知道是哪个人，哪个class，评论内容
        String username= getUserContextUtil.getCurrentUsername();
        String body=StreamUtils.copyToString(httpServletRequest.getInputStream(),StandardCharsets.UTF_8);
        if (StringUtils.hasText(body))
        {
            JSONObject jsonObject=JSON.parseObject(body);
            try {
                long classId=Integer.parseInt(jsonObject.getString("classID"));
                String content=jsonObject.getString("content");
                classService.doComments(username,classId,content);
                return new RespEntity(RespCode.Success);
            }
            catch (NumberFormatException e)
            {
                //说明发送的课程号是有问题的
                return new RespEntity(RespCode.NotFound);
            }
        }
        else
            return new RespEntity(RespCode.NotFound);
    }
    @Override
    @RequestMapping("/collectClass")
    /**收藏课程得接口,注意需要判断用户是否收藏课该课程，不能重复收藏*/
    public RespEntity collectClass() throws IOException {
        String username= getUserContextUtil.getCurrentUsername();
        String body=StreamUtils.copyToString(httpServletRequest.getInputStream(),StandardCharsets.UTF_8);
        if (StringUtils.hasText(body))
        {
            JSONObject jsonObject=JSON.parseObject(body);
            try
            {
                long classId=Integer.parseInt(jsonObject.getString("classID"));
                classService.collectClassService(username,classId);
                return new RespEntity(RespCode.Success);
            }catch (NumberFormatException ex)
            {
                return  new RespEntity(RespCode.NotFound);
            }

        }else
            return  new RespEntity(RespCode.NotFound);
    }


    /***取消课程的收藏**/
    @Override
    @RequestMapping("/cancelCollectedClass")
    public RespEntity cancelCollectClass() throws IOException {
        String username= getUserContextUtil.getCurrentUsername();
        String body=StreamUtils.copyToString(httpServletRequest.getInputStream(),StandardCharsets.UTF_8);
        if (StringUtils.hasText(body))
        {
            JSONObject jsonObject=JSON.parseObject(body);
            try
            {
                long classId=Integer.parseInt(jsonObject.getString("classID"));
                classService.cancelCollectedClass(username,classId);
                return new RespEntity(RespCode.Success);
            }catch (NumberFormatException ex)
            {
                return  new RespEntity(RespCode.NotFound);
            }
        }else
            return  new RespEntity(RespCode.NotFound);
    }

    /***视频海报请求地址，回传视频的海报*/
    @RequestMapping(value = "/getClassImage/{classID}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable("classID") long classID) throws IOException {
        FileInputStream inputStream=new FileInputStream(new File(classService.getClassPostSrc(classID)));
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }
}
