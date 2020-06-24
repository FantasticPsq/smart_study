package com.mongo.smart_study.mapper;

import com.mongo.smart_study.pojo.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<MyUser> getUsers();
    int addUser(MyUser myUser);
    int deleteUser(MyUser myUser);
    int deleteUserById(int id);
    MyUser findUserByName(String username);
    boolean isUserExists(String username);
    MyUser getUserById(int id);

}
