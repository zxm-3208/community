package com.zxm.community.web.controller.system;

import com.zxm.community.common.utils.ChainedMap;
import com.zxm.community.system.domain.vo.LoginBody;
import com.zxm.community.system.service.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zxm
 * @Date: 2024/1/17 -  17:35
 * @Description: 登录验证
 * @version: 1.0
 */
@RestController
public class SysLoginController {

    @Autowired
    private SysLoginService loginService;

    /**
     * @description: 登陆方法
     * @param loginBody
     * @return: ChainedMap
     * @throws: 
     * @author: zxm
     * @time: 2024/1/17 17:36
    */
    @PostMapping("/login")
    public ChainedMap login(@RequestBody LoginBody loginBody){
        /**
         * 生成令牌
         */
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(), loginBody.getUuid());

        return ChainedMap.create().set("token", token);
    }

}
