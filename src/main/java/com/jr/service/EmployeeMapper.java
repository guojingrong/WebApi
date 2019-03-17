package com.jr.service;

import java.util.HashMap;

import com.jr.model.EmpBaseInfo;
import com.jr.model.PageResult;

public interface EmployeeMapper {
	/**
	 * ��ҳ��ѯԱ����Ϣ
	 * @param map
	 * @return
	 */
	public PageResult getEmpListByPage(HashMap<String, Object> map);
	
	/**
	 * ��������ɸѡ�������������ҳʹ�ã�
	 * @param map
	 * @return
	 */
	public int getEmpCount(HashMap<String, Object> map);
	
	/**
	 * ���Ա��
	 * @param emp
	 * @return
	 */
	public String insertEmployee(EmpBaseInfo emp);
	
	/**
	 * �༭Ա��
	 * @param emp
	 * @return
	 */
	public int modifyEmployee(EmpBaseInfo emp);
	
	/**
	 * ���ݹؼ����ж�Ա���Ƿ����
	 * @param key
	 * @return
	 */
	public boolean judgeIsExists(String key);
	
	/**
	 * ����Ա�����
	 * @return
	 */
	public String getEmpCode();
	
	/**
	 * ����Ա��id����Ա����Ϣ
	 * @param Id
	 * @return
	 */
	public EmpBaseInfo getEmpById(String Id);
}
