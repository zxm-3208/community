package com.zxm.community.system.service;

import com.zxm.community.system.domain.SysMenu;
import com.zxm.community.system.domain.vo.RouterVo;

import java.util.List;
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

    /**
     * @description: 根据用户ID查询菜单信息
     * @param userId
     * @return: List<SysMenu>
     * @throws:
     * @author: zxm
     * @time: 2024/1/21 20:01
    */
    public List<SysMenu> selectMenutreeByUserId(Long userId);

    /**
     * @description: 构建前端路由需要的菜单
     * @param menus
     * @return: List<RouterVo>
     * @throws: 
     * @author: zxm
     * @time: 2024/1/21 20:35
    */
    List<RouterVo> buildMenus(List<SysMenu> menus);
}
