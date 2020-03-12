package com.hibernate.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class BeanConfiguration {

	@Autowired
	private AppConfig appConfig;

	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", appConfig.getDialect().trim());
		properties.put("hibernate.show_sql", appConfig.getShowSQL());
		properties.put("hibernate.format_sql", appConfig.getFormatSQL());
		return properties;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(appConfig.getJdbcDriverClass().trim());
		driverManagerDataSource.setUrl(appConfig.getUrl().trim());
		driverManagerDataSource.setUsername(appConfig.getUsername().trim());
		driverManagerDataSource.setPassword(appConfig.getPassword().trim());
		return driverManagerDataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setHibernateProperties(hibernateProperties());
		localSessionFactoryBean.setPackagesToScan(new String[] { "com.hibernate" });
		return localSessionFactoryBean;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}

}
