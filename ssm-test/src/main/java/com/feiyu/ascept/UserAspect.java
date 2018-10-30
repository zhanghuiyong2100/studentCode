package com.feiyu.ascept;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 章辉勇
 * @创建时间 2018年10月25日
 * @描述: 用户注解实现
 **/
@Aspect
@Component
public class UserAspect {

    @Pointcut("@annotation(com.feiyu.ascept.UserAction)")
    public void annotationPointCut(){};

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("注解拦截之前");
    }

    @Before("execution(* com.feiyu.service.impl.*(..))")
    public void before(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("方法拦截规则");
    }
}
