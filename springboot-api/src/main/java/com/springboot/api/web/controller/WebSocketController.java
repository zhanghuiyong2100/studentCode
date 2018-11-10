package com.springboot.api.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 章辉勇
 * @创建时间 2018年11月09日
 * @描述: 测试通信
 **/

@Controller
public class WebSocketController {
    @RequestMapping("/webSocket")
    public String intoWebSocket(){
        return "webSocket";
    }
}
