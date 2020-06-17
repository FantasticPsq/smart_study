package com.mongo.smart_study.mapper;

import com.mongo.smart_study.pojo.CMSUser;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CMSUserMapper {
    List<CMSUser> getCMSUser();
    User getUserById(int id);
    int addUser(CMSUser user);
    int updateUser(CMSUser user);
    int deleteUser(int id);
}
