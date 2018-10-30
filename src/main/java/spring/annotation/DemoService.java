package spring.annotation;

import org.springframework.stereotype.Service;

/**
 * @author 章辉勇
 * @创建时间 2018年10月30日
 * @描述: 組合注解演示服務bean
 **/
@Service
public class DemoService {
    public void outpouResult() {
        System.out.println("從組合注解配置中獲得的bena");
    }

}
