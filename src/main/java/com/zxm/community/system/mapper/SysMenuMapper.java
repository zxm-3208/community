package com.zxm.community.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxm.community.system.domain.SysMenu;

import java.util.List;

/**
 * @Auther: zxm
 * @Date: 2024/1/20 -  15:52
 * @Description: 菜单表 数据层
 * @version: 1.0
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * @description: 根据用户ID，查询菜单权限
     * @param userId
     * @return: List<String> 权限列表
     * @throws:
     * @author: zxm
     * @time: 2024/1/20 15:53
    */
    List<String> selectRolePermissionByUserId(Long userId);

    /**
     * @description: 根据用户id 查询菜单信息
     * @param userId
     * @return: List<SysMenu>
     * @throws: 
     * @author: zxm
     * @time: 2024/1/21 20:05
    */
    List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * @description: 用户为admin，查询全部的菜单信息
     * @param 
     * @return: List<SysMenu>
     * @throws: 
     * @author: zxm
     * @time: 2024/1/21 17:03
    */
    List<SysMenu> selectMenuTreeAll();

}
