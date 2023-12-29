package com.zxm.community.web.test;

import com.zxm.community.common.core.domain.BaseResponse;
import com.zxm.community.common.core.exception.BaseException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: zxm
 * @Date: 2023/12/27 - 12 - 27 - 13:42
 * @Description: com.zxm.community.web.test
 * @version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/queryUserById")
    public BaseResponse<User> queryUserById(String userId){
        if(userId != null){
            return BaseResponse.success(new User(userId, "spike"));
        }else{
            return BaseResponse.fail("查询用户失败！");
        }
    }

    @RequestMapping("/addUser")
    public BaseResponse addUse(@Validated User user, BindingResult bindingResult){
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        // 如果参数校验失败，会将错误信息封装成对象组装到BindingResult
        if(!fieldErrors.isEmpty()){
            return BaseResponse.fail(fieldErrors.get(0).getDefaultMessage());
        }

        return BaseResponse.success("OK");
    }

    @RequestMapping("/queryUser")
    public BaseResponse queryUser(User user){
        throw new BaseException("500", "测试异常类！！！");
    }
}
