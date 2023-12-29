package com.zxm.community.common.core.exception;

import com.zxm.community.common.core.domain.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * @Auther: zxm
 * @Date: 2023/12/27 -  15:02
 * @Description: com.zxm.community.common.exception
 * @version: 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public BaseResponse baseExceptionHandler(BaseException e){

        return BaseResponse.fail(e.getDefaultMessage());
    }

}
