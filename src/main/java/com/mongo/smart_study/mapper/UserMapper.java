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
    MyUser getUserById(int id);
    /**更新nickName*/
    int updateNickNameByName(String userName,String nickName);
    /**跟新个性签名*/
    int updateSignatureByName(String userName,String signature);

}
