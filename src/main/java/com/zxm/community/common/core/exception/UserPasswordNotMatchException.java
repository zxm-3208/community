package com.zxm.community.common.core.exception;

/**
 * @Auther: zxm
 * @Date: 2024/1/18 -  16:04
 * @Description: 用户密码不正确异常类
 * @version: 1.0
 */
public class UserPasswordNotMatchException extends CustomException{
    public UserPasswordNotMatchException() {
        super(400, "用户不存在/密码错误");
    }
}
