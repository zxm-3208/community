package com.zxm.community.community.domain.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Auther: zxm
 * @Date: 2024/1/8 -  13:06
 * @Description: 导出Excel实体类
 * @version: 1.0
 */

@ExcelTarget("community")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HjyCommunityExcelDto {

    /**
     * 小区ID
     */
    @Excel(name = "序号")
    private Long communityId;

    /**
     * 小区名称
     */
    @Excel(name = "小区名称")
    private String communityName;

    /**
     * 小区编码
     */
    @Excel(name = "小区编码")
    private String communityCode;

    /**
     * 省名称
     */
    @Excel(name="省")
    private String communityProvinceName;

    /**
     * 市名称
     */
    @Excel(name="市")
    private String communityCityName;

    /**
     * 区名称
     */
    @Excel(name="区/县")
    private String communityTownName;

    @Excel(name = "创建时间", exportFormat = "yyyy年MM月dd日")
    private Date createTime;

    @Excel(name = "备注")
    private String remark;



}
