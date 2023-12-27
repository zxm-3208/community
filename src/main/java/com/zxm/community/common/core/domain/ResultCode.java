package com.zxm.community.common.core.domain;

/**
 * 响应状态码枚举类
 * @Auther: zxm
 * @Date: 2023/12/27 - 12 - 27 - 12:56
 * @Description: com.zxm.community.common.core.domain
 * @version: 1.0
 */
public enum ResultCode {

    SUCCESS("200", "操作成功"),
    ERROR("500", "操作失败");

    /**
     * 自定义状态码
     */
    private String code;

    /**
     * 自定义描述
     */
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
