package controller;

import com.alibaba.fastjson.JSON;
import com.feiyu.controller.UserController;
import com.feiyu.entity.UserEntiy;
import com.feiyu.service.IUserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 章辉勇
 * @创建时间 2018年10月11日
 * @描述: 用户接口测试
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mvc.xml","classpath:spring/spring-mybatis.xml"})
public class UserConTest {

    private static Logger logger = Logger.getLogger(UserController.class);
    /**
     * 用户service
     */
    @Autowired
    private IUserService userService;
    @Test
    public void queryUser() {
        UserEntiy user = null;
        Integer id=9;
        try {
            if (null != id) {
                user = userService.getUser(id);
                System.out.println("查询用户信息,返回结果," + JSON.toJSON(user));
                logger.info("查询用户信息,返回结果," + JSON.toJSON(user));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询出错," + e.getMessage());
            logger.error("dsdsegh," + e.getMessage());
        }

    }

}
