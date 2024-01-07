package com.zxm.community.system.service.impl;

import com.zxm.community.system.domain.SysArea;
import com.zxm.community.system.domain.dto.SysAreaDto;
import com.zxm.community.system.mapper.SysAreaMapper;
import com.zxm.community.system.service.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: zxm
 * @Date: 2023/12/29 -  20:08
 * @Description: com.zxm.community.system.service.impl
 * @version: 1.0
 */
@Service
public class SysAreaServiceImpl implements SysAreaService {

    @Autowired
    private SysAreaMapper sysAreaMapper;
    
    @Override
    public List<SysAreaDto> findAreaAsTree() {
        /**
         * 获取区域表数据
         */
        List<SysArea> list = sysAreaMapper.findAll();
    
        return list.stream().filter(area -> area.getParentCode().equals(0))
                .map(area -> {
                    SysAreaDto sysAreaDto = new SysAreaDto();
                    sysAreaDto.setCode(area.getCode());
                    sysAreaDto.setName(area.getName());
                    sysAreaDto.setChildren(getChildrenArea(sysAreaDto, list));
                    return sysAreaDto;
                }).collect(Collectors.toList());
    }

    /**
     * @description: 递归设置区域信息
     * @param sysAreaDto 上级区域信息
     * @param list  所有区域信息
     * @return: List<SysAreaDto>
     * @throws:
     * @author: zxm
     * @time: 2024/1/6 15:46
    */
    private List<SysAreaDto> getChildrenArea(SysAreaDto sysAreaDto, List<SysArea> list){
        List<SysArea> subAreaList = list.stream().filter(area -> area.getParentCode().equals(sysAreaDto.getCode()))  // 获取当前父区域的子结点
                .collect(Collectors.toList());  //把当前流转换为一个List集合

        if(subAreaList != null && subAreaList.size() != 0) {
            return subAreaList.stream().map(area -> {
                SysAreaDto subAreaDto = new SysAreaDto();
                subAreaDto.setName(area.getName());
                // 设置子节点,递归调用知道获取叶子结点为止
                subAreaDto.setChildren(getChildrenArea(subAreaDto, list));
                return subAreaDto;
            }).collect(Collectors.toList());
        }
        return null;
    }
}
