package spring.springEl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 章辉勇
 * @创建时间 2018年10月26日
 * @描述: springEl测试
 **/

public class ElMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Elconfig.class);
        Elconfig bean = applicationContext.getBean(Elconfig.class);
        bean.outputResource();
        applicationContext.close();

    }
}
