package spring.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 章辉勇
 * @创建时间 2018年10月29日
 * @描述: spring计划任务
 **/
@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * ①通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间执行。
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("每五秒执行一次" + dateFormat.format(new Date()));
    }

    /**
     * ②使用cron属性可按照指定时间执行，本例指的是每天每小时28分执行；cron是UNIX和类UNIX（Linux）系统下的定时任务。
     */
    @Scheduled(cron = "0 11 * ? * *")
    public void fixTimeExecution() {
        System.out.println("定時啓動：" + dateFormat.format(new Date()));
    }


}
