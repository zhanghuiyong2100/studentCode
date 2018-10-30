package com.feiyu.controller;

import com.alibaba.fastjson.JSON;
import com.feiyu.entity.UserEntiy;
import com.feiyu.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author 章辉勇
 * @创建时间 2018年10月11日
 * @描述: 用户接口
 **/

@Controller
@RequestMapping(value = "/user", produces = "text/html;charset=UTF-8")
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);
    /**
     * 用户service
     */
    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/queryUser", method = {RequestMethod.POST})
    @ResponseBody
    public UserEntiy queryUser(Integer id) {
        UserEntiy user = null;
        try {
            if (null != id) {
                user = userService.getUser(id);
                logger.info("查询用户信息返回结果," + JSON.toJSON(user));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询出错," + e.getMessage());
        }
        return user;
    }
}
