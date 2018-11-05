package com.springmvc4.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 章辉勇
 * @创建时间 2018年11月05日
 * @描述: servlet3.0异步消息
 **/
@Service
public class PushService {

    /**
     * ① 在PushService里产生DeferredResult给控制器使用，通过@Scheduled注解的方法定时更新DeferredResult
     */
    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsyncUpdate() {
        deferredResult = new DeferredResult<>();
        return deferredResult;
    }

    @Scheduled(fixedDelay = 5000)
    public void refresh() {
        if (null != deferredResult) {
            deferredResult.setResult(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date()));
        }
    }



}
