//package com.springboot.api.domain.security;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
///**
// * @author 章辉勇
// * @创建时间 2018年11月16日
// * @描述:
// **/
//@Entity
//public class SysRole {
//    //②@ld注解指明这个属性映射为数据库的主键。
//    @Id
//    //③@GeneratedValue 注解默认使用主键生成方式为自增，hibernate会为我们自动生成一个名为HIBERNATE_SEQUENCE的序列。
//    @GeneratedValue
//    /**
//     * id
//     * */
//    private Long id;
//    /**
//     * 角色名称
//     */
//    private String name;
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
