package com.zxm.community.system.domain;

import com.zxm.community.common.core.domain.BaseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 部门表(SysDept)实体类
 *
 * @author makejava
 * @since 2024-01-07 11:00:56
 */
public class SysDept extends BaseEntity{
    private static final long serialVersionUID = 894927562966462429L;
/**
     * 部门id
     */
    private Long deptId;
/**
     * 父部门id
     */
    private Long parentId;

    /**
     * 父部门的名称
     */
    private String parentName;

    /**
     * 子部门集合
     */
    private List<SysDept> children = new ArrayList<>();

    /**
     * 祖级列表
     */
    private String ancestors;
/**
     * 部门名称
     */
    private String deptName;
/**
     * 显示顺序
     */
    private Integer orderNum;
/**
     * 负责人
     */
    private String leader;
/**
     * 联系电话
     */
    private String phone;
/**
     * 邮箱
     */
    private String email;
/**
     * 部门状态（0正常 1停用）
     */
    private String status;
/**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;


    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<SysDept> getChildren() {
        return children;
    }

    public void setChildren(List<SysDept> children) {
        this.children = children;
    }

}

