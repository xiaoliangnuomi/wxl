package com.xl.code_mysql_jpa.service.impl;

import com.xl.code_mysql_jpa.dao.UserDao;
import com.xl.code_mysql_jpa.entity.User;
import com.xl.code_mysql_jpa.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author xiaol
 * @Date 2020/12/1 17:49
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<User> findAllUser() {
        return  userDao.findAll();

    }

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.save(user);
    }

    @Override
    public Page<User> findSearch(User searchMap, int page, int size) {
        Specification<User> specification = createSpecification(searchMap);
        PageRequest pageable = PageRequest.of(page - 1, size);

        return userDao.findAll(specification,pageable);
    }

    @Override
    public List<User> findByName(String name) {
        return userDao.findByNameLike(name);

    }

    private Specification<User> createSpecification(User searchMap) {

        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (!"".equals(searchMap.getId()) && searchMap.getId()!=null){
                    list.add(cb.like(root.get("id").as(String.class), "%"+searchMap.getId()+"%"));
                }
                if (!StringUtils.isEmpty(searchMap.getName()) && searchMap.getName()!=null){
                    list.add(cb.like(root.<String>get("name"),"%"+(String)searchMap.getName()+"%"));
                }
                if ( !"".equals(searchMap.getAge())&& searchMap.getAge()!=null){
                    list.add(cb.like(root.get("age"),"%"+searchMap.getAge()+"%"));
                }
                if ( !"".equals(searchMap.getSex())&& searchMap.getSex()!=null){
                    list.add( cb.like(root.get("sex"),"%"+searchMap.getSex()+"%"));
                }
                return cb.and( list.toArray(new Predicate[list.size()]));
            }
        };
    }
}
