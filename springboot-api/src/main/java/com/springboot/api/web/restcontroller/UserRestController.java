package com.springboot.api.web.restcontroller;

import com.springboot.api.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 章辉勇
 * @创建时间 2018年11月06日
 * @描述:
 **/

@RestController
/**  激活绑定的bean */
@EnableConfigurationProperties(User.class)
public class UserRestController {
    @Value("${article.author}")
    private String articleAuthor;
    @Value("${article.name}")
    private String articleName;


    @Autowired
    private User user;

    @RequestMapping("/userHello")
    public String userHello() {
        return "article name is:" + articleName + " and article author is:" + articleAuthor;
    }


    public static void main(String[] args) {

    }
}
