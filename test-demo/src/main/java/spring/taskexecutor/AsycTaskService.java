package spring.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 章辉勇
 * @创建时间 2018年10月27日
 * @描述: 任務執行類
 **/
@Service
public class AsycTaskService {

    //①通过@Async注解表明该方法是个异步方法，如果注解在类级别，
    // 则表明该类所有的方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor。

    @Async
    public void executeAsycTask(Integer i) {
        System.out.println("執行異步任務：" + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("執行異步任務+1:" + (i + 1));
    }
}
