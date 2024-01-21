package com.zxm.community.framework.service;

import com.zxm.community.system.domain.SysUser;
import com.zxm.community.system.service.SysMenuService;
import com.zxm.community.system.service.SysRoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: zxm
 * @Date: 2024/1/21 -  16:13
 * @Description: 用户权限处理
 * @version: 1.0
 */
@Component
public class SysPermissionService {

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * @description: 获取角色数据权限
     * @param user
     * @return: Set<String>
     * @throws:
     * @author: zxm
     * @time: 2024/1/21 16:14
    */
    public Set<String> getRolePermission(SysUser user){
        Set<String> roles = new HashSet<>();
        /**
         * 判断是否有管理员权限
         */
        if(user.isAdmin()){
            roles.add("admin");
        }else{
            roles = roleService.selectRolePermissionByUserId(user.getUserId());
        }
        return roles;
    }

    /**
     * @description: 获取菜单数据权限
     * @param user
     * @return: Set<String>
     * @throws:
     * @author: zxm
     * @time: 2024/1/21 16:14
     */
    public Set<String> getMenuPermission(SysUser user){
        Set<String> perms = new HashSet<>();
        /**
         * 判断是否是管理员权限，如果是，拥有所有全新啊
         */
        if(user.isAdmin()){
            perms.add("*:*:*");
        }else{
            perms = sysMenuService.selectMenuPermissionByUserId(user.getUserId());
        }
        return perms;
    }

}
