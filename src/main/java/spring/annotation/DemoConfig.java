package spring.annotation;

/**
 * @author 章辉勇
 * @创建时间 2018年10月30日
 * @描述: 使用組合注解的新的配置类
 **/


/** ①使用@WiselyConfiguration 组合注解替代@Configuration和@ComponentScan。 */
@WiselyConfiguration("spring.annotation")
public class DemoConfig {
}
