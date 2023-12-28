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

}
