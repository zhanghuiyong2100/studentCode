package com.springboot.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootApiApplication {

    @RequestMapping("/")
    public String index() {
        return "This is SpringBoot-API";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApiApplication.class, args);
    }
}
