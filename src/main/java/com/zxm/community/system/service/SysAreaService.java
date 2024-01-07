package com.zxm.community.system.service;

import com.zxm.community.system.domain.dto.SysAreaDto;

import java.util.List;

/**
 * @Auther: zxm
 * @Date: 2023/12/29 -  20:05
 * @Description: com.zxm.community.system.service
 * @version: 1.0
 */
public interface SysAreaService {

    /**
     * @description: 获取区域数据的完整树
     * @param 
     * @return: List<SysAreaDto>
     * @throws: 
     * @author: zxm
     * @time: 2023/12/29 20:07
    */
    List<SysAreaDto> findAreaAsTree();

}
