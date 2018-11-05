package com.springmvc4.domain;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * @author 章辉勇
 * @创建时间 2018年10月30日
 * @描述: springMVC測試對像類
 **/

public class DemoObj {
    private Long id;
    //@Length(min = 5,max = 10)
    //@Pattern(regexp ="^[a-zA-Z]+$")
    private String name;

    public DemoObj() {
        super();
    }

    public DemoObj(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
