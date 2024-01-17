package com.zxm.community.system.service.impl;

import com.zxm.community.common.core.exception.BaseException;
import com.zxm.community.common.enums.UserStatus;
import com.zxm.community.system.domain.LoginUser;
import com.zxm.community.system.domain.SysUser;
import com.zxm.community.system.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Objects;

/**
 * @Auther: zxm
 * @Date: 2024/1/17 -  15:47
 * @Description: 用户验证处理
 * @version: 1.0
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = sysUserService.selectUserByUserName(username);

        if(Objects.isNull(user)){
            log.info("登录用户:{} 不存在", username);
            throw new UsernameNotFoundException("登录用户: "+ username + " 不存在");
        }
        else if(UserStatus.DELETED.getCode().equals(user.getDelFlag())){
            log.info("登录用户:{} 已被删除", username);
            throw new BaseException("对不起，您的账号: " + username + "已被删除");
        }
        else if(UserStatus.DISABLE.getCode().equals(user.getStatus())){
            log.info("登录用户:{} 已被停用", username);
            throw new BaseException("对不起，您的账号: " + username + "已被停用");
        }

        return new LoginUser(user);
    }
}
