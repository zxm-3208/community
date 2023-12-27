package com.zxm.community.web.test;

import javax.validation.constraints.NotNull;

/**
 * @Auther: zxm
 * @Date: 2023/12/27 - 12 - 27 - 13:41
 * @Description: com.zxm.community.web.test
 * @version: 1.0
 */
public class User {
    @NotNull(message = "userId 不能为空")
    private String userId;

    @NotNull(message = "username不能为空")
    private String username;

    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
