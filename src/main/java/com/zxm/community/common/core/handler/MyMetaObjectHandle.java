package com.zxm.community.common.core.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: zxm
 * @Date: 2024/1/6 -  17:27
 * @Description: 自定义填充控制器
 * @version: 1.0
 */
@Component
public class MyMetaObjectHandle implements MetaObjectHandler {

    /**
     * insert时 要填充的字段
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //根据属性名称设置要填充的字段
        this.strictInsertFill(metaObject, "createBy", String.class, "admin");
        this.strictInsertFill(metaObject, "updateBy", String.class, "admin");
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
    }

    /**
     * 在update操作的时候，要填充的字段
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateBy", String.class, "admin");
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }
}
