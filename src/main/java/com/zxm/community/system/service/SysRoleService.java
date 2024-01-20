package com.zxm.community.system.service;

import java.util.Set;

/**
 * @Auther: zxm
 * @Date: 2024/1/20 -  15:48
 * @Description: 角色业务层
 * @version: 1.0
 */
public interface SysRoleService {

    /**
     * @description: 根据用户ID查询角色信息
     * @param userId
     * @return: Set<String>
     * @throws:
     * @author: zxm
     * @time: 2024/1/20 15:49
    */
    Set<String> selectRolePermissionByUserId(Long userId);

}
