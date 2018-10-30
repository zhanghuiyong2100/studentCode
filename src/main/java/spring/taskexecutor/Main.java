package spring.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 章辉勇
 * @创建时间 2018年10月27日
 * @描述: 多线程执行类
 **/

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsycTaskService bean = applicationContext.getBean(AsycTaskService.class);
        for (int i = 0; i < 10; i++) {
            bean.executeAsycTask(i);
            bean.executeAsyncTaskPlus(i);
        }
        applicationContext.close();
    }
}
