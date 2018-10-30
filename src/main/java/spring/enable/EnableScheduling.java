package spring.enable;

import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.SchedulingConfiguration;

import java.lang.annotation.*;

/**
 * @author 章辉勇
 * @创建时间 2018年10月30日
 * @描述: Enable注解直接導入配置類
 **/


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
/**
 * 直接导入配置类SchedulingConfiguration，这个类注解了@Configuration，
 * 且注册了一个scheduledAnnotationProcessor的Bean，
 * */
@Import(SchedulingConfiguration.class)
@Documented
public @interface EnableScheduling {
}
