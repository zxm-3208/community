package com.zxm.community.common.core.domain;

import javax.xml.transform.Result;
import java.io.Serializable;

/**
 * 响应结果封装对象
 * @Auther: zxm
 * @Date: 2023/12/27 - 12 - 27 - 13:13
 * @Description: com.zxm.community.common.core.domain
 * @version: 1.0
 */
public class BaseResponse<T> implements Serializable {
    
    private static final long serialVersionUID = 7356523536514560284L;

    public BaseResponse() {
    }

    /**
     * 响应状态码
     */
    private String code;

    /**
     * 响应结果描述
     */
    private String msg;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * @description: 成功返回
     * @param data
     * @return: BaseResponse<T>
     * @throws: 
     * @author: zxm
     * @time: 2023/12/27 13:26
    */
    public static <T> BaseResponse<T> success(T data){
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResultCode.SUCCESS.getCode());
        response.setMsg(ResultCode.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }


    /**
     * @description: 失败返回
     * @param message
     * @return: BaseResponse<T>
     * @throws:
     * @author: zxm
     * @time: 2023/12/27 13:38
    */
    public static <T> BaseResponse<T> fail(String message){
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResultCode.ERROR.getCode());
        response.setMsg(message);
        return response;
    }

    /**
     * @description: 失败返回
     * @param code
     * @param message
     * @return: BaseResponse<T>
     * @throws:
     * @author: zxm
     * @time: 2023/12/27 13:39
    */
    public static <T> BaseResponse<T> fail(String code, String message){
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMsg(message);
        return response;
    }

    /**
     * @description: 失败返回 三个参数
     * @param code
     * @param message
     * @param success
     * @return: BaseResponse<T>
     * @throws:
     * @author: zxm
     * @time: 2024/1/18 15:37
    */
    public static <T> BaseResponse<T> fail(String code, String message, boolean success){
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMsg(message);
        response.setSuccess(success);
        return response;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
