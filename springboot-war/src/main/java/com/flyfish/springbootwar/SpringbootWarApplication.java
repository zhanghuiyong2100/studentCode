package com.flyfish.springbootwar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootWarApplication extends SpringBootServletInitializer {

    @RequestMapping("/")
    public String index() {
        return "springboot  War包界面";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWarApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootWarApplication.class);
    }
}
