package com.zxm.community.framework.security.service;

import com.zxm.community.common.utils.ServletUtils;
import com.zxm.community.system.domain.LoginUser;
import com.zxm.community.system.domain.SysRole;
import com.zxm.community.system.service.TokenService;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

/**
 * @Auther: zxm
 * @Date: 2024/1/21 -  21:04
 * @Description: 自定义权限校验规则
 * @version: 1.0
 */
@Component("pe")
public class PermsExpressionService {

    private static final String ALL_PERMISSION = "*:*:*";

    @Autowired
    private TokenService tokenService;

    /**
     * @description: 1) 验证用户是否具备某一个权限
     * @param permission
     * @return: boolean
     * @throws:
     * @author: zxm
     * @time: 2024/1/21 21:05
    */
    public boolean hasPerms(String permission){
        if(StringUtils.isEmpty(permission)){
            return false;
        }
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        if(Objects.isNull(loginUser) || CollectionUtils.isEmpty(loginUser.getPermission())){
            return false;
        }
        return hasPermissions(loginUser.getPermission(), permission);
    }

    /**
     * @description: 判断是否包含权限
     * @param permission
     * @param permission1
     * @return: boolean
     * @throws:
     * @author: zxm
     * @time: 2024/1/21 21:09
    */
    private boolean hasPermissions(Set<String> permission, String permission1) {
        return permission.contains(permission1) || permission.contains(ALL_PERMISSION);
    }
    
    /**
     * @description: 判断用户是否具有任意一个权限
     * @param permissions
     * @return: boolean
     * @throws:
     * @author: zxm
     * @time: 2024/1/21 21:14
    */
    public boolean hasAnyPerms(String permissions){
        if(StringUtils.isEmpty(permissions)){
            return false;
        }
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        if(Objects.isNull(loginUser) || CollectionUtils.isEmpty(loginUser.getPermission())){
            return false;
        }
        Set<String> authorities = loginUser.getPermission();
        for (String perms : permissions.split(",")){
            if(perms != null && hasPermissions(authorities, perms)){
                return true;
            }
        }
        return false;
    }

    /**
     * @description: 判断用户是否拥有某个角色
     * @param role
     * @return: boolean
     * @throws:
     * @author: zxm
     * @time: 2024/1/21 21:18
    */
    public boolean hasRole(String role){
        if(StringUtils.isEmpty(role)){
            return false;
        }
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        if(Objects.isNull(loginUser) || CollectionUtils.isEmpty(loginUser.getUser().getRoles())){
            return false;
        }
        for (SysRole sysRole:loginUser.getUser().getRoles()){
            String roleKey = sysRole.getRoleKey();
            if("admin".equals(roleKey) || roleKey.equals(role)){
                return true;
            }
        }
        return false;
    }

    /**
     * @description: 判断用户是否拥有以下任意一个角色
     * @param roles
     * @return: boolean
     * @throws:
     * @author: zxm
     * @time: 2024/1/21 21:18
     */
    public boolean hasAnyRole(String roles){
        if(StringUtils.isEmpty(roles)){
            return false;
        }
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        if(Objects.isNull(loginUser) || CollectionUtils.isEmpty(loginUser.getUser().getRoles())){
            return false;
        }
        for (String role:roles.split(",")){
            if(hasRole(role)){
                return true;
            }
        }
        return false;
    }

}
