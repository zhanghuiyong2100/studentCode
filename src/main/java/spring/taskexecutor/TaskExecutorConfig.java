package spring.taskexecutor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;


/**
 * @author 章辉勇
 * @创建时间 2018年10月27日
 * @描述: 多綫程測試配置文件
 **/
@Configuration
@ComponentScan("spring.taskexecutor")
/**    利用@EnableAsync注解开启异步任务支持 */
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {
    //配置类实现AsyncConfigurer接口并重写getAsyncExcutor方法，并返回一个ThreadPoolTaskExevutor
    //这样我们就获得了一个基于线程池的TaskExecutor

    public Executor getAsyncExcutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //线程池维护线程的最少数量
        taskExecutor.setCorePoolSize(5);
        //线程池维护线程的最大数量
        taskExecutor.setMaxPoolSize(10);
        //线程池所使用的缓冲队列
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;

    }

}
