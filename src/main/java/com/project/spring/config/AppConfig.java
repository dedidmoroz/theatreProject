package com.project.spring.config;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.project.hibernate.dao.DAOImplementation;
import com.project.hibernate.service.ServiceImplementation;
import com.project.main.controllers.FXMLMainPresantation;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses={
			DAOImplementation.class,
			ServiceImplementation.class,
			FXMLMainPresantation.class})
@Import(value = ScreenConfig.class)
public class AppConfig {
	
	@Bean
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/theatre");
		dmds.setUsername("root");
		dmds.setPassword("");
		return dmds;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	

		ClassPathResource resource = new ClassPathResource("/config/hibernate.cfg.xml");
		
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.show_sql", "true");
		
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setConfigLocation(resource);
		sessionFactoryBean.setHibernateProperties(props);
		return sessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager tx(){
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(sessionFactory().getObject());
		return tx;
	}
	
	 
}
