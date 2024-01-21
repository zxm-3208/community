package com.zxm.community.system.service.impl;

import com.zxm.community.common.constant.UserConstants;
import com.zxm.community.system.domain.SysMenu;
import com.zxm.community.system.domain.vo.MetaVo;
import com.zxm.community.system.domain.vo.RouterVo;
import com.zxm.community.system.mapper.SysMenuMapper;
import com.zxm.community.system.service.SysMenuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Auther: zxm
 * @Date: 2024/1/20 -  16:01
 * @Description: com.zxm.community.system.service.impl
 * @version: 1.0
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public Set<String> selectMenuPermissionByUserId(Long userId) {

        List<String> list = sysMenuMapper.selectRolePermissionByUserId(userId);
        HashSet<String> permsSet = new HashSet<>();

        for (String perms : list){
            if (!StringUtils.isEmpty(perms)) {
                permsSet.add(perms);
            }
        }

        return permsSet;
    }

    @Override
    public List<SysMenu> selectMenutreeByUserId(Long userId) {

        List<SysMenu> menus = null;
        if(userId != null && 1L == userId){
            menus = sysMenuMapper.selectMenuTreeAll();
        }else{
            menus = sysMenuMapper.selectMenuTreeByUserId(userId);
        }

        return getChildPerms(menus, 0);
    }

    @Override
    public List<RouterVo> buildMenus(List<SysMenu> menus) {

        ArrayList<RouterVo> routers = new ArrayList<>();

        for(SysMenu menu:menus){
            RouterVo routerVo = new RouterVo();
            routerVo.setName(getRouterName(menu));
            routerVo.setPath(getRouterPath(menu));
            routerVo.setComponent(getComponent(menu));
            routerVo.setHidden("1".equals(menu.getVisible()));
            routerVo.setMeta(new MetaVo(menu.getMenuName(),menu.getIcon(),"1".equals(menu.getIsCache())));
            List<SysMenu> subMenuList = menu.getChildren();
            if(!subMenuList.isEmpty()&&subMenuList.size()>0&&UserConstants.TYPE_DIR.equals(menu.getMenuType())){
                routerVo.setAlwaysShow(true);
                routerVo.setRedirect("noRedirect");
                routerVo.setChildren(buildMenus(subMenuList));  // 递归设置子菜单
            }
            routers.add(routerVo);
        }
        return routers;
    }

    /**
     * @description: 获取组件信息
     * @param menu
     * @return: String
     * @throws:
     * @author: zxm
     * @time: 2024/1/21 20:44
    */
    private String getComponent(SysMenu menu) {
        String component = UserConstants.LAYOUT;
        // 如果是子菜单
        if(!StringUtils.isEmpty(menu.getComponent())){
            component = menu.getComponent();
        }
        // 如果不是父菜单，且菜单类型是目录
        else if(menu.getParentId().intValue()!=0&&UserConstants.TYPE_DIR.equals(menu.getMenuType())){
            component = UserConstants.PARENT_VIEW;
        }
        return component;
    }

    /**
     * @description: 获取路由地址
     * @param menu
     * @return: String
     * @throws:
     * @author: zxm
     * @time: 2024/1/21 20:40
    */
    private String getRouterPath(SysMenu menu) {
        String path = menu.getPath();
        if(menu.getParentId().intValue() == 0&& UserConstants.TYPE_DIR.equals(menu.getMenuType())){
            path = "/"+menu.getPath();
        }
        return path;
    }

    /**
     * @description: 获取路由名称
     * @param menu
     * @return: String
     * @throws:
     * @author: zxm
     * @time: 2024/1/21 20:38
    */
    private String getRouterName(SysMenu menu) {
        String routerPath = menu.getPath();
        String routerName = StringUtils.capitalize(routerPath);
        return routerName;
    }

    /**
     * @description: 根据父节点ID获取子节点
     * @param menus 菜单列表
     * @param parentId 父菜单ID
     * @return: List<SysMenu> 有父子结构地菜单集合
     * @throws: 
     * @author: zxm
     * @time: 2024/1/21 20:06
    */
    private List<SysMenu> getChildPerms(List<SysMenu> menus, int parentId) {
        List<SysMenu> returnList = new ArrayList<>();
        menus.stream().
                filter(m->m.getParentId() == parentId)
                .forEach(m->{
                    recursionFn(menus, m);
                    returnList.add(m);
                });
        return returnList;
    }

    /**
     * @description: 递归获取菜单
     * @param menus
     * @param m
     * @return: void
     * @throws:
     * @author: zxm
     * @time: 2024/1/21 20:09
    */
    private void recursionFn(List<SysMenu> menus, SysMenu m) {
        /**
         * 1. 获取子节点列表
         */
        List<SysMenu> childMenu = getChildList(menus, m);
        m.setChildren(childMenu);
        for(SysMenu subMenu:childMenu){
            /**
             * 判断子节点下面还有子节点
             */
            if(getChildList(menus, subMenu).size()>0?true:false){
                recursionFn(menus, subMenu);
            }
        }
    }


    /**
     * @description: 得到子节点列表
     * @param menus
     * @param m
     * @return: List<SysMenu>
     * @throws:
     * @author: zxm
     * @time: 2024/1/21 20:10
    */
    private List<SysMenu> getChildList(List<SysMenu> menus, SysMenu m) {
        return menus.stream()
                .filter(sub -> sub.getParentId().longValue() == m.getMenuId().longValue())
                .collect(Collectors.toList());
    }
}
