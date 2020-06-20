package com.mongo.smart_study.mapper;

import com.mongo.smart_study.pojo.CMSRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CMSRoleMapper {
    List<CMSRole> getCMSRoles();

    List<String> getCMSRoleNames();

    CMSRole getCMSRoleById(int id);

    int addCMSRole(CMSRole cmsRole);

}
