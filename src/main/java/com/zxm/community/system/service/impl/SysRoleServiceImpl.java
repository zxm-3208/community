package com.zxm.community.system.service.impl;

import com.zxm.community.system.mapper.SysRoleMapper;
import com.zxm.community.system.service.SysRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: zxm
 * @Date: 2024/1/20 -  15:50
 * @Description: com.zxm.community.system.service.impl
 * @version: 1.0
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {

        List<String> list = sysRoleMapper.selectRolePermissionByUserId(userId);
        HashSet<String> permsSet = new HashSet<>();
        for (String roleKey: list){
            if (!StringUtils.isEmpty(roleKey)) {
                permsSet.add(roleKey);
            }
        }

        return permsSet;
    }
}
