package com.zxm.community.system.service;

/**
 * @Auther: zxm
 * @Date: 2024/1/17 -  16:50
 * @Description: com.zxm.community.system.service
 * @version: 1.0
 */
public interface SysLoginService {

    public String login(String username, String password, String code, String uuid);

}
