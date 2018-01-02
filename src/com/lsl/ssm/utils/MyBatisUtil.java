package com.lsl.ssm.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	private static SqlSessionFactory factory;
	
	static { // 在静态代码块下,factory只会被创建一次
		System.out.println("static factory==============");
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 打开SqlSession
	 * @return
	 */
	public static SqlSession createSqlSession() {
		return factory.openSession(false); // true 为自动提交事务 默认为true
	}
	
	/**
	 * 关闭SqlSession
	 * @param sqlsession
	 */
	public static void closeSqlSession(SqlSession sqlsession) {
		if (null != sqlsession) {
			sqlsession.close();
		}
	}
}
