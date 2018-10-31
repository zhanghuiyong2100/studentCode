package com.feiyu.controller;

import com.alibaba.fastjson.JSONObject;
import com.feiyu.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 章辉勇
 * @创建时间 2018年10月30日
 * @描述: springMVC實驗控制器接口
 **/
/**
 * ①@Controller 注解声明此类是一个控制器。
 *
 * */
@Controller
/**
 * ②@RequestMapping（“/anno”）映射此类的访问路径是/anno。
 *
 * */
@RequestMapping("/anno")
public class DemoAnnoController {

    /**
     * ③此方法未标注路径，因此使用类级别的路径/anno；produces可定制返回的response的
     * 媒体类型和字符集，或需返回值是json对象，则设置produces=“application/json；charset=UTF-8”，在后面的章节我们会演示此项特性。
     *
     * */
    @RequestMapping(produces = "text/plain;charset=UTF-8")


    /**
     * ④演示可接受HttpServletRequest作为参数，当然也可以接受HttpServletReponse作为参数。
     * 此处的@ReponseBody用在返回值前面。
     * */
    public @ResponseBody
    String index(HttpServletRequest request) {
        return "url:" + request.getRequestURI() + "can access";
    }

    /**
     * ⑤演示接受路径参数，并在方法参数前结合@PathVariable使用，访问路径为/anno/pathvar/xx。
     * */
    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String demoPathVar(@PathVariable String str, HttpServletRequest request) {
        return "url:" + request.getRequestURI() + "can access,str:" + str;
    }

    /**
     *   ⑥演示常规的request参数获取，访问路径为/anno/requestParam？id=l。
     * */
    @RequestMapping(value = "/requesyParm", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String passRequestParm(Long id, HttpServletRequest request) {
        return "url:" + request.getRequestURI() + "can access,id:" + id;
    }


    /**
     * ⑦演示解释参数到对象，访问路径为/anno/obj？id=1&name=xx。
     * */
    @RequestMapping(value = "/obj", produces = "text/plain;charset=UTF-8")
    /**
     * 8 @ReponseBody也可以用在方法上。
     * */
    @ResponseBody
    public String passObj(DemoObj demoObj, HttpServletRequest request) {
        return "url:" + request.getRequestURI() + "can access,obj" + JSONObject.toJSONString(demoObj);
    }
    /**
     * 9 演示映射不同的路径到相同的方法，访问路径为/anno/namel或/anno/name2。
     * */
    @RequestMapping(value = {"/name1","/name2"}, produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String remove(HttpServletRequest request) {
        return "url:" + request.getRequestURI() + "can access";
    }


}
