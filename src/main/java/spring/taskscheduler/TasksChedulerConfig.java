package spring.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 章辉勇
 * @创建时间 2018年10月29日
 * @描述: 計劃任務配置類
 **/
@Configuration
@ComponentScan("spring.taskscheduler")

/** ①通过@EnableScheduling注解开启对计划任务的支持。 */
@EnableScheduling
public class TasksChedulerConfig {
}
