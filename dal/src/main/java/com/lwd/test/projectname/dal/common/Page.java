package com.lwd.test.projectname.dal.common;


import com.lwd.test.projectname.common.AbstractEntity;

public class Page<T> extends AbstractEntity implements Paginable<T> {

	/**
     * 
     */
	private static final long	serialVersionUID	= -8300028418460452542L;

	private int	              pageNo	         = 1;	                     // 页码

	private int	              pageSize	         = 20;	                     // 每页记录数

	private int	              totalCount	     = 0;	                     // 总记录数

	private int	              totalPage	         = 0;	                     // 总页数

	private int	              offset	         = 0;

	private int	              startRow	         = 0;

	private int	              endRow	         = 0;

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

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		this.setTotalPage(totalPage);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	@Override
	public boolean isFirstPage() {
		return pageNo <= 1;
	}

	@Override
	public boolean isLastPage() {
		return pageNo >= totalPage;
	}

	@Override
	public int getNextPage() {
		return isLastPage() ? pageNo : (pageNo + 1);
	}

	@Override
	public int getPrePage() {
		return isFirstPage() ? pageNo : (pageNo - 1);
	}

	public int getOffset() {
	    return offset;
    }

	public void setOffset(int offset) {
	    this.offset = offset;
    }

}
