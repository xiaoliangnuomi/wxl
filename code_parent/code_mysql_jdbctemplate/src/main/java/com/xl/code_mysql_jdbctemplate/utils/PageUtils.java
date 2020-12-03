package com.xl.code_mysql_jdbctemplate.utils;

import com.xl.code_mysql_jdbctemplate.entity.PageVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @创建人 jiangchun
 * @创建时间 2019/10/25
 * @描述
 */
@Log4j2
@Component
public class PageUtils {

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PageVo queryForPage(String sql, Integer pageNum, Integer pageSize, Object param, RowMapper rowMapper) throws DataAccessException {
        if (pageNum == null || pageSize == null) {
            return null;
        }
        if (pageNum < 1) {
            pageNum = 1;
        }
        if (pageSize < 1) {
            pageSize = 10;
        }
        PageVo result = new PageVo();

        //获取记录条数
        String countSql = "select count(1) as count from (" + sql + ") temp";
        log.info("countSql {}", countSql);

        List countList = namedParameterJdbcTemplate.queryForList(countSql, new BeanPropertySqlParameterSource(param), Integer.class);

        result.setTotal((Integer) countList.get(0));
        result.setPageNum(pageNum);
        result.setPageSize(pageSize);

        int pageCount = result.getTotal() % result.getPageSize();
        result.setPages(pageCount == 0 ? (result.getTotal() / result.getPageSize()) : (result.getTotal() / result.getPageSize() + 1));

        sql += parseLimit(result);

        List data = namedParameterJdbcTemplate.query(sql, new BeanPropertySqlParameterSource(param), rowMapper);
        result.setList(data);
        return result;
    }

    private String parseLimit(PageVo pagination) {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" limit ");
        stringBuffer.append(pagination.getPageSize());

        stringBuffer.append(" offset ");
        stringBuffer.append(pagination.getPageSize()*(pagination.getPageNum()-1));

        return stringBuffer.toString();
    }
}