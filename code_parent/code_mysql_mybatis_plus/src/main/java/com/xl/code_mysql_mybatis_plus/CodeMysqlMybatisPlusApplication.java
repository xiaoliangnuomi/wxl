package com.xl.code_mysql_mybatis_plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
@MapperScan(basePackages = {"com.xl.code_mysql_mybatis_plus.dao"})
public class CodeMysqlMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeMysqlMybatisPlusApplication.class, args);
    }

}
