package com.zxm.community.system.service.impl;

import com.zxm.community.system.mapper.SysMenuMapper;
import com.zxm.community.system.service.SysMenuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
