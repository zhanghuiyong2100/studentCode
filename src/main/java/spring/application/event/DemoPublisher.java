package spring.application.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author 章辉勇
 * @创建时间 2018年10月27日
 * @描述: 事件发布类
 **/
@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext applicationContext;


    public void publish(String msg) {
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }
}
