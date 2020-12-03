package com.xl.code_mysql_jpa.controller;

import com.xl.code_mysql_jpa.dao.UserDao;
import com.xl.code_mysql_jpa.entity.User;
import com.xl.code_mysql_jpa.service.UserService;
import com.xl.entity.PageResult;
import com.xl.entity.Result;
import com.xl.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @Author xiaol
 * @Date 2020/12/1 17:54
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    /**
     *
     * @return Result
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAllUser(){
        return new Result(StatusCode.OK.getCode(),"success",userService.findAllUser());
    }
    /**
     * 分页+多条件查询
     * @param searchMap 查询条件封装
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @RequestMapping(value="/search/{page}/{size}", method=RequestMethod.POST)
    public Result findSearch(@RequestBody User user , @PathVariable int page, @PathVariable int size){
        Page<User> pageList = userService.findSearch(user,  page,  size);
        return  new Result(true, StatusCode.OK.getCode(), "查询成功",   new PageResult<User>(pageList.getTotalElements(),  pageList.getContent()) );
    }
    @RequestMapping(method = RequestMethod.POST)
    public Result addUser(@RequestBody User user){
        userService.add(user);
        return new Result(StatusCode.OK.getCode(),"success","");
    }
    @PutMapping("/{id}")
    public Result updateUser(@RequestBody User user,@PathVariable Long id){
        user.setId(id);
        userService.update(user);
        return new Result(StatusCode.OK.getCode(),"success","");
    }
    @RequestMapping(value = "/name1", method = RequestMethod.GET)
    public Result findUserByName( @RequestParam("name") String name){
        System.out.println("name:"+name);
        List<User> users = userService.findByName("%"+name+"%");
//        List<User> users = userDao.searchName(name);
        return new Result(StatusCode.OK.getCode(),"success",users);
    }
}
