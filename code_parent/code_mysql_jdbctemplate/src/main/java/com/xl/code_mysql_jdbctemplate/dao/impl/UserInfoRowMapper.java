package com.xl.code_mysql_jdbctemplate.dao.impl;

import com.xl.code_mysql_jdbctemplate.entity.UserInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class UserInfoRowMapper implements RowMapper<UserInfo> {

    @Override
    public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        UserInfo stu = new UserInfo();
        stu.setId(resultSet.getLong("id"));
        stu.setAge(resultSet.getInt("age"));
        stu.setSex(resultSet.getInt("sex"));
        stu.setName(resultSet.getString("name"));
        return stu;
    }
}