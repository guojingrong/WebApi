package com.jr.model;

/**
  *  部门岗位关系
 * @author Administrator
 *
 */
public class DeptPosition {
	private String id;
	private String deptId;
	private String positionId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getPositionId() {
		return positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	
	
}
