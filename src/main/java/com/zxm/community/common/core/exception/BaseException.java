package com.zxm.community.common.core.exception;

/**
 * 基础异常类
 * @Auther: zxm
 * @Date: 2023/12/27 -  14:43
 * @Description: com.zxm.community.common.exception
 * @version: 1.0
 */
public class BaseException extends RuntimeException{

    /**
     * 错误码
     */
    private String code;
    
    /**
     * 错误消息
     */
    private String defaultMessage;

    public BaseException() {
    }

    public BaseException(String code, String defaultMessage) {
        super(defaultMessage);
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    public String getCode() {
        return code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
