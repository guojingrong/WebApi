package com.jr.model;


/**
 * ��ҳ����
 * @author Administrator
 *
 */
public class PageResult {
	
	public PageResult() {}
	/**
	 * ���ι���
	 * @param _row ������
	 * @param _list ����
	 */
	public PageResult(Integer _row,Object _list) {
		this.total=_row;
		this.list=_list;
	}
	
	/**
	 * ������
	 */
	public Integer total;
	/**
	 * ����
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
