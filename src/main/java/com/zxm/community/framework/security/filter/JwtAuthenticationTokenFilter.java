package com.zxm.community.framework.security.filter;

import com.zxm.community.system.domain.LoginUser;
import com.zxm.community.system.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @Auther: zxm
 * @Date: 2024/1/18 -  19:36
 * @Description: Token过滤器，验证token的有效性
 * @version: 1.0
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
        /**
         * 1. 从redis中拿到用户信息
         */
        LoginUser loginUser = tokenService.getLoginUser(request);
        /**
         * 2. 获取用户认证对象
         */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!Objects.isNull(loginUser) && Objects.isNull(authentication)){
            tokenService.verifyToken(loginUser);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
            /**
             * 设置当前身份验证相关的详细信息
             */
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);
    }

}
