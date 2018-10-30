package spring.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author 章辉勇
 * @创建时间 2018年10月30日
 * @描述: Linux判定條件
 **/

public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean b = context.getEnvironment().getProperty("os.name").contains("Linux");
        return b;
    }
}
