package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootApplication {


    @RequestMapping("/")
    public String index(){
        return "Hello SpringBoot";
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
