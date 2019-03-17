package com.jr.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import com.jr.domain.DeptPositionImp;

public class DepartmentTest {
	@Test
	public void test1() {
//		Session session=new Session();
//		SqlSession sqlSession = session.CreateSession();
//		System.out.println(sqlSession);

//		DepartmentImp depart=new DepartmentImp();
//		List<DepartmentInfo> list = depart.getDeptList();
//		for (DepartmentInfo departmentInfo : list) {
//			System.out.println(departmentInfo.getDeptName());
//		}

		DeptPositionImp dpImp = new DeptPositionImp();
		List<Map<String, Object>> list = dpImp.getDeptPosition();
		for (Iterator<Map<String, Object>> iterator = list.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			System.out.println(map);
			for (Entry<String, Object> entry : map.entrySet()) {
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
		} 
		
		
//		for (Object key : map.keySet()) {
//			Object v = map.get(key);
//			System.out.println("key=" + key + "****value:" + v);
//		}
	}
}
