package com.springmvc4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/**
 *① 利用@Controller注解声明是一个控制器。
 * */
public class HelloController {
    @RequestMapping("/index")
    public String hello() {
        System.out.println("进入");
        /** 通过上面ViewResolver的Bean配置，返回值为index，说明我们的页面放置的路径为/WEB-INF/classes/views/。 */
        return "index";
    }
}
