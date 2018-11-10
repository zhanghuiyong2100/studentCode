package com.springboot.api.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * @author 章辉勇
 * @创建时间 2018年11月06日
 * @描述: user類
 **/

/**
 * 标志本类为一个bean
 */
@Component
/**
 * 指定绑定哪个资源文件，【如果要绑定自定义的资源文件中的值的话，是可以用上的】
 * 这里的application.properties文件是springboot默认的资源文件，是可以不用指定的，这里绑定的话，会去加载绑定两次。
 * */
@PropertySource("classpath:properties/user.properties")
/**
 * 指定绑定资源文件中前缀以com.sxd开头的属性名，其他的不会绑定过来。因为这里location属性取消了，所以采用上面注解进行替代方案
 * */
@ConfigurationProperties(prefix = "article")
public class User {

    private String author;
    private String name;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}


