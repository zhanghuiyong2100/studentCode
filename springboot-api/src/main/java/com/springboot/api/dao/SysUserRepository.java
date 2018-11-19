package com.springboot.api.dao;

import com.springboot.api.domain.security.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 章辉勇
 * @创建时间 2018年11月19日
 * @描述: 权限安全的数据访问
 **/
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);

}
