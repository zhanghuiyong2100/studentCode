package spring.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author 章辉勇
 * @创建时间 2018年10月30日
 * @描述: spring條件判斷配置文件
 **/
@Configuration
public class ConditionConfig {
    @Bean
    /**
     * ①通过@Conditional注解，符合Windows条件则实例化windowsListService。
     * */
    @Conditional(WindowsCondition.class)
    public ListService windowsListService() {
        return new WindowsListService();
    }


    @Bean
    /**
     * ②通过@Conditional注解，符合Linux条件则实例化linuxListService。
     * */
    @Conditional(LinuxCondition.class)
    public ListService linuxListService() {
        return new LinuxListService();
    }
}
