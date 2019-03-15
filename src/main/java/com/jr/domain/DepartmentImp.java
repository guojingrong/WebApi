package com.jr.domain;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jr.model.DepartmentInfo;
import com.jr.model.PageResult;
import com.jr.mysql.SessionFactory;
import com.jr.service.DeptMapper;

/**
 * 
 * @author Administrator
 *
 */
public class DepartmentImp implements DeptMapper {

	private SqlSessionFactory sessionFactory;

	public DepartmentImp() {
		this.sessionFactory = SessionFactory.getFactoryIntance();
	}

	public List<DepartmentInfo> getDeptList() {
		// TODO Auto-generated method stub
		SqlSession session = sessionFactory.openSession();
		try {
			return session.selectList("getDeptList");
		} finally {
			// TODO: handle finally clause
			session.close();
		}

	}

	public String insertDept(DepartmentInfo dept) {
		// TODO Auto-generated method stub
		SqlSession session = sessionFactory.openSession();
		try {
			session.insert("insertDept", dept);
			session.commit();
			return dept.getId();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	public int modifyDept(DepartmentInfo dept) {
		// TODO Auto-generated method stub
		int count=0;
		SqlSession session=sessionFactory.openSession();
		try {
			count =session.update("modifyDept", dept);
			session.commit();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return count;
	}

	public DepartmentInfo getDeptByCode(String code) {
		// TODO Auto-generated method stub
		SqlSession session = sessionFactory.openSession();
		try {
//			return session.selectOne("getDeptByCode", code);
			DeptMapper mapper = session.getMapper(DeptMapper.class);
			return mapper.getDeptByCode(code);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	public DepartmentInfo getDeptById(String id) {
		// TODO Auto-generated method stub
		SqlSession session = sessionFactory.openSession();
		try {
			return session.selectOne("getDeptById", id);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	public Integer getDeptCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		SqlSession session = sessionFactory.openSession();
		try {
			return session.selectOne("getDeptCount", map);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}


	public PageResult getDeptListByPage(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		SqlSession session = sessionFactory.openSession();
		try {
			Object list = session.selectList("getDeptListByPage", map);
			Integer total = this.getDeptCount(map);
			return new PageResult(total,list);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	public int modifyStatus(String id) {
		// TODO Auto-generated method stub
		int count=0;
		SqlSession session=sessionFactory.openSession();
		try {
			session.update("modifyStatus", id);
			session.commit();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return count;
	}

}
