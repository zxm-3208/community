package com.zxm.community.system.service;

import java.util.Set;

/**
 * @Auther: zxm
 * @Date: 2024/1/20 -  16:00
 * @Description: 菜单业务层
 * @version: 1.0
 */
public interface SysMenuService {

    /*
     * @description: 根据用户ID 查询菜单信息
     * @param null
     * @return: null
     * @throws:
     * @author: zxm
     * @time: 2024/1/20 16:01
    */
    Set<String> selectMenuPermissionByUserId(Long userId);
}
