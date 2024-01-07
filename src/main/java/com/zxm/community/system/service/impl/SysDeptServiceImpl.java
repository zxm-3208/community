package com.zxm.community.system.service.impl;

import com.zxm.community.system.domain.SysDept;
import com.zxm.community.system.mapper.SysDeptMapper;
import com.zxm.community.system.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zxm
 * @Date: 2024/1/7 -  11:21
 * @Description: com.zxm.community.system.service.impl
 * @version: 1.0
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {
    @Autowired
    private SysDeptMapper deptMapper;

    @Override
    public List<SysDept> selectDeptList(SysDept sysDept) {
        return deptMapper.selectDeptList(sysDept);
    }
}
