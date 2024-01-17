package com.zxm.community.system.service.impl;

import com.zxm.community.system.domain.SysUser;
import com.zxm.community.system.mapper.SysUserMapper;
import com.zxm.community.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: zxm
 * @Date: 2024/1/17 -  15:44
 * @Description: com.zxm.community.system.service.impl
 * @version: 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public SysUser selectUserByUserName(String username) {
        return sysUserMapper.selectUserByUserName(username);
    }
}
