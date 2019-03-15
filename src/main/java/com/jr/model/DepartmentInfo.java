package com.jr.model;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @author Administrator
 *
 */
@Alias("dept")
public class DepartmentInfo {
	private String id;
	private String deptCode;
	private String deptName;
	private Integer status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
