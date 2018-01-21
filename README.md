# ConfigMyBatis

**SSM 框架学习 (MyBatis篇)**

一、MyBatis 的基本配置

名词解释:

*SSM（Spring+SpringMVC+MyBatis）框架集由Spring、SpringMVC、MyBatis三个开源框架整合而成*   
*DAO (Data Access Object) 数据库访问对象*    
*POJO (Plain Old Java Object) 简单的Java对象 实体类*	   
   
    
1、导入必要架包
|-mybatis-3.2.2.jar
|-mysql-connector-java-5.1.0-bin.jar
   
2、创建资源文件夹resources并创建 数据库属性文件(database.properties 非必需) mybatis配置文件(mybatis-config.xml 必须，名字不限) 其内容：
*database.properties*
```
# 连接数据库信息
driver=com.mysql.jdbc.Driver
#在和mysql传递数据的过程中，使用unicode编码格式，并且字符集设置为utf-8
url=jdbc:mysql://127.0.0.1:3306/smbms?useUnicode=true&characterEncoding=utf-8
user=root
password=root 
```
*mybatis-config.xml*
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">

<!-- 通过这个配置文件完成mybaits与数据库的链接 -->
<configuration>
	<!-- 引入database.properties文件 配置resource优先级高于 property节点-->
	<!--<properties resource="database.properties" />-->
	
	<!--<properties>
		<property name="driver" value="com.mysql.jdbc.Driver"/>
		<property name="url" value="jdbc:mysql://127.0.0.1:3306/smbms"/>
		<property name="user" value="root"/>
		<property name="password" value="root"/>	
	</properties>-->
	
	<properties resource="database.properties">
		<property name="driver" value="com.mysql.jdbc.Driver"/>
		<property name="url" value="jdbc:mysql://127.0.0.1:3306/smbms"/>
		<property name="user" value="root"/>
		<property name="password" value="root"/>	
	</properties>
	
	<!-- 配置mybatis的log实现为LOG4J -->
	<settings>
		<setting name="logImpl" value="LOG4J" />
	</settings>
	
	<!-- 类型别名,这里定义别名ProviderMapper就可以使用别名了.仅仅只关联XML配置，简写冗长的Java类名 -->
	<typeAliases>
		<typeAlias alias="mProvider" type="com.lsl.ssm.pojo.Provider"/>
		<!--<package name="com.lsl.ssm.pojo"/>-->
	</typeAliases>

	<!-- default设置默认环境为哪个 -->
	<environments default="test">		
		<environment id="test">
			<!-- 配置事务管理为 采用JDBC事务管理 -->
			<transactionManager type="JDBC"></transactionManager>
			<!-- POOLED:mybatis自带的数据源,JNDI:基于tomcat的数据源 -->
			<dataSource type="POOLED">
				<property name="driver" value="${driver}" />
				<property name="url" value="${url}" />
				<property name="username" value="${user}" />
				<property name="password" value="${password}" />
			</dataSource>
		</environment>
	</environments>

	<!-- 将mapper文件加入到配置文件中 -->
	<mappers>
		<mapper resource="com/lsl/ssm/dao/ProviderMapper.xml" />
		<!--<mapper url="file:///E:/Myeclipse/SSM/ConfigMyBatis/src/com/lsl/ssm/dao/ProviderMapper.xml"/>-->
	</mappers>
</configuration>
```



@Author 瞌睡虫   
@mybatis-3.2.2   
@Database: mysql 5.7.15   
@Tool: MyEclipse
