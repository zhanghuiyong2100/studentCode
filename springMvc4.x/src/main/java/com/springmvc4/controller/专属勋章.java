package com.springmvc4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 章辉勇
 * @创建时间 2018年11月03日
 * @描述: 专属勋章
 **/

@Controller
public class 专属勋章 {
//    @RequestMapping("/专属勋章")
//    public String 专属勋章() {
//        /** 通过上面ViewResolver的Bean配置，返回值为index，说明我们的页面放置的路径为/WEB-INF/classes/views/。 */
//        return "专属勋章";
//    }

    @RequestMapping("/专属勋章")
    public String 专属勋章() {
        /** 通过上面ViewResolver的Bean配置，返回值为index，说明我们的页面放置的路径为/WEB-INF/classes/views/。 */
        return "zhong";
    }
}
