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

    User getCMSUserById(int id);

    int addCMSUser(CMSUser user);

    int updateCMSUser(CMSUser user);

    int deleteCMSUser(int id);

    CMSUser findCMSUserByName(String username);

    boolean existsByName(String username);
}
