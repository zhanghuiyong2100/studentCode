package controller;

import com.feiyu.config.TestConfig;
import com.feiyu.entity.bean.TestBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 章辉勇
 * @创建时间 2018年10月30日
 * @描述: 測試工具測試類
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("prod")
public class DemoBeanIntegrationTests {
    @Autowired
    private TestBean testBean;

    @Test
    public void prodBeanShouldInject(){
        String expeted="from production profile";
        String actual=testBean.getContent();
        Assert.assertEquals(expeted,actual);

    }

}
