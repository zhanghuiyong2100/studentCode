package com.feiyu.dao;

import com.feiyu.entity.UserEntiy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 章辉勇
 * @创建时间 2018年10月25日
 * @描述: java配置
 **/

public class UserDao {

    public List<UserEntiy> queryUserList() {
        List<UserEntiy> arrayList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            UserEntiy userEntiy = new UserEntiy();
            userEntiy.setName(String.valueOf(i));
        }
        return arrayList;

    }
}
