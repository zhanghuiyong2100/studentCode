package com.springmvc4.controller;

import com.springmvc4.domain.DemoObj;
import com.springmvc4.service.DemoService;
import com.springmvc4.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.ui.Model;

import java.util.Random;

/**
 * @author 章辉勇
 * @创建时间 2018年11月05日
 * @描述: springMVC4X測試控制器
 **/
@Controller
public class SpringMVC4XTestController {


    /**
     * ① 定时任务，定时更新DeferredResult。
     */
    @Autowired
    private PushService pushService;

    @Autowired
    DemoService demoService;


    /**
     * HttpMessageConverter控制器
     */
    @RequestMapping(value = "/convert", produces = {"application/x-longjiazuo"})
    public @ResponseBody
    DemoObj convert(@RequestBody DemoObj demoObj) {
        return demoObj;
    }


    /**
     * <p>
     * SSE(Server Send Event 服务端发送事件)的服务器端推送
     * <p>
     * ① 注意，这里使用输出的媒体类型为text/event-stream，这是服务器端SSE的支持，本例演示每5秒向浏览器推送随机消息。
     */
    @RequestMapping(value = "/push", produces = "text/event-stream")
    public @ResponseBody
    String push() {
        Random random = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "data:Testing 1,2,3" + random.nextInt() + "\n\n";
    }

    /**
     * <p>
     * 服务器端推送技术，基于Servlet3.0+异步方法处理
     * <p>
     * ② 返回给客户端DeferredResult。
     */
    @RequestMapping(value = "/defer", produces = "text/event-stream")
    @ResponseBody
    public DeferredResult<String> servletPush() {
        return pushService.getAsyncUpdate();
    }


    @RequestMapping("/normal")
    public String testPage(Model model) {
        model.addAttribute("msg", demoService.saySomething());
        return "page";
    }

    @RequestMapping(value = "/testRest", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String testRest() {
        return demoService.saySomething();
    }

}
