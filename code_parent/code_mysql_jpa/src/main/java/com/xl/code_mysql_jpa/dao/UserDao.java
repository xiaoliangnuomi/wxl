package com.xl.code_mysql_jpa.dao;

import com.xl.code_mysql_jpa.entity.User;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author xiaol
 * @Date 2020/12/1 17:47
 * @Version 1.0
 */
public interface UserDao extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

    @Query(value = "SELECT id,name,age,sex FROM user_info WHERE id = ?  ORDER BY age DESC", nativeQuery = true)
    Page<Problem> findMy1(String labelId, Pageable pageable);

    List<User> findByNameLike(String name);
    @Query(value = "select id,name,age,sex from user_info u where u.name like %?1% " , nativeQuery = true)
    List<User> searchName( String name);

}
