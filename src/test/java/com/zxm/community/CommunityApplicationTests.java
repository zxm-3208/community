package com.zxm.community;

import com.zxm.community.system.domain.SysMenu;
import com.zxm.community.system.domain.SysUser;
import com.zxm.community.system.mapper.SysMenuMapper;
import com.zxm.community.system.mapper.SysUserMapper;
import com.zxm.community.system.service.SysMenuService;
import com.zxm.community.system.service.SysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
class CommunityApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    SysMenuService sysMenuService;

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Test
    public void testSelectMenuTreeAll(){
        List<SysMenu> sysMenus = sysMenuMapper.selectMenuTreeAll();
        System.out.println(sysMenus);
    }

    @Test
    public void testSelectRoleAndMenuByUserId(){
        Set<String> set1 = sysRoleService.selectRolePermissionByUserId(1L);
        System.out.println("用户角色权限信息"+set1);
        Set<String> set2 = sysMenuService.selectMenuPermissionByUserId(2L);
        System.out.println("用户菜单权限信息"+set2);
    }


    @Test
    public void testSelectUserByUserName(){
        SysUser admin = sysUserMapper.selectUserByUserName("admin");
        System.out.println(admin);
    }
}
