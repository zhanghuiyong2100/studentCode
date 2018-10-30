package com.feiyu.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 章辉勇
 * @创建时间 2018年10月25日
 * @描述: javaconfig
 **/

@Configuration
@ComponentScan(basePackages = "com.feiyu.config")
public class JavaConfig {

    @Bean
    public FunctionService functionService() {
        return new FunctionService();
    }


    @Bean
    public UseFunctionService useFunctionService(FunctionService functionService) {
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService);
        return useFunctionService;
    }
}
