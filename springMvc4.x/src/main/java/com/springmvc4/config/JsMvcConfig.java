package com.springmvc4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author 章辉勇
 * @创建时间 2018年10月31日
 * @描述: 静态资源的配置java
 **/

@Configuration
/** ① @EnableWebMvc开启SpringMvc支持，若无此句，重写WebMvcConfigurerAdapter的方法无效。 */
@EnableWebMvc
@ComponentScan("com.springmvc4")
/** ② 继承WebMvcConfigurerAdapter类，重写其方法可对Spring MVC进行配置。 */
public class JsMvcConfig extends WebMvcConfigurerAdapter {


    @Bean
    public InternalResourceViewResolver viewResolver() {
        System.out.println("开始装置");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/classes/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("查看是否会执行");
        /** ③ addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径。*/
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

}
