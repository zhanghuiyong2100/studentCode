package spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 章辉勇
 * @创建时间 2018年10月30日
 * @描述: 懶得寫了，一目瞭然
 **/

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService bean = context.getBean(DemoService.class);
        bean.outpouResult();
        context.close();

    }
}
