package com.zxm.community.framework.security;

import org.springframework.security.core.AuthenticationException;

/**
 * @Auther: zxm
 * @Date: 2024/1/16 -  17:09
 * @Description: 自定义验证码异常
 * @version: 1.0
 */
public class CaptchaNotMatchException extends AuthenticationException {
    public CaptchaNotMatchException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CaptchaNotMatchException(String msg) {
        super(msg);
    }
}
