package com.mongo.smart_study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.gitee.sunchenbin.mybatis.actable.dao.*")
@SpringBootApplication()
@ComponentScan(basePackages = {"com.gitee.sunchenbin.mybatis.actable.manager.*"})
public class SmartStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartStudyApplication.class, args);
    }

}
