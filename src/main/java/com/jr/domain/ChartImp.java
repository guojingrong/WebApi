package com.jr.domain;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jr.mysql.SessionFactory;
import com.jr.service.ChartMapper;

public class ChartImp implements ChartMapper {

	private SqlSessionFactory sessionFactory;
	
	public ChartImp() {
		sessionFactory=SessionFactory.getFactoryIntance();
	}
	
	@Override
	public HashMap<String, Object> sumChartForAge() {
		// TODO Auto-generated method stub
		SqlSession session=sessionFactory.openSession();
		try {
			return session.selectOne("sumChartForAge");
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

}
