package com.xl.code_mysql_jdbctemplate.dao;

import com.xl.code_mysql_jdbctemplate.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author xiaol
 * @Date 2020/12/3 14:51
 * @Version 1.0
 */
public interface UserInfoDao {
     String getAllUsers();
     List<Map<String, Object>> findAll();
     UserInfo getById(Long id);
     int addUser(UserInfo student);
     int deleteUser(Long id);
     int updateUser(UserInfo student);
     int isHasUser(Long id);
}
