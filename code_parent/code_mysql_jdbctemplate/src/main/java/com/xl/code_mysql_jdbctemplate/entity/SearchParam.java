package com.xl.code_mysql_jdbctemplate.entity;

import java.io.Serializable;

/**
 * @Author xiaol
 * @Date 2020/12/3 15:45
 * @Version 1.0
 */
public class SearchParam implements Serializable {
    private String name;
    private String createTime;
    private Integer pageNum;
    private Integer pageSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
