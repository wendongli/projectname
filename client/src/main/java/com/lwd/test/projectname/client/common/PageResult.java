package com.lwd.test.projectname.client.common;

import java.util.List;

/**
 * 分页结果对象
 * 
 * @param <T>
 */
public class PageResult<T> extends AbstractEntity {

    private static final long serialVersionUID = 7472390528893763300L;
    // 页码
    private int pageNo = 1;
    // 每页数量
    private int pageSize = 20;
    // 总页数
    private int totalPage = 0;
    // 总记录数
    private int totalResults = 0;
    // 当前页结果集
    private List<T> results;

    public PageResult() {
    }

    public PageResult(int pageNo, int pageSize, int totalResults, List<T> results) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalResults = totalResults;
        this.results = results;
        int totalPage = totalResults % pageSize == 0 ? totalResults / pageSize : totalResults
                / pageSize + 1;
        this.setTotalPage(totalPage);
    }

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

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
        int totalPage = totalResults % pageSize == 0 ? totalResults / pageSize : totalResults
                / pageSize + 1;
        this.setTotalPage(totalPage);
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

}
