package com.feiyu.config;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 章辉勇
 * @创建时间 2018年10月25日
 * @描述: main
 **/

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        UseFunctionService useFunctionService = null;
        try {
            useFunctionService = context.getBean(UseFunctionService.class);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        System.out.println(useFunctionService.SayHello("  Java config"));
        context.close();
    }
}
