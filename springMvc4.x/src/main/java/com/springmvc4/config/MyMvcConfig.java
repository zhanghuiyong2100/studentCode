package com.springmvc4.config;

import com.springmvc4.converter.MyMessageConverter;
import com.springmvc4.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;


@Configuration
/**
 * @EnableWebMvc注解会开启一些默认配置，如一些ViewResolver或者MessageConverter等。
 * */
@EnableWebMvc
/**
 * @EnableScheduling开启计划任务的支持
 * */
@EnableScheduling
@ComponentScan("com.springmvc4")
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
     * ① 配置拦截器的Bean
     */
    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }


    /**
     * ② 重写addInterceptors方法，注册拦截器。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    /**
     * 重写addViewControllers,无需逻辑的页面跳转可以更简便
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //第一个参数为前端传进来的地址，后一个为跳转的页面
        registry.addViewController("/index/error").setViewName("/专属勋章");
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/error").setViewName("/error");
        registry.addViewController("/zhong").setViewName("/专属勋章");
        //文件上传页面
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/conventer");
        registry.addViewController("/sse").setViewName("/sse");
        registry.addViewController("/async").setViewName("/async");
    }

    /**
     * 不忽略 . 后面的参数
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    /**
     * 添加对文件上传的支持
     */
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1024 * 1024 * 1024);
        return multipartResolver;
    }

    /**
     * 配置自定义的HttpMessageConverter的Bean
     * 在文件MyMvcConfig中配置extendMessageConverters：仅添加一个自定义的HttpMessageConverter，不覆盖默认注册的HttpMessageConverter。
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    @Bean
    public HttpMessageConverter<?> converter() {
        return new MyMessageConverter();
    }
}