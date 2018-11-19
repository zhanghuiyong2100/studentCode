package com.springboot.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
/** 开启缓存*/
@EnableCaching
public class SpringbootApiApplication extends SpringBootServletInitializer {

    @RequestMapping("/index")
    public String index() {
        return "This is SpringBoot-API";
    }

    public static void main(String[] args) {
        /**
         *  關閉banner界面
         * */
        /*
        SpringApplication application = new SpringApplication(SpringbootApiApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        */
        SpringApplication.run(SpringbootApiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(SpringbootApiApplication.class);
    }




}
