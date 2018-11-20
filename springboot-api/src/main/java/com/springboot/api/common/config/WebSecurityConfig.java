package com.springboot.api.common.config;

import com.springboot.api.service.impl.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author 章辉勇
 * @创建时间 2018年11月19日
 * @描述: Spring Security配置
 **/

@Configuration
/**
 * ①扩展Spring Security配置需继承WebSecurityConfigurerAdapter。
 * */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    /**
     * ②注册CustomUserService的Bean。
     * */
    UserDetailsService customUserService() {
        System.out.println("装载CustomUserService");
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * ③添加我们自定义的user detail service认证。
         * */
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /**
                 * ④所有请求需要认证即登录后才能访问。
                 * */
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureForwardUrl("/login?error")
                /**
                 * ⑤定制登录行为，登录页面可任意访问。
                 * */
                .permitAll()
                .and()
                /**
                 * ⑥定制注销行为，注销请求可任意访问。
                 * */
                .logout().permitAll();
    }
}
