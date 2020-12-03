package com.xl.code_mysql_jdbctemplate.utils;

import com.xl.code_mysql_jdbctemplate.entity.PageVo;
import com.xl.code_mysql_jdbctemplate.entity.SearchParam;
import com.xl.code_mysql_jdbctemplate.entity.UserInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ReportReviewDao {
    @Resource
    private PageUtils pageUtils;
    
    public PageVo getList(SearchParam searchParam) {
        String sql = "select * from user where 1=1 ";
        if (searchParam.getName() != null) {
            sql += " and name like '%:name%'";
        }
        if (searchParam.getCreateTime() != null) {
            sql += " and create_Time >= :createTime";
        }
        sql += " order by id desc";

        Integer pageNum = searchParam.getPageNum();
        Integer pageSize = searchParam.getPageSize();
        PageVo res = pageUtils.queryForPage(sql, pageNum, pageSize, searchParam, new BeanPropertyRowMapper<>(UserInfo.class));
        return res;
    }
}