package spring.annotation;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
/** ①组合@Configuration元注解。*/
@Configuration
/** ②组合@ComponentScan元注解。*/
@ComponentScan
public @interface WiselyConfiguration {
    /**
     * ③覆盖value参数。
     */
    String[] value() default {};
}



