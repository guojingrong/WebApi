package com.jr.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.jr.model.Positional;
import com.jr.mysql.SessionFactory;
import com.jr.service.DeptPositionMapper;

public class DeptPositionImp implements DeptPositionMapper {

	private SqlSessionFactory sessionFactory;

	public DeptPositionImp() {
		this.sessionFactory = SessionFactory.getFactoryIntance();
	}

	public List<Map<String, Object>> getDeptPosition() {
		// TODO Auto-generated method stub
		SqlSession session = sessionFactory.openSession();
		try {
			return session.selectList("getDeptPosition");
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	public List<Positional> getPositionByDept(String code) {
		// TODO Auto-generated method stub
		SqlSession session=sessionFactory.openSession();
		try {
			return session.selectList("getPositionByDept", code);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	public List<Positional> getPosition(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		SqlSession session=sessionFactory.openSession();
		try {
			return session.selectList("getPosition",map);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	@Override
	public int addPosDeptRef() {
		// TODO Auto-generated method stub
		return 0;
	}

}
