package com.springboot.api.aspect;

import java.lang.annotation.*;

/**
 * @author 章辉勇
 * @创建时间 2018年11月08日
 * @描述: 日志攔截規制的注解
 **/

/**
 * @Target：定义注解的作用目标 TYPE             //接口、类、枚举、注解
 * FIELD            //字段、枚举的常量
 * METHOD           //方法
 * PARAMETER        //方法参数
 * CONSTRUCTOR      //构造函数
 * LOCAL_VARIABLE   //局部变量
 * ANNOTATION_TYPE  //注解
 * PACKAGE          //包
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})

/**
 * @Retention: 定义注解的保留策略
 * @Retention(RetentionPolicy.SOURCE)   //注解仅存在于源码中，在class字节码文件中不包含
 * @Retention(RetentionPolicy.CLASS)     // 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得，
 * @Retention(RetentionPolicy.RUNTIME)  // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
 * */
@Retention(RetentionPolicy.RUNTIME)
/**
 * @Document：说明该注解将被包含在javadoc中
 * */
@Documented
public @interface Action {
    String value() default "";

}
