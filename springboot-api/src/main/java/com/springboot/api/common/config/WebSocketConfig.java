package com.springboot.api.common.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author 章辉勇
 * @创建时间 2018年11月09日
 * @描述: socket通讯配置类
 **/

@Configuration
public class WebSocketConfig {
    /**
     * 自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
     */

    //打成war包部署在tomcat中的话不需要这个bean
    //@Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
