package com.xl.code_mysql_mybatis_plus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xl.code_mysql_mybatis_plus.entity.UserInfo;
import com.xl.code_mysql_mybatis_plus.service.UserInfoService;
import com.xl.entity.Result;
import com.xl.utils.R;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 用户controller
 *
 * @author
 * @email
 * @url
 * @date
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {
    Logger logger = LoggerFactory.getLogger(UserInfoController.class);
    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "认证接口",notes = "")
    @PostMapping("pageSearch/{current}/{size}")
    public R get(@RequestBody(required = false) UserInfo teacherQuery,
                                   @PathVariable long current,
                                   @PathVariable long size){
        Page<UserInfo> teacherPage = new Page<>(current, size);
        //构建条件
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        //多条件组合查询 可能有可能没有 动态sql->判断条件值是否为空，如果不为空拼接条件
        String name = teacherQuery.getName();
        Integer age = teacherQuery.getAge() ;
        Integer sex = teacherQuery.getSex();

        //SpringFramewfork有个工具类StringUtils
        if (!StringUtils.isEmpty(name)) {
            //如果不为空，构造条件
            queryWrapper.like("name", name);
        }
        if ( null != age && !StringUtils.isEmpty(age.toString())) {
            queryWrapper.ge("age", age);
        }
        if (null != sex && !StringUtils.isEmpty(sex.toString())) {
            queryWrapper.eq("sex", sex);
        }
        userInfoService.page(teacherPage, queryWrapper);
        //总记录数
        long total = teacherPage.getTotal();
        //数据集合
        List<UserInfo> records = teacherPage.getRecords();
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("total",total);
        hashMap.put("data",records);
        hashMap.forEach((k,v)->{
            System.out.println(k+ v.toString());
        });

        return R.ok(hashMap);

    }
}
