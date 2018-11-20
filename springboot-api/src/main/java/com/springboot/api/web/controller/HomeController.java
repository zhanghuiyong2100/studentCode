//package com.springboot.api.web.controller;
//
//import com.springboot.api.domain.security.Msg;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * @author 章辉勇
// * @创建时间 2018年11月19日
// * @描述: 首页显示
// **/
//@Controller
//public class HomeController {
//
//    @RequestMapping("/login")
//    public String login() {
//        System.out.println("我看看");
//        return "login";
//    }
//
//
//    @RequestMapping("/home")
//    public String index(Model model) {
//        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
//        model.addAttribute(msg);
//        return "home";
//    }
//
//}
