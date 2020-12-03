package com.xl.code_mysql_jpa.service;

import com.xl.code_mysql_jpa.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author xiaol
 * @Date 2020/12/1 17:49
 * @Version 1.0
 */
public interface UserService {
    List<User> findAllUser();

    void add(User user);

    void update(User user);

    Page<User> findSearch(User searchMap, int page, int size);

    List<User> findByName(String name);
}
