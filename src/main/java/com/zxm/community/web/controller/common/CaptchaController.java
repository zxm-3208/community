package com.zxm.community.web.controller.common;

import com.wf.captcha.SpecCaptcha;
import com.zxm.community.common.constant.Constants;
import com.zxm.community.common.utils.ChainedMap;
import com.zxm.community.common.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;

/**
 * @Auther: zxm
 * @Date: 2024/1/17 -  14:28
 * @Description: 获取验证码
 * @version: 1.0
 */
@RestController
public class CaptchaController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/captchaImage")
    public ChainedMap getCode(HttpServletResponse response){
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);

        /**
         * 生成验证码，以及验证码唯一标识
         */
        String uuid = UUIDUtils.simpleUUID();
        
        /**
         * 拼接redis的key
         */
        String key = Constants.CAPTCHA_CODE_KEY + uuid;
        String code = specCaptcha.text().toLowerCase();
        
        /**
         * 保存到redis
         */
        redisTemplate.opsForValue().set(key, code, Duration.ofMinutes(10));

        return ChainedMap.create().set("uuid", uuid).set("img", specCaptcha.toBase64());

    }

}
