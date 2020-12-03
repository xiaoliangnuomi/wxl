package com.xl.code_mysql_jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class SpringbootJdbcApplicationTests {
    @Autowired
    DataSource dataSource;// 自动注入链接池数据源对象
    @Test
    void contextLoads() throws Exception {
        Connection connection = dataSource.getConnection();
        System.out.println("数据源："+dataSource);
        System.out.println("链接对象："+connection);
    }

}