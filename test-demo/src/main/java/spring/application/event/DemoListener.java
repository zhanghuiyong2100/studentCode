package spring.application.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author 章辉勇
 * @创建时间 2018年10月27日
 * @描述: 事件监听器
 **/

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {


    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("我（bean-demoListener）接受到了bean-demoPublisher发布的消息：" + msg);
    }
}
