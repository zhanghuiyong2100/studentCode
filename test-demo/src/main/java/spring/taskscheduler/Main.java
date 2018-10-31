package spring.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 章辉勇
 * @创建时间 2018年10月29日
 * @描述: 计划任务执行类
 **/

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(new Date()));


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TasksChedulerConfig.class);


    }
}
