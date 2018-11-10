package com.springboot.api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author 章辉勇
 * @创建时间 2018年11月08日
 * @描述: 日志注解實現
 **/

/**
 * ①通过@Aspect注解声明该类是一个切面。
 */
@Aspect
/**
 * ②通过@Component让此切面成为Spring容器管理的Bean。
 * */
@Component
public class LogAspect {


    @Pointcut("@annotation(com.springboot.api.aspect.Action)")
    public void log(){

    }

    /**
     *  前置通知
     * */
    @Before("log()")
    public void doBeforeController(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("action名称 " + action.value()); // ⑤
    }

    /**
     * 后置通知
     */
    @AfterReturning(pointcut = "log()", returning = "retValue")
    public void doAfterController(JoinPoint joinPoint, Object retValue) {
        System.out.println("retValue is:" + retValue);
    }

}
