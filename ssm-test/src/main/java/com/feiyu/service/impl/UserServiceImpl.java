package com.feiyu.service.impl;

import com.alibaba.fastjson.JSON;
import com.feiyu.ascept.UserAction;
import com.feiyu.dao.IUserNewDao;
import com.feiyu.entity.UserEntiy;
import com.feiyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 章辉勇
 * @创建时间 2018年10月11日
 * @描述: 用户信息实现
 **/

@Service
public class UserServiceImpl implements IUserService {

    /** 用户信息dao*/
    @Autowired
    private IUserNewDao userNewDao;

    /**
     *@描述  根据id获取用户信息
     *@参数   String id
     *@返回值  Object UserEntiy
     *@其它信息
    */
    @Override
    @UserAction(name = "用户注解使用")
    public UserEntiy getUser(Integer id) {
        try {
            if (null!=id){
                UserEntiy user = userNewDao.getUser(id);
                System.out.println("查看user,"+JSON.toJSON(user));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
