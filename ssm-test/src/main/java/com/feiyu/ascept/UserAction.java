package com.feiyu.ascept;


import java.lang.annotation.Documented;

/**
 * @author 章辉勇
 * @创建时间 2018年10月25日
 * @描述: 用户注解
 **/
@Documented
public @interface UserAction {
    String name();
}
