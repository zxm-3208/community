package com.zxm.community.system.service;

import com.zxm.community.system.domain.LoginUser;

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
}
