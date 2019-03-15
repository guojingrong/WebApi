package com.jr.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jr.model.DepartmentInfo;
import com.jr.model.PageResult;
/**
 * 
 * @author Administrator
 *
 */
public interface DeptMapper {
	/**
	 * 返回部门列表
	 * 
	 * @return
	 */
	public List<DepartmentInfo> getDeptList();

	/**
	 * 分页返回部门列表
	 * 
	 * @return
	 */
	public PageResult getDeptListByPage(HashMap<String, Object> map);

	public Integer getDeptCount(HashMap<String, Object> map);

	/**
	 * 新增部门
	 * 
	 * @param dept
	 * @return
	 */
	public String insertDept(DepartmentInfo dept);

	/**
	 * 修改部门
	 * 
	 * @param dept
	 * @return
	 */
	public int modifyDept(DepartmentInfo dept);

	public int modifyStatus(String id);
	
	/**
	 * 根据部门编号返回部门
	 * 
	 * @param code
	 * @return
	 */
	public DepartmentInfo getDeptByCode(@Param("code") String code);

	/**
	 * 根据ID返回部门
	 * 
	 * @param id
	 * @return
	 */
	public DepartmentInfo getDeptById(@Param("id") String id);

}
