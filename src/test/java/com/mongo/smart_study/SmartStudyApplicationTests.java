package com.mongo.smart_study;

import com.mongo.smart_study.mapper.CMSUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import javax.xml.transform.Source;
import java.sql.SQLException;
import java.sql.SQLOutput;

@SpringBootTest
class SmartStudyApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired(required = false)
    CMSUserMapper cmsUserMapper;
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
        System.out.println(cmsUserMapper.getCMSUser());
    }

}
