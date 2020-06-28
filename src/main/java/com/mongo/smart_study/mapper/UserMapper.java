package com.mongo.smart_study.mapper;

import com.mongo.smart_study.pojo.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    /**获取全部用户*/
    List<MyUser> getUsers();
    /**增加用户*/
    int addUser(MyUser myUser);
    int deleteUser(MyUser myUser);
    int deleteUserById(int id);
    MyUser findUserByName(String username);
    /**用户是否存在*/
    boolean isUserExists(String username);
    /**id用户查询*/
    MyUser getUserById(long id);
    /**更新nickName*/
    int updateNickNameByName(String userName,String nickName);
    /**跟新个性签名*/
    int updateSignatureByName(String userName,String signature);
    /**更新学校*/
    int updateSchoolByName(String username,String school);
    /**更新用户手机号码**/
    int updatePhoneByName(String username,String phone);
    /**更新用户的邮箱号码*/
    int updateEmailByName(String username,String email);
    /**更新用户的课程数*/
    int updateClassNumById(long id);


}
