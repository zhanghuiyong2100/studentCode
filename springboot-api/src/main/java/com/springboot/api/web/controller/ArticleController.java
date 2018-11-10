package com.springboot.api.web.controller;

import com.springboot.api.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ArticleController {

    @Autowired
    private User user;

    @RequestMapping("/articleList")
    public String getArticleList(Model model) {
        List<User> list = new ArrayList<>();
        System.out.println(user);
        list.add(user);
        list.add(user);
        model.addAttribute("list", list);
        return "articleList";
    }
}