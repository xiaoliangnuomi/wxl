package com.xl.code_mysql_jdbctemplate.entity;


import org.springframework.stereotype.Repository;

/**
 * @Author xiaol
 * @Date 2020/12/1 17:50
 * @Version 1.0
 */
public class UserInfo {

    private Long id;
    private String name;
    private Integer age;
    private Integer sex ;

    public UserInfo() {
    }

    public UserInfo(Long id, String name, Integer age, Integer sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
