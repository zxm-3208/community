package com.zxm.community.system.service.impl;

import com.zxm.community.common.constant.Constants;
import com.zxm.community.common.core.exception.BaseException;
import com.zxm.community.common.core.exception.UserPasswordNotMatchException;
import com.zxm.community.common.utils.RedisCache;
import com.zxm.community.common.core.exception.CaptchaNotMatchException;
import com.zxm.community.system.domain.LoginUser;
import com.zxm.community.system.service.SysLoginService;
import com.zxm.community.system.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @Auther: zxm
 * @Date: 2024/1/17 -  16:52
 * @Description: com.zxm.community.system.service.impl
 * @version: 1.0
 */
@Service
public class SysLoginServiceImpl implements SysLoginService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * @description: 带验证码登录
     * @param username
     * @param password
     * @param code
     * @param uuid
     * @return: String
     * @throws: 
     * @author: zxm
     * @time: 2024/1/17 16:52
    */
    @Override
    public String login(String username, String password, String code, String uuid) {

        /**
         * 1. 从redis中获取验证码，判断是否正确
         */
        String key = Constants.CAPTCHA_CODE_KEY + uuid;
        String captcha = redisCache.getCacheObject(key);
        redisCache.deleteObject(key);

        if(captcha == null || !code.equalsIgnoreCase(captcha)){
            throw new CaptchaNotMatchException();
        }

        /**
         * 2. 进行用户认证
         */
        Authentication authenticate = null;
        try {
            authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch(Exception e){
            throw new UserPasswordNotMatchException();
        }
        
        /**
         * 3. 获取用户经过身份验证的用户主体信息
         */
        LoginUser loginUser = (LoginUser)authenticate.getPrincipal();

        return tokenService.createtoken(loginUser);
    }
}
