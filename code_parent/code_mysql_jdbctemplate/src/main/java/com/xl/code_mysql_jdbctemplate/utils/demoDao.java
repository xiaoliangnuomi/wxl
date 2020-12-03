package com.xl.code_mysql_jdbctemplate.utils;

import com.xl.code_mysql_jdbctemplate.entity.PageVo;
import com.xl.code_mysql_jdbctemplate.entity.SearchParam;
import com.xl.code_mysql_jdbctemplate.entity.UserInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;

@Repository
public class demoDao {
    @Resource
    private PageUtil pageUtil;
    
    public PageVo getList(SearchParam searchParam) {
        ArrayList params = new ArrayList();
        String sql = "select * from user where 1=1 ";
        if (searchParam.getName() != null) {
            sql += " and name like '%?%'";
            params.add(searchParam.getName());
        }
        if (searchParam.getCreateTime() != null) {
            sql += " and create_Time >= ?";
            params.add(searchParam.getCreateTime());
        }
        sql += " order by id desc";

        Integer pageNum = searchParam.getPageNum();
        Integer pageSize = searchParam.getPageSize();
        PageVo res = pageUtil.queryForPage(sql, pageNum, pageSize, params.toArray(), new BeanPropertyRowMapper<>(UserInfo.class));
        return res;
    }
}