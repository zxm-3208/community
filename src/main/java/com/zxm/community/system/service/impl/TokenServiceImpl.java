package com.zxm.community.system.service.impl;

import com.zxm.community.common.constant.Constants;
import com.zxm.community.common.utils.RedisCache;
import com.zxm.community.common.utils.UUIDUtils;
import com.zxm.community.system.domain.LoginUser;
import com.zxm.community.system.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: zxm
 * @Date: 2024/1/17 -  17:20
 * @Description: com.zxm.community.system.service.impl
 * @version: 1.0
 */
@Component
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisCache redisCache;

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
    private int expireTime;

    /**
     * 毫秒
     */
    private static final long MILLIS_SECOND = 1000;

    /**
     * 分钟
     */
    private static final long MILLIS_MINUTE = MILLIS_SECOND * 60;
    /**
     * 20分钟
     */
    private static final long MILLIS_MINUTE_TEN = MILLIS_SECOND * 60 * 20;

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

        /**
         * todo 保存用户信息，刷新令牌
         */
        refreshToken(loginUser);

        HashMap<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, userKey);
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret).compact();
        return token;
    }

    @Override
    public void refreshToken(LoginUser loginUser) {

        loginUser.setLoginTime(System.currentTimeMillis());

        /**
         * 过期时间30分钟
         */
        loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);

        /**
         * 根据UUID将loginUser缓存
         */
        String userKey = getTokenKey(loginUser.getToken());
        redisCache.setCacheObject(userKey, loginUser, expireTime, TimeUnit.MINUTES);
        
    }

    @Override
    public LoginUser getLoginUser(HttpServletRequest request) {
        String token = getToken(request);
        if(!StringUtils.isEmpty(token)){
            Claims claims = parseToken(token);
            /**
             * 解析对应的用户信息
             */
            String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
            String userKey = getTokenKey(uuid);
            LoginUser loginUser = redisCache.getCacheObject(userKey);
            return loginUser;
        }

        return null;
    }

    @Override
    public void verifyToken(LoginUser loginUser) {
        Long expireTime = loginUser.getExpireTime();
        long currentTimeMillis = System.currentTimeMillis();
        /**
         * 相差不足20分钟，自动刷新缓存
         */
        if (expireTime-currentTimeMillis <= MILLIS_MINUTE_TEN){
            refreshToken(loginUser);
        }
    }

    @Override
    public void setLoginUser(LoginUser loginUser) {
        if(!Objects.isNull(loginUser) && !StringUtils.isEmpty(loginUser.getToken())){
            refreshToken(loginUser);
        }
    }

    @Override
    public void delLoginUser(String token) {
        if(StringUtils.isEmpty(token)){
            String tokenKey = getTokenKey(token);
            redisCache.deleteObject(tokenKey);
        }
    }

    /**
     * @description: 从令牌中获取数据声明
     * @param token
     * @return: String
     * @throws:
     * @author: zxm
     * @time: 2024/1/18 16:57
    */
    private Claims parseToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * @description: 拼接tokenKey
     * @param uuid
     * @return: String
     * @throws:
     * @author: zxm
     * @time: 2024/1/18 16:39
    */
    private String getTokenKey(String uuid){
        return Constants.LOGIN_TOKEN_KEY + uuid;
    }

    /**
     * @description: 从请求头中获取token
     * @param request
     * @return: String
     * @throws: 
     * @author: zxm
     * @time: 2024/1/18 16:49
    */
    private String getToken(HttpServletRequest request){
        String token = request.getHeader(this.header);
        /**
         * JWT标准写法 Authorization: Bearer aaa.bbb.ccc
         */
        if(!StringUtils.isEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)){
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }
}
