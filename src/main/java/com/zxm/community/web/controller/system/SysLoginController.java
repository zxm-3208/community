package com.zxm.community.web.controller.system;

import com.zxm.community.common.core.domain.BaseResponse;
import com.zxm.community.common.utils.ChainedMap;
import com.zxm.community.common.utils.ServletUtils;
import com.zxm.community.framework.service.SysPermissionService;
import com.zxm.community.system.domain.LoginUser;
import com.zxm.community.system.domain.SysMenu;
import com.zxm.community.system.domain.SysUser;
import com.zxm.community.system.domain.vo.LoginBody;
import com.zxm.community.system.domain.vo.RouterVo;
import com.zxm.community.system.service.SysLoginService;
import com.zxm.community.system.service.SysMenuService;
import com.zxm.community.system.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @Auther: zxm
 * @Date: 2024/1/17 -  17:35
 * @Description: 登录验证
 * @version: 1.0
 */
@RestController
public class SysLoginController {

    @Autowired
    private SysLoginService loginService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * @description: 登陆方法
     * @param loginBody
     * @return: ChainedMap
     * @throws: 
     * @author: zxm
     * @time: 2024/1/17 17:36
    */
    @PostMapping("/login")
    public ChainedMap login(@RequestBody LoginBody loginBody){
        /**
         * 生成令牌
         */
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(), loginBody.getUuid());

        return ChainedMap.create().set("token", token);
    }

    /**
     * 获取用户信息及其权限信息
     */
    @GetMapping("/getInfo")
    public ChainedMap getInfo(){
        /**
         * 获取用户信息
         */
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();

        /**
         * 角色集合
         */
        Set<String> roles = sysPermissionService.getRolePermission(user);
        
        /**
         * 权限集合
         */
        Set<String> permissions = sysPermissionService.getMenuPermission(user);

        ChainedMap map = ChainedMap.create().set("code", 200).set("msg", "操作成功");
        map.put("user", user);
        map.put("roles", roles);
        map.put("permissions", permissions);

        return map;
    }

    /**
     * @description: 获取路由信息
     * @param
     * @return: BaseResponse
     * @throws: 
     * @author: zxm
     * @time: 2024/1/21 20:22
    */
    @GetMapping("/getRouters")
    public BaseResponse getRoters(){
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        // 获取菜单列表
        List<SysMenu> menus = sysMenuService.selectMenutreeByUserId(user.getUserId());
        // 将获取到的菜单列表转换为前端需要的路由列表
        List<RouterVo> routerVoList = sysMenuService.buildMenus(menus);
        return BaseResponse.success(routerVoList);
    }

}
