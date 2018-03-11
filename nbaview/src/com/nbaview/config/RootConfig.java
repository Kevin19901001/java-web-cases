package com.nbaview.config;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * To config database connection.
 * @author Kevin
 */
@Configuration
@ComponentScan(basePackages={"com.nbaview"}, excludeFilters={ @Filter(type=FilterType.ANNOTATION, value=Configuration.class), @Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class) })
public class RootConfig {

	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/javaweb");
		dataSource.setUsername("root");
		dataSource.setPassword("Fhq19901001");
		dataSource.setInitialSize(5);
		dataSource.setMaxActive(10);
		return dataSource;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate(BasicDataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	
}
