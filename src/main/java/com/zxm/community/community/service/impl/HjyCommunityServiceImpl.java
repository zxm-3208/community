package com.zxm.community.community.service.impl;

import com.zxm.community.common.utils.OrikaUtils;
import com.zxm.community.community.domain.HjyCommunity;
import com.zxm.community.community.domain.dto.HjyCommunityDto;
import com.zxm.community.community.domain.dto.HjyCommunityExcelDto;
import com.zxm.community.community.domain.vo.HjyCommunityVo;
import com.zxm.community.community.mapper.HjyCommunityMapper;
import com.zxm.community.community.service.HjyCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: zxm
 * @Date: 2023/12/28 -  19:14
 * @Description: com.zxm.community.community.service.impl
 * @version: 1.0
 */
@Component
public class HjyCommunityServiceImpl implements HjyCommunityService {

    @Autowired
    private HjyCommunityMapper hjyCommunityMapper;

    private static final String CODE_PREFIX = "COMMUNITY_";
    @Override
    public List<HjyCommunityDto> queryList(HjyCommunity hjyCommunity) {
        return hjyCommunityMapper.queryList(hjyCommunity);
    }

    @Override
    public int inserHjyCommunity(HjyCommunity hjyCommunity) {
        //设置小区编码
        hjyCommunity.setCommunityCode(CODE_PREFIX + System.currentTimeMillis());
        return hjyCommunityMapper.insert(hjyCommunity);
    }

    @Override
    public HjyCommunity selectHjyCommunityById(Long communityId) {
        return hjyCommunityMapper.selectById(communityId);
    }

    @Override
    public int updateHjyCommunity(HjyCommunity hjyCommunity) {
        return hjyCommunityMapper.updateById(hjyCommunity);
    }

    @Override
    public int deleteHjyCommunity(Long[] communityIds) {
        return hjyCommunityMapper.deleteBatchIds(Arrays.asList(communityIds));
    }

    @Override
    public List<HjyCommunityVo> queryPullDown(HjyCommunity hjyCommunity) {
        List<HjyCommunityDto> dtolist = hjyCommunityMapper.queryList(hjyCommunity);

        //对象拷贝
        List<HjyCommunityVo> voList = dtolist.stream().map(dto -> {
            //使用orik完成对象拷贝
            HjyCommunityVo communityVo = OrikaUtils.convert(dto, HjyCommunityVo.class);
            return communityVo;
        }).collect(Collectors.toList());

        return voList;
    }
}
