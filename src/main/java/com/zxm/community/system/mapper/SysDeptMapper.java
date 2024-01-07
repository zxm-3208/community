package com.zxm.community.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxm.community.system.domain.SysDept;

import java.util.List;

/**
 * @Auther: zxm
 * @Date: 2024/1/7 -  11:15
 * @Description: com.zxm.community.system.mapper
 * @version: 1.0
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

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
