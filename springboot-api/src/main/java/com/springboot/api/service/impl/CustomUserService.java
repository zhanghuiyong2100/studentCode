package com.springboot.api.service.impl;

import com.springboot.api.dao.SysUserRepository;
import com.springboot.api.domain.security.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author 章辉勇
 * @创建时间 2018年11月19日
 * @描述: 自定义UserDetaileService
 **/

/**
 * ①自定义需实现UserDetailsService接口。
 */
public class CustomUserService implements UserDetailsService {

    @Autowired
    SysUserRepository sysUserRepository;


    /**
     * ②重写loadUserByUsername方法获得用户。
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser sysUser = sysUserRepository.findByUsername(username);
        if (null == sysUser) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        /**
         *  ③我们当前的用户实现了UserDetails接口，可直接返回给Spring Security使用。
         * */
        return sysUser;
    }
}
