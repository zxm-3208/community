package com.zxm.community.common.utils;

import com.zxm.community.common.constant.HttpStatus;
import com.zxm.community.common.core.domain.BaseResponse;
import com.zxm.community.common.core.exception.CustomException;
import com.zxm.community.common.core.controller.BaseController;
import com.zxm.community.system.domain.LoginUser;
import com.zxm.community.system.domain.SysDictData;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Auther: zxm
 * @Date: 2024/1/23 -  13:02
 * @Description: 用户信息相关操作工具类
 * @version: 1.0
 */
public class SecurityUtils {

    /**
     * 获取用户账户
     */
    public static String getUserName(){
        try {
            return getLoginUser().getUsername();
        }catch (Exception e){
            throw new CustomException(HttpStatus.UNAUTHORIZED, "获取用户账户异常");
        }
    }

    /**
     * 获取完整登录用户信息
     */
    public static LoginUser getLoginUser(){
        try {
            return (LoginUser) getAuthentication().getPrincipal();
        }
        catch (Exception e){
            throw new CustomException(HttpStatus.UNAUTHORIZED, "获取用户信息异常");
        }
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication(){

        return SecurityContextHolder.getContext().getAuthentication();
    }

}
