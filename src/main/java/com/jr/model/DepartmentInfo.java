package com.jr.model;

import org.apache.ibatis.type.Alias;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Administrator
 *
 */
@Alias("dept")
@ApiModel(value="DepartmentInfo")
public class DepartmentInfo {
	@ApiModelProperty(value="ID")
	private String id;
	@ApiModelProperty(value="≤ø√≈±‡∫≈")
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
