package spring.springEl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author 章辉勇
 * @创建时间 2018年10月26日
 * @描述: springEl测试
 **/

@Service
public class ElDemoService {

    @Value("其他类的熟悉")
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}
