package com.lwd.test.projectname.client.common;

/**
 * 分页请求基础对象
 * 
 */
public class AbstractPageQuery extends AbstractEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -3477721647395422997L;
    // 页码
    private int pageNo = 1;
    // 每页数量
    private int pageSize = 20;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
