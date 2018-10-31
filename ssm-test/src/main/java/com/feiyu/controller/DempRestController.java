package com.feiyu.controller;

import com.feiyu.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 章辉勇
 * @创建时间 2018年10月30日
 * @描述: ResController演示
 **/

/**
 * ①使用@RestController，声明是控制器，并且返回数据时不需要@ResponseBody。
 * 无法返回jsp和html页面
 */
@RestController
@RequestMapping("/rest")
public class DempRestController {


    /**
     * ②返回数据的媒体类型为json。
     */
    @RequestMapping(value = "/getjson", produces = {"application/json;charset=UTF-8"})
    public DemoObj getJson(DemoObj obj) {
        /**
         * ③直接返回对象，对象会自动转换成json。
         * */
        return new DemoObj(obj.getId() + 1, obj.getName() + "YY");
    }

    /**
     * ④返回数据的媒体类型为xml。
     */
    @RequestMapping(value = "/getxml", produces = {"application/xml;charset=UTF-8"})
    private DemoObj getXml(DemoObj obj) {
        /**
         * ⑤直接返回对象，对象会自动转换为xml。
         * */
        return new DemoObj(obj.getId() + 10, obj.getName() + "XX");
    }

}
