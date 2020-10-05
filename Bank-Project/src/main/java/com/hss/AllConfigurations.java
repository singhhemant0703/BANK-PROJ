package com.hss;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@EnableJpaRepositories("com.hss.repository")
@ComponentScan(basePackages ={"com.hss.service","com.hss.controller"})
public class AllConfigurations extends WebMvcConfigurerAdapter{

	@Bean
	public DataSource getDataSource() {
		HikariDataSource hkds=new HikariDataSource();
		hkds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hkds.setJdbcUrl("jdbc:mysql://localhost:3306/HSB_Bank?createDatabaseIfNotExist=true");
		hkds.setUsername("root");
		hkds.setPassword("root");
		return hkds;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean fb=new LocalContainerEntityManagerFactoryBean();
		fb.setDataSource(getDataSource());
		fb.setPackagesToScan(new String[] {"com.hss.model"} );
		JpaVendorAdapter vendor=new HibernateJpaVendorAdapter();
		fb.setJpaVendorAdapter(vendor);
		fb.setJpaProperties(getAdditionalProperties());
		
		return fb;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transaction=new JpaTransactionManager();
		transaction.setEntityManagerFactory(entityManagerFactory().getObject());
		return transaction;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor getExceptionProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	@Bean
	public Properties getAdditionalProperties() {
		Properties props=new Properties();
		props.setProperty("hibernate.hbm2ddl.auto","update");
		props.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
	    return props;
		}
	@Bean
	public ViewResolver getResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
