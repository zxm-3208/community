package com.zxm.community.system.service;

import com.zxm.community.system.domain.SysUser;
import org.springframework.stereotype.Service;

/**
 * @Auther: zxm
 * @Date: 2024/1/17 -  15:43
 * @Description: com.zxm.community.system.service
 * @version: 1.0
 */
public interface SysUserService {

    /**
     * @description: 通过用户名查询用户
     * @param username
     * @return: SysUser
     * @throws:
     * @author: zxm
     * @time: 2024/1/17 15:28
     */
    public SysUser selectUserByUserName(String username);

}
