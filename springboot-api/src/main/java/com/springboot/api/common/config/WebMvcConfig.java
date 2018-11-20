package com.springboot.api.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 章辉勇
 * @创建时间 2018年11月19日
 * @描述: SpringMvc配置信息
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /**
         * 注册访问/login 转向login.html页面。
         * */
        //registry.addViewController("/login").setViewName("login");
    }
}
