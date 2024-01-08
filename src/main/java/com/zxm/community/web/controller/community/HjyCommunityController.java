package com.zxm.community.web.controller.community;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxm.community.common.constant.HttpStatus;
import com.zxm.community.common.core.controller.BaseController;
import com.zxm.community.common.core.domain.BaseResponse;
import com.zxm.community.common.core.page.PageResult;
import com.zxm.community.common.utils.ServletUtils;
import com.zxm.community.community.domain.HjyCommunity;
import com.zxm.community.community.domain.dto.HjyCommunityDto;
import com.zxm.community.community.domain.vo.HjyCommunityVo;
import com.zxm.community.community.service.HjyCommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: zxm
 * @Date: 2023/12/29 -  12:14
 * @Description: com.zxm.community.web.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/community")
@Slf4j
public class HjyCommunityController extends BaseController {
    @Autowired
    private HjyCommunityService hjyCommunityService;

    /**
     * @description: 多条件分页查询
     * @param hjyCommunity
     * @return: PageResult
     * @throws: 
     * @author: zxm
     * @time: 2024/1/6 17:47
    */
    @GetMapping("/list")
    public PageResult list(HjyCommunity hjyCommunity){
        startPage();
        List<HjyCommunityDto> list = hjyCommunityService.queryList(hjyCommunity);
        return getData(list);
    }

    /**
     * @description: 新增小区
     * @param hjyCommunity
     * @return: BaseResponse
     * @throws:
     * @author: zxm
     * @time: 2024/1/6 17:49
    */
    @PostMapping
    public BaseResponse add(@RequestBody HjyCommunity hjyCommunity){
        return toAjax(hjyCommunityService.inserHjyCommunity(hjyCommunity));
    }

    /**
     * @description: 根据Id回显小区信息
     * @param communityId
     * @return: BaseResponse
     * @throws:
     * @author: zxm
     * @time: 2024/1/7 10:10
    */
    @GetMapping("/{communityId}")
    public BaseResponse getInfo(@PathVariable("communityId") Long communityId){
        return BaseResponse.success(hjyCommunityService.selectHjyCommunityById(communityId));
    }

    /**
     * @description: 修改小区
     * @param hjyCommunity
     * @return: BaseResponse
     * @throws:
     * @author: zxm
     * @time: 2024/1/7 9:40
    */
    @PutMapping
    public BaseResponse edit(@RequestBody HjyCommunity hjyCommunity){
        return toAjax(hjyCommunityService.updateHjyCommunity(hjyCommunity));
    }


    /**
     * @description: 根据Id删除小区信息
     * @param communityIds
     * @return: BaseResponse
     * @throws:
     * @author: zxm
     * @time: 2024/1/7 10:47
    */
    @DeleteMapping("/{communityIds}")
    public BaseResponse delete(@PathVariable Long[] communityIds){
        return toAjax(hjyCommunityService.deleteHjyCommunity(communityIds));
    }

    /**
     * @description: 小区下拉列表展示
     * @param hjyCommunity
     * @return: BaseResponse
     * @throws:
     * @author: zxm
     * @time: 2024/1/8 19:05
    */
    @GetMapping("/queryPullDown")
    public BaseResponse queryPullDown(HjyCommunity hjyCommunity){

        // 打印入参日志
        log.info("log() called with parameters => [hjycommunity = {}]", hjyCommunity);

        List<HjyCommunityVo> voList = null;
        try {
            voList = hjyCommunityService.queryPullDown(hjyCommunity);
        } catch (Exception e){
            log.warn("获取小区下拉列表失败！",e);
        }
        // 打印日志，返回结果
        log.info("log() returned: {}", voList);
        return BaseResponse.success(voList);
    }
}
