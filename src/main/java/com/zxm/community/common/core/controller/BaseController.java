package com.zxm.community.common.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxm.community.common.constant.HttpStatus;
import com.zxm.community.common.core.page.PageDomain;
import com.zxm.community.common.core.page.PageResult;
import com.zxm.community.common.utils.ServletUtils;

import java.util.List;

/**
 * @Auther: zxm
 * @Date: 2023/12/29 -  14:47
 * @Description: com.zxm.community.common.core.controller
 * @version: 1.0
 */
public class BaseController {

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每条显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * @description: 分装分页数据
     * @param
     * @return: PageDomain
     * @throws:
     * @author: zxm
     * @time: 2023/12/29 14:53
    */
    public static PageDomain getPageDomain(){
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(PAGE_SIZE));

        return pageDomain;
    }

    /**
     * @description: 封装调用PageHelper的startPage方法
     * @param 
     * @return: void
     * @throws: 
     * @author: zxm
     * @time: 2023/12/29 15:01
    */
    protected void startPage(){
        PageDomain pageDomain = getPageDomain();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if(pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum, pageSize);
        }
    }

    /**
     * @description: 响应分页数据
     * @param list
     * @return: PageResult
     * @throws: 
     * @author: zxm
     * @time: 2023/12/29 15:06
    */
    protected PageResult getData(List<?> list){
        PageResult pageResult = new PageResult();
        pageResult.setCode(HttpStatus.SUCCESS);
        pageResult.setMsg("分页查询成功");
        pageResult.setRows(list);
        pageResult.setTotal(new PageInfo(list).getTotal());
        return pageResult;
    }


}
