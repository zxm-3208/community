package com.zxm.community.community.service;

import com.zxm.community.community.domain.HjyCommunity;
import com.zxm.community.community.domain.dto.HjyCommunityDto;

import java.util.List;

/**
 * @Auther: zxm
 * @Date: 2023/12/28 -  19:12
 * @Description: com.zxm.community.community.service
 * @version: 1.0
 */
public interface HjyCommunityService {
    /**
     * @description: 根据条件查询小区信息列表
     * @param hjyCommunity
     * @return: List<HjyCommunityDto>
     * @throws:
     * @author: zxm
     * @time: 2023/12/28 19:13
    */
    List<HjyCommunityDto> queryList(HjyCommunity hjyCommunity);

    /**
     * @description: 新增小区
     * @param hjyCommunity
     * @return: int
     * @throws:
     * @author: zxm
     * @time: 2024/1/6 17:43
    */
    int inserHjyCommunity(HjyCommunity hjyCommunity);

    /**
     * @description: 根据id获取小区详情
     * @param communityId
     * @return: HjyCommunity
     * @throws:
     * @author: zxm
     * @time: 2024/1/7 9:25
    */
    HjyCommunity selectHjyCommunityById(Long communityId);

    /**
     * @description: 修改小区
     * @param hjyCommunity
     * @return: int
     * @throws:
     * @author: zxm
     * @time: 2024/1/7 9:37
    */
    int updateHjyCommunity(HjyCommunity hjyCommunity);

    /**
     * @description: 删除操作
     * @param communityIds
     * @return: int
     * @throws:
     * @author: zxm
     * @time: 2024/1/7 10:30
    */
    int deleteHjyCommunity(Long[] communityIds);
}
