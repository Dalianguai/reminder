package com.ibm.iga.reminder.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.ibm.iga.reminder.dao")
//@PropertySource("classpath:/db.properties")
public class MyBatisConfig {

	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		/*System.out.println("driver is         -------------" + env.getProperty("db.driver"));
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUsername(env.getProperty("db.user"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setPassword(env.getProperty("db.password"));*/
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("reminder");
		dataSource.setUrl("jdbc:mysql://129.41.143.36:3306/reminder");
		dataSource.setPassword("reminder");
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setTypeAliasesPackage("com.ibm.iga.reminder.model");
		return sessionFactory.getObject();
	}
}
