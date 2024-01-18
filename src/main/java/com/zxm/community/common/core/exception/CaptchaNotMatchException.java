package com.zxm.community.common.core.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Auther: zxm
 * @Date: 2024/1/16 -  17:09
 * @Description: 自定义验证码异常
 * @version: 1.0
 */
public class CaptchaNotMatchException extends CustomException {
    public CaptchaNotMatchException() {
        super(400, "验证码错误");
    }
}
