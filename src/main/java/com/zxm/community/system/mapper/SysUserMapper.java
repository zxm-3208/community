package com.zxm.community.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxm.community.system.domain.SysUser;

/**
 * @Auther: zxm
 * @Date: 2024/1/17 -  15:27
 * @Description: com.zxm.community.system.mapper
 * @version: 1.0
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

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
