package com.xl.code_mysql_jdbctemplate.service.impl;

import com.xl.code_mysql_jdbctemplate.dao.UserInfoDao;
import com.xl.code_mysql_jdbctemplate.entity.UserInfo;
import com.xl.code_mysql_jdbctemplate.service.UserInfo1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author xiaol
 * @Date 2020/12/3 14:00
 * @Version 1.0
 */
@Service
public class UserInfo1ServiceImpl implements UserInfo1Service {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public String getAllUsers() {
        return userInfoDao.getAllUsers();
    }

    @Override
    public List<Map<String, Object>> findAll() {

        return userInfoDao.findAll();
    }

    @Override
    public UserInfo getById(Long id) {
        return userInfoDao.getById(id);
    }

    /**
     * 插入用户-防止sql注入-可以返回该条记录的主键
     *
     * @param student
     * @return
     */
    @Override
    public int addUser(UserInfo student) {
       return userInfoDao.addUser( student);
    }

    @Override
    public int deleteUser(Long id) {
        return userInfoDao.deleteUser( id);
    }

    @Override
    public int updateUser(UserInfo student) {
        return userInfoDao.updateUser( student);
    }

    @Override
    public int isHasUser(Long id) {
        return userInfoDao.isHasUser(id);
    }
}




