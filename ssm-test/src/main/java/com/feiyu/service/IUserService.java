package com.feiyu.service;

import com.feiyu.entity.UserEntiy;

/**
 * @author 章辉勇
 * @创建时间 2018年10月09日
 * @描述: 用户信息service
 **/

public interface IUserService {

    /**
     *@描述  获取用户信息
     *@参数  String  id
     *@返回值 user user
     *@其它信息
     */
    public UserEntiy getUser(Integer id);
}
