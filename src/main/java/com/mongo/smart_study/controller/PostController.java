package com.mongo.smart_study.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongo.smart_study.controller.controllerInterface.PostReqControllerInterface;
import com.mongo.smart_study.pojo.RespClass.PostResp;
import com.mongo.smart_study.service.PostService;
import com.mongo.smart_study.utils.FileUtils;
import com.mongo.smart_study.utils.GetUserContextUtil;
import com.mongo.smart_study.utils.RespCode;
import com.mongo.smart_study.utils.RespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/post")
@RestController
public class PostController implements PostReqControllerInterface {
    @Resource
    private PostService postService;
    @Resource
    private GetUserContextUtil getUserContextUtil;
    @Resource
    private HttpServletRequest httpServletRequest;



    private final ResourceLoader resourceLoader;
    @Autowired
    public PostController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @Value("${postImagesPath}")
    private String path;
    /**
     *
     * @param file 要上传的文件
     * @return
     */
    @RequestMapping("/fileUpload")
    public RespEntity upload(@RequestParam("filename") MultipartFile file, Map<String, Object> map){
        //这里是需要拿到postId的
        try{
            long postId=Long.parseLong(httpServletRequest.getParameter("postId"));
            String username=getUserContextUtil.getCurrentUsername();
            String realPath=FileUtils.upload(file, path, file.getOriginalFilename());
            if (realPath!=null&&postId>0){
                // 上传成功，给出页面提示
                postService.savePostImage(realPath,postId,username);
                return new RespEntity(RespCode.Success);
            }else {
                return new RespEntity(RespCode.NotFound);
            }
            // 显示图片
        }catch (NumberFormatException e)
        {
            return new RespEntity(RespCode.NotFound);
        }
    }
    @RequestMapping(value = "/getPostImage/{ImageID}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable("ImageID") long ImageID) throws IOException {
        FileInputStream inputStream=new FileInputStream(new File(postService.getPostImageSrc(ImageID)));
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }
    @RequestMapping("/doPost")
    public RespEntity post() throws IOException {
        String body= StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        String username=getUserContextUtil.getCurrentUsername();
        if (StringUtils.hasText(body))
        {
            JSONObject jsonObject= JSON.parseObject(body);
            long postId=postService.doPost(username,jsonObject.getString("content"));
            HashMap<String,Long> map=new HashMap<>();
            map.put("postId",postId);
            return new RespEntity(RespCode.Success,map);
        }
        else {
            return new RespEntity(RespCode.NotFound);
        }
    }
    @Override
    @RequestMapping("/getAllPost")
    /**获取全部的帖子*/
    public RespEntity getAllPost() {
        List<PostResp>   postRespList=postService.getAllPost();
        return new RespEntity(RespCode.Success,postRespList);
    }

}
