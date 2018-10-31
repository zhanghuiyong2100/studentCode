package spring.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 章辉勇
 * @创建时间 2018年10月30日
 * @描述: 條件注解實現
 **/

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService bean = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name") + "系統下的命令為：" + bean.showListCmd());
    }
}
