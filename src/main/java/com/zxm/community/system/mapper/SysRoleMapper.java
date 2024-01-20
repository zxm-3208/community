package com.zxm.community.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxm.community.system.domain.SysRole;

import java.util.List;

/**
 * @Auther: zxm
 * @Date: 2024/1/20 -  15:36
 * @Description: com.zxm.community.system.mapper
 * @version: 1.0
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * @description: 根据用户id查询用户权限
     * @param userId
     * @return: List<String>
     * @throws:
     * @author: zxm
     * @time: 2024/1/20 15:41
    */
    List<String> selectRolePermissionByUserId(Long userId);

}
