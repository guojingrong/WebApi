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
	 * ���ز����б�
	 * 
	 * @return
	 */
	public List<DepartmentInfo> getDeptList();

	/**
	 * ��ҳ���ز����б�
	 * 
	 * @return
	 */
	public PageResult getDeptListByPage(HashMap<String, Object> map);

	public Integer getDeptCount(HashMap<String, Object> map);

	/**
	 * ��������
	 * 
	 * @param dept
	 * @return
	 */
	public String insertDept(DepartmentInfo dept);

	/**
	 * �޸Ĳ���
	 * 
	 * @param dept
	 * @return
	 */
	public int modifyDept(DepartmentInfo dept);

	public int modifyStatus(String id);
	
	/**
	 * ���ݲ��ű�ŷ��ز���
	 * 
	 * @param code
	 * @return
	 */
	public DepartmentInfo getDeptByCode(@Param("code") String code);

	/**
	 * ����ID���ز���
	 * 
	 * @param id
	 * @return
	 */
	public DepartmentInfo getDeptById(@Param("id") String id);

}
