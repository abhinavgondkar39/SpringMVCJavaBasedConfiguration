package com.ab9.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebMvc // to tell it is spring mvc configuration
@Configuration // to make bean configuration
@ComponentScan(basePackages = {"com.ab9.*"}) // go to that package and scan component's childs like @service @component @controller
public class SpringConfiguration extends WebMvcConfigurerAdapter  {
	
	@Bean // creation of object through the spring annotation
	public ViewResolver viewResolver() {
		//to resolve which view have to show
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class); // class-lib provides viewresolver
		viewResolver.setPrefix("/WEB-INF/views/"); // all views 
		viewResolver.setSuffix(".jsp"); // extension
		return viewResolver;
	}
	
	/**
	 * db mapping through the (spring component) 
	 * which internally uses hibernate  properties
	 */
	@Bean 
	public BasicDataSource getBasicDataSource(){
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/empdb");
		bds.setUsername("root");
		bds.setPassword("root");
		return bds;
	}
	
	
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(getBasicDataSource());
		lsfb.setPackagesToScan(new String[]{"com.ab9.entities"});
		lsfb.setHibernateProperties(getProperties());

		return lsfb;
	}

	/**
	 * properties - collection (legacy class)
	 * used to set hibernate properties
	 */
	@Bean
	public Properties getProperties() {
		Properties p = new Properties();
		p.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		p.put("hibernate.hbm2ddl.auto", "update");
		p.put("hibernate.show_sql", "true");
		p.put("hibernate.format_sql", "true");
		return p;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureDefaultServletHandling(configurer);
		configurer.enable();
	}
}
