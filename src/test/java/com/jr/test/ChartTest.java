package com.jr.test;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.Test;

import com.jr.domain.ChartImp;

public class ChartTest {
	@Test
	public void TestOne() {
		ChartImp chartImp=new ChartImp();
		HashMap<String, Object> hashMap =chartImp.sumChartForAge();
		for (Iterator<String> iterator = hashMap.keySet().iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			Object valString =hashMap.get(type); 
			System.out.println(type+"*****"+valString);
		}
	}
}
