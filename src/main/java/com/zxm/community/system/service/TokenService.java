package com.zxm.community.system.service;

import com.zxm.community.system.domain.LoginUser;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: zxm
 * @Date: 2024/1/17 -  17:17
 * @Description: token验证处理
 * @version: 1.0
 */
public interface TokenService {
    
    /**
     * @description: 创建令牌
     * @param loginUser
     * @return: String
     * @throws: 
     * @author: zxm
     * @time: 2024/1/17 17:18
    */
    public String createtoken(LoginUser loginUser);

    /**
     * @description: 缓存用户信息&刷新令牌的有效期
     * @param loginUser
     * @return: void
     * @throws:
     * @author: zxm
     * @time: 2024/1/18 16:24
    */
    public void refreshToken(LoginUser loginUser);

    /**
     * @description: 获取用户信息
     * @param request
     * @return: LoginUser
     * @throws:
     * @author: zxm
     * @time: 2024/1/18 16:55
    */
    LoginUser getLoginUser(HttpServletRequest request);

    /**
     * @description: 验证令牌的有效期，并且实现刷新缓存
     * @param loginUser
     * @return: void
     * @throws: 
     * @author: zxm
     * @time: 2024/1/18 17:03
    */
    void verifyToken(LoginUser loginUser);

    /**
     * @description: 设置用户身份信息
     * @param loginUser
     * @return: void
     * @throws: 
     * @author: zxm
     * @time: 2024/1/18 17:08
    */
    void setLoginUser(LoginUser loginUser);

    /**
     * @description: 删除用户
     * @param token
     * @return: void
     * @throws: 
     * @author: zxm
     * @time: 2024/1/18 17:09
    */
    void delLoginUser(String token);
}
