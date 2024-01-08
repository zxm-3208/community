package com.zxm.community.web.controller.common;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.zxm.community.common.core.controller.BaseController;
import com.zxm.community.common.core.domain.BaseResponse;
import com.zxm.community.common.utils.ExcelUtils;
import com.zxm.community.community.domain.HjyCommunity;
import com.zxm.community.community.domain.dto.HjyCommunityDto;
import com.zxm.community.community.domain.dto.HjyCommunityExcelDto;
import com.zxm.community.community.service.HjyCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: zxm
 * @Date: 2024/1/8 -  13:21
 * @Description: com.zxm.community.web.controller.common
 * @version: 1.0
 */

@Controller
@RequestMapping("/exportExcel")
public class ExportExcelController extends BaseController {

    @Autowired
    private HjyCommunityService hjyCommunityService;

    @GetMapping("/exportCommunityExcel")
    public BaseResponse exportExcel(HjyCommunity hjyCommunity, HttpServletResponse response){

        startPage();
        List<HjyCommunityDto> list = hjyCommunityService.queryList(hjyCommunity);

        // 数据转换
        List<HjyCommunityExcelDto> excelDtoList = list.stream().map(hjyCommunityDto -> {
            HjyCommunityExcelDto excelDto = new HjyCommunityExcelDto();
            excelDto.setCommunityId(hjyCommunityDto.getCommunityId());
            excelDto.setCommunityName(hjyCommunityDto.getCommunityName());
            excelDto.setCommunityCode(hjyCommunityDto.getCommunityProvinceCode());
            excelDto.setCommunityProvinceName(hjyCommunityDto.getCommunityProvinceName());
            excelDto.setCommunityCityName(hjyCommunityDto.getCommunityCityName());
            excelDto.setCommunityTownName(hjyCommunityDto.getCommunityTownName());
            excelDto.setCreateTime(hjyCommunityDto.getCreateTime());
            excelDto.setRemark(hjyCommunityDto.getRemark());
            return excelDto;
        }).collect(Collectors.toList());
        ExcelUtils.exportExcel(excelDtoList, HjyCommunityExcelDto.class, "小区信息.xls", response, new ExportParams("小区信息列表", "小区信息"));
        return BaseResponse.success("导出小区信息到Excel成功！");
    }

}
