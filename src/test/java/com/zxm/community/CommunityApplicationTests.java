package com.zxm.community;

import com.zxm.community.system.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    SysUserMapper sysUserMapper;

    @Test
    public void testSelectUserByUserName(){
        sysUserMapper.selectUserByUserName("admin");
        System.out.println("admin");
    }
}
