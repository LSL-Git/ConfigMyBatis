package test.com.lsl.ssm.dao.provider;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.lsl.ssm.dao.ProviderMapper;
import com.lsl.ssm.pojo.Provider;
import com.lsl.ssm.utils.MyBatisUtil;

public class ProviderMapperTest {
	private Logger logger = Logger.getLogger(ProviderMapperTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetProviderList() {
		SqlSession sqlSession = null;
		List<Provider> providerList = new ArrayList<Provider>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();

			// 方式一:调用selectList方法执行查询操作
			// providerList =
			// sqlSession.selectList("com.lsl.ssm.dao.ProviderMapper.getProviderList");

			// 方式二:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
			providerList = sqlSession.getMapper(ProviderMapper.class)
					.getProviderList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		// 打印List
		for (Provider provider : providerList) {
			logger.debug("ProviderList proCode:" + provider.getProCode()
					+ " and proName:" + provider.getProName());
		}
	}

	@Test
	public void testCount() {
		String resource = "mybatis-config.xml";
		int count = 0;
		SqlSession sqlSession = null;
		try {
//			// 1 获取mybatis-config.xml的输入流
//			InputStream is = Resources.getResourceAsStream(resource);
//			// 2 创建SqlSessionFactory对象，完成对配置文件的读取
//			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
//					.build(is);
//			// 3 创建sqlSession
//			sqlSession = factory.openSession();
//			// 4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
//			count = sqlSession
//					.selectOne("com.lsl.ssm.dao.ProviderMapper.count");
//			logger.debug("ProviderMapperTest count---> " + count);
			
			
			sqlSession = MyBatisUtil.createSqlSession();
			
			//第一种方式:调用selectOne方法执行查询操作
			//count = sqlSession.selectOne("cn.smbms.dao.provider.ProviderMapper.count");
			
			//第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
			count = sqlSession.getMapper(ProviderMapper.class).count();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
//			sqlSession.close();
		}
		logger.debug("ProviderDaoTest testCount---> " + count);
	}
}
