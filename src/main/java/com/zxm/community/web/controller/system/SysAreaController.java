package com.zxm.community.web.controller.system;

import com.zxm.community.common.core.domain.BaseResponse;
import com.zxm.community.system.service.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zxm
 * @Date: 2024/1/6 -  16:04
 * @Description: com.zxm.community.web.controller.system
 * @version: 1.0
 */
@RestController
@RequestMapping("/system/area")
public class SysAreaController {
    @Autowired
    private SysAreaService sysAreaService;

    @RequestMapping("/tree")
    public BaseResponse getAreaTree(){
        return BaseResponse.success(sysAreaService.findAreaAsTree());
    }

}
