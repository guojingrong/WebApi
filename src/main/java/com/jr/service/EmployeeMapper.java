package com.jr.service;

import java.util.HashMap;

import com.jr.model.EmpBaseInfo;
import com.jr.model.PageResult;

public interface EmployeeMapper {
	/**
	 * 分页查询员工信息
	 * @param map
	 * @return
	 */
	public PageResult getEmpListByPage(HashMap<String, Object> map);
	
	/**
	 * 返回条件筛选后的总条数（分页使用）
	 * @param map
	 * @return
	 */
	public int getEmpCount(HashMap<String, Object> map);
	
	/**
	 * 添加员工
	 * @param emp
	 * @return
	 */
	public String insertEmployee(EmpBaseInfo emp);
	
	/**
	 * 编辑员工
	 * @param emp
	 * @return
	 */
	public int modifyEmployee(EmpBaseInfo emp);
	
	/**
	 * 根据关键字判断员工是否存在
	 * @param key
	 * @return
	 */
	public boolean judgeIsExists(String key);
	
	/**
	 * 返回员工编号
	 * @return
	 */
	public String getEmpCode();
	
	/**
	 * 根据员工id返回员工信息
	 * @param Id
	 * @return
	 */
	public EmpBaseInfo getEmpById(String Id);
}
