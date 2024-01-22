package com.zxm.community.framework.security.handle;

import com.alibaba.fastjson.JSON;
import com.zxm.community.common.constant.HttpStatus;
import com.zxm.community.common.core.domain.BaseResponse;
import com.zxm.community.common.utils.ServletUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: zxm
 * @Date: 2024/1/17 -  16:40
 * @Description: com.zxm.community.framework.security
 * @version: 1.0
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        /**
         * 状态码401
         */
        Integer code = HttpStatus.UNAUTHORIZED;
        ServletUtils.renderString(response, JSON.toJSONString(BaseResponse.fail(code.toString(), "认证失败，无法访问系统资源")));

    }
}
