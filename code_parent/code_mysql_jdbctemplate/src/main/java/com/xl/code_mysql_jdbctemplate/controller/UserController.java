package com.xl.code_mysql_jdbctemplate.controller;


import com.xl.code_mysql_jdbctemplate.entity.UserInfo;
import com.xl.code_mysql_jdbctemplate.service.UserInfo1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
//    @Qualifier(value = "userInfoService1")
    private UserInfo1Service userInfo1Service;

//    @ApiOperation(value = "获取用户总数",notes = "")
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public String getAllUsers(){
        return userInfo1Service.getAllUsers();
    }

    //http://127.0.0.1:8080/users/
//    @ApiOperation(value = "获取用户列表",notes = "")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Map<String, Object>> findAll(){
        List<Map<String, Object>> list = userInfo1Service.findAll();
        return list;
    }

    //http://127.0.0.1:8080/users/1
//    @ApiOperation(value = "获取用户",notes = "根据用户id获取用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserInfo getUserById(@PathVariable Long id){
        UserInfo userInfo = userInfo1Service.getById(id);
        return userInfo;
    }

    //http://127.0.0.1:8080/users/
//    @ApiOperation(value = "添加用户",notes = "添加用户")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public int addUser(UserInfo userInfo){
        //System.out.println(userInfo.getName());
        int res = userInfo1Service.addUser(userInfo);
        return res;
    }

//    @ApiOperation(value = "删除用户",notes = "根据用户Id删除用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int deleteUser(@PathVariable Long id){
        System.out.println(id);
        int res = userInfo1Service.deleteUser( id);
        return res;
    }

//    @ApiOperation(value = "修改用户信息",notes = "根据用户Id修改用户信息")
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public int updateUser(UserInfo userInfo){
        System.out.println(userInfo.getId());
        int isHas = (Integer) userInfo1Service.isHasUser(userInfo.getId());
        int res = 0;
        if (isHas==1){
            res = userInfo1Service.updateUser(userInfo);
        }
        return res;
    }

}