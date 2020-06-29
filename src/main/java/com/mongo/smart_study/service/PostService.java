package com.mongo.smart_study.service;

import com.mongo.smart_study.mapper.PostCommentsMapper;
import com.mongo.smart_study.mapper.PostImageMapper;
import com.mongo.smart_study.mapper.PostMapper;
import com.mongo.smart_study.mapper.UserMapper;
import com.mongo.smart_study.pojo.MyUser;
import com.mongo.smart_study.pojo.Post;
import com.mongo.smart_study.pojo.PostComments;
import com.mongo.smart_study.pojo.PostImages;
import com.mongo.smart_study.pojo.RespClass.PostCommentResp;
import com.mongo.smart_study.pojo.RespClass.PostResp;
import com.mongo.smart_study.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/*******帖子相关服务层****/
@Service
public class PostService {

    @Autowired
    private PostImageMapper postImageRepo;
    @Autowired
    private PostMapper postRepo;
    @Autowired
    private PostCommentsMapper postCommentsRepo;
    @Autowired
    private UserMapper userRepo;


    public List<PostResp> getAllPost()
    {
            List<Post> posts=postRepo.findAllPost();
            MyUser user=null;
            List<PostImages> postImages=null;
            List<PostResp> postRespList=new ArrayList<>();
            for (int i = 0; i < posts.size(); i++) {
                user=userRepo.getUserById(posts.get(i).getMasterId());
                postImages=postImageRepo.getAllImagesById(posts.get(i).getId());
                postRespList.add(new PostResp(user.getNickname(),user.getSchool(),posts.get(i),postImages));
            }
            return postRespList;
    }
    public String getPostImageSrc(long imageID)
    {
        PostImages postImage=postImageRepo.getImageById(imageID);
        if (postImage==null)
            return "";
        else
            return postImage.getImageSrc();
    }

    public void savePostImage(String filePath,long postId,String username)
    {
        PostImages postImage=new PostImages(postId,filePath);
        postImageRepo.addPostImage(postImage);
    }


    public long doPost(String username,String content)
    {
        MyUser myUser=userRepo.findUserByName(username);
        if (myUser==null)
            return 0;
        Post post=new Post(myUser.getId(),content);
        postRepo.addPost(post);
        return post.getId();
        //返回post的id
    }

    /***返回post的所有的评论**/
    public List<PostCommentResp> getAllPostComments(long postId)
    {
        MyUser myUser=null;
        List<PostComments> postCommentsList=postCommentsRepo.findAllPostCommentsById(postId);
        List<PostCommentResp> postCommentRespList=new ArrayList<>();
        for (int i = 0; i <postCommentsList.size() ; i++) {
            myUser=userRepo.getUserById(postCommentsList.get(i).getUserId());
            postCommentRespList.add(new PostCommentResp(myUser.getNickname(),postCommentsList.get(i)));
        }
        return postCommentRespList;
    }
    /***做评论*/
    public void doPostComments(String username,long postId,String content)
    {
        MyUser myUser=userRepo.findUserByName(username);
        if (myUser==null)
            return;
        PostComments postComments=new PostComments(postId,myUser.getId(),content);
        postCommentsRepo.addPostComment(postComments);
    }


    /**通过id返回对应的post*/
    public  PostResp getPostById(long postId)
    {
        Post post=postRepo.findPostById(postId);
        MyUser myUser=userRepo.getUserById(post.getMasterId());
        List<PostImages> postImages=postImageRepo.getAllImagesById(postId);
        PostResp postResp=new PostResp(myUser.getNickname(),myUser.getSchool(),post,postImages);
        return postResp;
    }
}
