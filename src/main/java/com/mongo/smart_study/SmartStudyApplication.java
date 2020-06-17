package com.mongo.smart_study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan({"com.gitee.sunchenbin.mybatis.actable.dao.*","com.mongo.smart_study.mapper"})
@SpringBootApplication()
@ComponentScan({"com.gitee.sunchenbin.mybatis.actable.manager.*"})
@ComponentScan("com.mongo.smart_study.controller")
public class SmartStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartStudyApplication.class, args);
    }

}
