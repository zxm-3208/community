package com.zxm.community.system.domain.dto;

import com.zxm.community.system.domain.SysArea;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: zxm
 * @Date: 2023/12/29 -  16:32
 * @Description: 区域数据传输对象
 * @version: 1.0
 */
public class SysAreaDto implements Serializable {
    private static final long serialVersionUID = -7766178061319462750L;

    /**
     * 区划码
     */
    private Integer code;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 子区域
     */
    private List<SysAreaDto> children;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SysAreaDto> getChildren() {
        return children;
    }

    public void setChildren(List<SysAreaDto> children) {
        this.children = children;
    }
}
