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

}
