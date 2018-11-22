package com.springboot.api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

/**
 * @author 章辉勇
 * @创建时间 2018年11月12日
 * @描述: 用户表映射实体
 **/
//①@Entity注解指明这是一个和数据库表映射的实体类。
@Entity
//
@NamedQuery(name = "Person.withNameAndAddressNameQuery", query = "select p from Person p where p.name=?1 and address=?2")
public class Person {

    //②@ld注解指明这个属性映射为数据库的主键。
    @Id
    //③@GeneratedValue 注解默认使用主键生成方式为自增，hibernate会为我们自动生成一个名为HIBERNATE_SEQUENCE的序列。
    @GeneratedValue
    /**
     * id
     * */
    private Long id;
    /**
     * 姓名
     */
    /** ①此处使用JSR-303注解来校验数据。*/
    @Size(max = 4, min = 2)
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 地址
     */
    private String address;

    public Person() {
        super();
    }

    public Person(Long id, String name, Integer age, String address) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
