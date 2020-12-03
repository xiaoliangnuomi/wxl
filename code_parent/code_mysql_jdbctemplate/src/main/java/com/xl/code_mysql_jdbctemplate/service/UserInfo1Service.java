package com.xl.code_mysql_jdbctemplate.service;

import com.xl.code_mysql_jdbctemplate.entity.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfo1Service {
    /**
     * 获取用户总量
     * @return
     */
    String getAllUsers();

    /**
     * 获取全部学生
     * @return
     */
    List<Map<String, Object>> findAll();

    /**
     * 根据id获取学生
     * @param id
     * @return
     */
    UserInfo getById(Long id);

    /**
     * 增加学生
     * @param UserInfo
     * @return
     */
    int addUser(UserInfo UserInfo);

    /**
     * 根据id删除学生
     * @param id
     * @return
     */
    int deleteUser(Long id);

    /**
     * 修改学生信息
     * @param UserInfo
     * @return
     */
    int updateUser(UserInfo UserInfo);

    /**
     * 判断是否存在该学生
     * @param id
     * @return
     */
    int isHasUser(Long id);
}