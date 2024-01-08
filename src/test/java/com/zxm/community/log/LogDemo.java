package com.zxm.community.log;

import org.assertj.core.data.TemporalUnitLessThanOffset;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: zxm
 * @Date: 2024/1/8 -  14:49
 * @Description: com.zxm.community.log
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogDemo {

    @Test
    public void test1(){
        Logger logger = LoggerFactory.getLogger(LogDemo.class);
        logger.info("Hello LogBack!!!");
    }
}
