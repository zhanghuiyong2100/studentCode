package com.springmvc4.controller;

import com.springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 章辉勇
 * @创建时间 2018年11月03日
 * @描述: 异常处理演示控制器
 **/
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSometing(@ModelAttribute("msg") String msg, DemoObj obj) {
        throw new IllegalArgumentException("有点小误会哦," + "来自@ModelAttribute:" + msg);
    }
}
