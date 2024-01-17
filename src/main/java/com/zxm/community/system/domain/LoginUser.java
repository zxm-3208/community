package com.zxm.community.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Auther: zxm
 * @Date: 2024/1/17 -  16:08
 * @Description: 登录用户，身份权限对象
 * @version: 1.0
 */
public class LoginUser implements UserDetails {

    /**
     * @description: 当前用户的唯一标识
     * @param null
     * @return: null
     * @throws:
     * @author: zxm
     * @time: 2024/1/17 16:32
    */
    private String token;

    private SysUser user;

    public LoginUser(SysUser user) {
        this.user = user;
    }

    public LoginUser() {
    }

    /**
     * @description: 获取用户被授予的权限
     * @param
     * @return: Collection<GrantedAuthority>
     * @throws: 
     * @author: zxm
     * @time: 2024/1/17 16:35
    */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
