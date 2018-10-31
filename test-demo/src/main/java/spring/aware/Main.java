package spring.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 章辉勇
 * @创建时间 2018年10月27日
 * @描述: aware执行类
 **/

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService bean = context.getBean(AwareService.class);
        bean.outputResult();
        context.close();
    }
}
