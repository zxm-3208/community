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
    private String message;

    /**
     * 返回的数据
     */
    private T data;

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
        response.setMessage(ResultCode.SUCCESS.getMessage());
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
        response.setMessage(message);
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
        response.setMessage(message);
        return response;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
