package com.mongo.smart_study.mapper;

import com.mongo.smart_study.pojo.UserCollectedClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollectClassMapper {
    /**收藏课程数*/
    int addCollectClass(UserCollectedClass collectedClass);
    /**得到指定用户得收藏课程**/
    List<UserCollectedClass> getUserCollectedClassById(long id);
    /***查看指定用户对指定课程的收藏*/
    UserCollectedClass check(UserCollectedClass userCollectedClass);
}
