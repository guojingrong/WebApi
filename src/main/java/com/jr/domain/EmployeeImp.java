package com.jr.domain;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jr.model.EmpBaseInfo;
import com.jr.model.PageResult;
import com.jr.mysql.SessionFactory;
import com.jr.service.EmployeeMapper;

public class EmployeeImp implements EmployeeMapper {

	private SqlSessionFactory sessionFactory;

	public EmployeeImp() {
		this.sessionFactory = SessionFactory.getFactoryIntance();
	}

	public PageResult getEmpListByPage(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		SqlSession session = sessionFactory.openSession();
		try {
			List<EmpBaseInfo> list = session.selectList("getEmpListByPage", map);
			Integer total = this.getEmpCount(map);
			return new PageResult(total, list);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	public int getEmpCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		int count = 0;
		SqlSession session = sessionFactory.openSession();
		try {
			count = session.selectOne("getEmpCount", map);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return count;
	}

	public String insertEmployee(EmpBaseInfo emp) {
		// TODO Auto-generated method stub
		SqlSession session = sessionFactory.openSession();
		try {
			session.insert("insertEmployee", emp);
			session.commit();
			return emp.getId();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	public boolean judgeIsExists(String key) {
		// TODO Auto-generated method stub
		SqlSession session = sessionFactory.openSession();
		try {
			EmpBaseInfo emp = session.selectOne("judgeIsExists", key);
			return emp != null ? true : false;
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	public String getEmpCode() {
		// TODO Auto-generated method stub
		SqlSession session = sessionFactory.openSession();
		try {
			int code = session.selectOne("getEmpCode");
			return Integer.toString(code + 1);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	@Override
	public EmpBaseInfo getEmpById(String Id) {
		// TODO Auto-generated method stub
		SqlSession session=sessionFactory.openSession();
		try {
			return session.selectOne("getEmpById", Id);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	@Override
	public int modifyEmployee(EmpBaseInfo emp) {
		// TODO Auto-generated method stub
		SqlSession session=sessionFactory.openSession();
		try {
			int count = session.update("modifyEmployee", emp);
			session.commit();
			return count;
		} finally {
			// TODO: handle finally clause
			session.close();
			
		}
	}

}
