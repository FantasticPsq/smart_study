package com.mongo.smart_study.mapper;

import com.mongo.smart_study.pojo.Class;

import java.util.List;

public interface ClassMapper {
    List<Class> getClasses();
    Class getClassById(int id);
    int addClass(Class myClass);

}
