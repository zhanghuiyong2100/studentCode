package spring.application.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author 章辉勇
 * @创建时间 2018年10月26日
 * @描述: spring事件测试
 **/

public class DemoEvent extends ApplicationEvent {

    private static final long seriaVersionID = 1L;

    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
