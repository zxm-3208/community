package com.zxm.community.common.core.page;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: zxm
 * @Date: 2023/12/29 -  11:56
 * @Description: 分页查询统一响应封装
 * @version: 1.0
 */
public class PageResult implements Serializable {
    private static final long serialVersionUID = -2440833127924472782L;
    
    /**
     * 总记录数
     */
    private long total;

    /**
     * 列表数据
     */
    private List<?> rows;

    /**
     * 消息状态码
     */
    private Integer code;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * @description: 分页
     * @param total 总记录数
     * @param rows  列表数据
     * @return: null
     * @throws: 
     * @author: zxm
     * @time: 2023/12/29 12:01
    */
    public PageResult(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
