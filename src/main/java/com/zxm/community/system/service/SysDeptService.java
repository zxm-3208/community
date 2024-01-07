package com.zxm.community.system.service;

import com.zxm.community.system.domain.SysDept;

import java.util.List;

/**
 * @Auther: zxm
 * @Date: 2024/1/7 -  11:20
 * @Description: com.zxm.community.system.service
 * @version: 1.0
 */
public interface SysDeptService {
    /**
     * @description: 查询部门管理数据
     * @param sysDept
     * @return: List<SysDept>
     * @throws:
     * @author: zxm
     * @time: 2024/1/7 11:19
     */
    public List<SysDept> selectDeptList(SysDept sysDept);
}
