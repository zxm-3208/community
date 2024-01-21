package com.zxm.community.web.controller.system;

import com.zxm.community.common.core.controller.BaseController;
import com.zxm.community.common.core.domain.BaseResponse;
import com.zxm.community.system.domain.SysDept;
import com.zxm.community.system.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: zxm
 * @Date: 2024/1/7 -  11:26
 * @Description: com.zxm.community.web.controller.system
 * @version: 1.0
 */
@RestController
@RequestMapping("/system/dept")
public class SysDeptController extends BaseController {

    @Autowired
    private SysDeptService deptService;

    @GetMapping("/list")
    @PreAuthorize("@pe.hasPerms('system:dept:list')")
    public BaseResponse findDeptList(SysDept sysDept){
        List<SysDept> sysDepts = deptService.selectDeptList(sysDept);
        return BaseResponse.success(sysDepts);
    }


}
