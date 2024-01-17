package com.zxm.community.system.service.impl;

import com.zxm.community.common.constant.Constants;
import com.zxm.community.common.utils.UUIDUtils;
import com.zxm.community.system.domain.LoginUser;
import com.zxm.community.system.service.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @Auther: zxm
 * @Date: 2024/1/17 -  17:20
 * @Description: com.zxm.community.system.service.impl
 * @version: 1.0
 */
@Component
public class TokenServiceImpl implements TokenService {

    /**
     * 令牌自定义标识
     */
    @Value("${token.header}")
    private String header;

    /**
     * 令牌密钥
     */
    @Value("${token.secret}")
    private String secret;

    /**
     * 令牌有效期
     */
    @Value("${token.expireTime}")
    private String expireTime;

    /*
     * @description: 创建令牌
     * @param loginUser
     * @return: String
     * @throws:
     * @author: zxm
     * @time: 2024/1/17 17:24
    */
    @Override
    public String createtoken(LoginUser loginUser) {

        /**
         * 设置用户的唯一标识
         */
        String userKey = UUIDUtils.randomUUID();
        loginUser.setToken(userKey);

        HashMap<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, userKey);
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret).compact();
        return token;
    }
}
