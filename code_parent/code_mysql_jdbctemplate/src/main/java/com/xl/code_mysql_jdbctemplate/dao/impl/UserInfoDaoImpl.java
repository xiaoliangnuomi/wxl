package com.xl.code_mysql_jdbctemplate.dao.impl;

import com.xl.code_mysql_jdbctemplate.dao.UserInfoDao;
import com.xl.code_mysql_jdbctemplate.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author xiaol
 * @Date 2020/12/3 14:52
 * @Version 1.0
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public String getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from user_info", String.class);
    }

    @Override
    public List<Map<String, Object>> findAll() {
        String sql = "select * from user_info";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    @Override
    public UserInfo getById(Long id) {
        String sql = "select * from user_info where id = ? ";
        List<UserInfo> stu = jdbcTemplate.query(sql, new Object[]{id}, new UserInfoRowMapper());
        UserInfo student = null;
        if (!stu.isEmpty()) {
            student = stu.get(0);
        }
        return student;
    }

    @Override
    public int addUser(UserInfo student) {
        String sql = "insert longo student(id,name,sex,age) values(null,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int resRow = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, student.getName());
                ps.setInt(2, student.getSex());
                ps.setInt(3, student.getAge());
                return ps;
            }
        }, keyHolder);
        System.out.println("操作记录数：" + resRow + " 主键：" + keyHolder.getKey());
        return Integer.parseInt(keyHolder.getKey().toString());
    }

    @Override
    public int deleteUser(Long id) {
        String sql = "delete from student where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateUser(UserInfo student) {
        String sql = "update student set name=?,sex=?,age=? where id=?";
        int res = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, student.getName());
                preparedStatement.setInt(2, student.getSex());
                preparedStatement.setInt(3, student.getAge());
                preparedStatement.setLong(4, student.getId());
            }
        });
        return res;
    }

    @Override
    public int isHasUser(Long id) {
        String sql = "select * from student where id=?";
        List<UserInfo> student = jdbcTemplate.query(sql, new Object[]{id}, new UserInfoRowMapper());
        if (student != null && student.size() > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
