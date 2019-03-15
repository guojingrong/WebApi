package com.jr.model;


/**
 * 分页数据
 * @author Administrator
 *
 */
public class PageResult {
	
	public PageResult() {}
	/**
	 * 带参构造
	 * @param _row 总条数
	 * @param _list 数据
	 */
	public PageResult(Integer _row,Object _list) {
		this.total=_row;
		this.list=_list;
	}
	
	/**
	 * 总条数
	 */
	public Integer total;
	/**
	 * 数据
	 */
	public Object list;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Object getList() {
		return list;
	}
	public void setList(Object list) {
		this.list = list;
	}
	
	
}
