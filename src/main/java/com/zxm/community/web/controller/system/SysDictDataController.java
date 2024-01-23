package com.zxm.community.web.controller.system;

import com.zxm.community.common.core.controller.BaseController;
import com.zxm.community.common.core.domain.BaseResponse;
import com.zxm.community.common.core.page.PageResult;
import com.zxm.community.common.utils.SecurityUtils;
import com.zxm.community.system.domain.SysDictData;
import com.zxm.community.system.service.SysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: zxm
 * @Date: 2024/1/23 -  12:41
 * @Description: 数据字典信息
 * @version: 1.0
 */
@RestController
@RequestMapping("/system/dict/data")
public class SysDictDataController extends BaseController {

    @Autowired
    private SysDictDataService dictDataService;

    /**
     * 查询字典数据列表
     */
    @RequestMapping("/list")
    public PageResult list(SysDictData sysDictData){
        startPage();
        List<SysDictData> list = dictDataService.selectDictDataList(sysDictData);
        return getData(list);
    }

    /**
     * 根据Id查询字典详细信息
     */
    @GetMapping(value = "/{dictCode}")
    public BaseResponse getInfo(@PathVariable Long dictCode){

        return BaseResponse.success(dictDataService.selectDictDataById(dictCode));
    }


    /**
     *删除字典数据
     */
    @DeleteMapping("/{dictCodes}")
    public BaseResponse remove(@PathVariable Long[] dictCodes){

        return toAjax(dictDataService.deleteDictDataByIds(dictCodes));
    }

    /**
     * 新增字典数据
     */
    @PostMapping
    public BaseResponse add(SysDictData sysDictData){
        sysDictData.setCreateBy(SecurityUtils.getUserName());
        return toAjax(dictDataService.insertDictData(sysDictData));
    }

    /**
     * 修改字典数据
     */
    @PutMapping
    public BaseResponse edit(SysDictData sysDictData){
        sysDictData.setUpdateBy(SecurityUtils.getUserName());
        return toAjax(dictDataService.updateDictData(sysDictData));
    }



}
