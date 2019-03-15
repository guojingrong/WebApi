package com.jr.mysql;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
//	SqlSessionFactoryBuilder
//	�������Ա�ʵ������ʹ�úͶ�����һ�������� SqlSessionFactory���Ͳ�����Ҫ���ˡ�
//	��� SqlSessionFactoryBuilder ʵ��������������Ƿ���������Ҳ���Ǿֲ�������������
//	��������� SqlSessionFactoryBuilder ��������� SqlSessionFactory ʵ����
//	������û��ǲ�Ҫ����һֱ�����Ա�֤���е� XML ������Դ���Ÿ�����Ҫ�����顣
//
//	SqlSessionFactory
//	SqlSessionFactory һ����������Ӧ����Ӧ�õ������ڼ�һֱ���ڣ�û���κ����ɶ�������������ؽ���
//	ʹ�� SqlSessionFactory �����ʵ������Ӧ�������ڼ䲻Ҫ�ظ�������Σ�
//	����ؽ� SqlSessionFactory ����Ϊһ�ִ��롰��ζ����bad smell������
//	��� SqlSessionFactory �������������Ӧ���������кܶ෽��������������򵥵ľ���ʹ�õ���ģʽ���߾�̬����ģʽ��
//
//	SqlSession
//	ÿ���̶߳�Ӧ�������Լ��� SqlSession ʵ����
//	SqlSession ��ʵ�������̰߳�ȫ�ģ�����ǲ��ܱ�����ģ�����������ѵ�������������򷽷�������
//	���Բ��ܽ� SqlSession ʵ�������÷���һ����ľ�̬������һ�����ʵ������Ҳ���С�
//	Ҳ�����ܽ� SqlSession ʵ�������÷����κ����͵Ĺ����������У����� Servlet �ܹ��е� HttpSession��
//	�������������ʹ��һ�� Web ��ܣ�Ҫ���� SqlSession ����һ���� HTTP ����������Ƶ��������С�
//	���仰˵��ÿ���յ��� HTTP ���󣬾Ϳ��Դ�һ�� SqlSession������һ����Ӧ���͹ر�����
//	����رղ����Ǻ���Ҫ�ģ���Ӧ�ð�����رղ����ŵ� finally ������ȷ��ÿ�ζ���ִ�йرա�

	private static SqlSessionFactory sqlSessionFactory = null;

	public static SqlSessionFactory getFactoryIntance() {
		if (sqlSessionFactory == null) {
			String path = "mybatis-config.xml";
			InputStream stream = null;
			try {
				stream = Resources.getResourceAsStream(path);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}
}
