package com.springboot.api.domain.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 章辉勇
 * @创建时间 2018年11月16日
 * @描述: 安全策略定义用户
 **/
@Entity
/**
 * ①让我们的用户实体实现UserDetails接口，我们的用户实体即为Spring Security所使用的用户。
 * */
public class SysUser implements UserDetails {

    private static final long serialVersionUID = 1L;
    //②@ld注解指明这个属性映射为数据库的主键。
    @Id
    //③@GeneratedValue 注解默认使用主键生成方式为自增，hibernate会为我们自动生成一个名为HIBERNATE_SEQUENCE的序列。
    @GeneratedValue
    /**
     * id
     * */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * <p>②配置用户和角色的多对多关系。</p>
     * 角色
     */
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<SysRole> roles;


    /**
     * ③重写getAuthorities方法，将用户的角色作为权限。
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<SysRole> roleList = this.getRoles();
        for (SysRole role : roleList) {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
