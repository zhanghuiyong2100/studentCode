package spring.application.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 章辉勇
 * @创建时间 2018年10月27日
 * @描述: 事件执行类
 **/

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher bean = context.getBean(DemoPublisher.class);
        bean.publish("发布事件消息");
        context.close();
    }
}
